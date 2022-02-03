package sep.paymentcardcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import sep.paymentcardcenter.clients.Bank1Client;
import sep.paymentcardcenter.clients.Bank2Client;
import sep.paymentcardcenter.dtos.PCCRequestDTO;
import sep.paymentcardcenter.dtos.PCCResponseDTO;
import sep.paymentcardcenter.model.Request;
import sep.paymentcardcenter.model.Response;
import sep.paymentcardcenter.repository.RequestRepository;
import sep.paymentcardcenter.repository.ResponseRepository;

import java.time.LocalDateTime;

@Service
public class PccService {

    private static final String BANK1_NUMBER = "00000";
    private static final String BANK2_NUMBER = "00001";
    private final Bank1Client bank1Client;
    private final Bank2Client bank2Client;
    private final RequestRepository requestRepository;
    private final ResponseRepository responseRepository;

    @Autowired
    public PccService(Bank1Client bank1Client1, Bank2Client bank2Client1, RequestRepository requestRepository, ResponseRepository responseRepository){
        this.bank1Client = bank1Client1;
        this.bank2Client = bank2Client1;
        this.requestRepository = requestRepository;
        this.responseRepository = responseRepository;
    }

    public PCCResponseDTO transfer(PCCRequestDTO dto) {
        requestRepository.save(new Request(dto));
        String bankId = dto.getPanNumber().substring(1,6);
        PCCResponseDTO response;
        if(bankId.equals(BANK1_NUMBER)){
            try {
                response = bank1Client.sendToBank1(dto);
            } catch (HttpClientErrorException | HttpServerErrorException e) {
                response = new PCCResponseDTO("BANK1_NOT_RESPONDING", dto.getAcquirerOrderId(), dto.getAcquirerTimeStamp(), dto.getToId(), LocalDateTime.now(),  -1);
            }
        } else if (bankId.equals(BANK2_NUMBER)) {
            try {
                response = bank2Client.sendToBank2(dto);
            } catch (HttpClientErrorException | HttpServerErrorException e) {
                response = new PCCResponseDTO("BANK2_NOT_RESPONDING", dto.getAcquirerOrderId(), dto.getAcquirerTimeStamp(), dto.getToId(), LocalDateTime.now(),  -1);
            }
        } else {
            response = new PCCResponseDTO("BANK_NOT_FOUND", dto.getAcquirerOrderId(), dto.getAcquirerTimeStamp(), dto.getToId(), LocalDateTime.now(),  -1);
        }
        responseRepository.save(new Response(response));
        return response;
    }
}
