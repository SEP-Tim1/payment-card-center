package sep.paymentcardcenter.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sep.paymentcardcenter.dtos.PCCRequestDTO;
import sep.paymentcardcenter.dtos.PCCResponseDTO;
import sep.paymentcardcenter.exceptions.BankNotFoundException;
import sep.paymentcardcenter.service.PccService;

@RestController
@RequestMapping("pcc")
public class PccController {

    private final PccService pccService;

    public PccController(PccService pccService) {
        this.pccService = pccService;
    }

    @PostMapping(value = "transfer")
    public PCCResponseDTO transferMoney(@RequestBody PCCRequestDTO requestDTO) throws BankNotFoundException {
        return pccService.transfer(requestDTO);
    }
}
