package sep.paymentcardcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentCardCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentCardCenterApplication.class, args);
    }

}
