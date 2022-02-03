package sep.paymentcardcenter.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sep.paymentcardcenter.dtos.PCCRequestDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "request")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_generator")
    @SequenceGenerator(name="request_generator", sequenceName = "request_seq", initialValue = 10)
    private long id;

    @NotNull
    @Column
    private long acquirerOrderId;

    @NotNull
    @Column
    private LocalDateTime acquirerTimeStamp;

    @NotNull
    @Column
    private String panNumber;

    @NotNull
    @Column
    private String cardHolderName;

    @NotNull
    @Column
    private String expiratoryDate;

    @NotNull
    @Column
    private String securityCode;

    @NotNull
    @Column
    private BigDecimal amount;

    @NotNull
    @Column
    private String currency;

    @NotNull
    @Column
    private long toId;

    public Request(PCCRequestDTO dto) {
        this.acquirerOrderId = dto.getAcquirerOrderId();
        this.acquirerTimeStamp = dto.getAcquirerTimeStamp();
        this.panNumber = dto.getPanNumber();
        this.cardHolderName = dto.getCardHolderName();
        this.expiratoryDate = dto.getExpiratoryDate();
        this.securityCode = dto.getSecurityCode();
        this.amount = dto.getAmount();
        this.currency = dto.getCurrency();
        this.toId = dto.getToId();
    }
}
