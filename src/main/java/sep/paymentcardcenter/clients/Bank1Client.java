package sep.paymentcardcenter.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sep.paymentcardcenter.dtos.PCCRequestDTO;
import sep.paymentcardcenter.dtos.PCCResponseDTO;

import java.net.URI;

@FeignClient(url= "${bank1.url}", name = "first-bank")
public interface Bank1Client {
        @PostMapping("receiveRequestFromPCC")
        PCCResponseDTO sendToBank1(@RequestBody PCCRequestDTO dto);
}
