package sep.paymentcardcenter.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sep.paymentcardcenter.dtos.PCCRequestDTO;

@RestController
@RequestMapping("pcc")
public class PccController {

    @PostMapping(value = "transfer")
    public ResponseEntity transferMoney(@RequestBody PCCRequestDTO requestDTO) {
        return null;
    }
}
