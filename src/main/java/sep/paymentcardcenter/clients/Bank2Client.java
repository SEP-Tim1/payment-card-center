package sep.paymentcardcenter.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sep.paymentcardcenter.dtos.PCCRequestDTO;
import sep.paymentcardcenter.dtos.PCCResponseDTO;

@FeignClient(url= "${bank2.url}", name = "second-bank")
public interface Bank2Client {
        @PostMapping("receiveRequestFromPCC")
        PCCResponseDTO sendToBank2(@RequestBody PCCRequestDTO dto);
}
