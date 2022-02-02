package sep.paymentcardcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sep.paymentcardcenter.clients.Bank1Client;
import sep.paymentcardcenter.clients.Bank2Client;
import sep.paymentcardcenter.dtos.PCCRequestDTO;
import sep.paymentcardcenter.dtos.PCCResponseDTO;
import sep.paymentcardcenter.exceptions.BankNotFoundException;

@Service
public class PccService {

    private static final String BANK1_NUMBER = "00000";
    private static final String BANK2_NUMBER = "00001";
    private final Bank1Client bank1Client;
    private final Bank2Client bank2Client;

    @Autowired
    public PccService(Bank1Client bank1Client1, Bank2Client bank2Client1){
        this.bank1Client = bank1Client1;
        this.bank2Client = bank2Client1;
    }

    public PCCResponseDTO transfer(PCCRequestDTO dto) throws BankNotFoundException {
        String bankId = dto.getPanNumber().substring(1,6);
        if(bankId.equals(BANK1_NUMBER)){
            return bank1Client.sendToBank1(dto);
        } else if (bankId.equals(BANK2_NUMBER)) {
            return bank2Client.sendToBank2(dto);
        } else throw new BankNotFoundException();
    }
}
