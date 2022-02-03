package sep.paymentcardcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sep.paymentcardcenter.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
