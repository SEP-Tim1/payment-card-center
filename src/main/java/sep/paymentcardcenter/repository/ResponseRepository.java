package sep.paymentcardcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sep.paymentcardcenter.model.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
