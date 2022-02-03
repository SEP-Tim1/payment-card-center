package sep.paymentcardcenter.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sep.paymentcardcenter.dtos.PCCResponseDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "response")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "response_generator")
    @SequenceGenerator(name="response_generator", sequenceName = "response_seq", initialValue = 10)
    private long id;

    @Column
    @NotNull
    private String status;

    @Column
    @NotNull
    private long acquirerOrderId;

    @Column
    @NotNull
    private LocalDateTime acquirerTimestamp;

    @Column
    @NotNull
    private long issuerOrderId;

    @Column
    @NotNull
    private LocalDateTime issuerTimestamp;

    @Column
    @NotNull
    private long fromId;

    public Response(PCCResponseDTO dto){
        this.status = dto.getStatus();
        this.acquirerOrderId = dto.getAcquirerOrderId();
        this.acquirerTimestamp = dto.getAcquirerTimestamp();
        this.issuerOrderId = dto.getIssuerOrderId();
        this.issuerTimestamp = dto.getIssuerTimestamp();
        this.fromId = dto.getFromId();
    }
}
