package coderslab.pl.accountingProgram.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Getter
@Setter
@ToString
@Entity

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Company company;

    @NotBlank (message = "Please add an invoice number")
    private String invoiceNumber;

    @OneToOne
    @NotNull (message = "Please select a direction")
    private InvoiceDirection invoiceDirection;

    @NotBlank (message = "Please select a date")
    private String date;

    @Column(precision = 7, scale = 2)
    private BigDecimal amountNetto;

    @OneToOne
    @NotNull(message = "Please choose value of vat")
    private Vat vat;

    @Column(precision = 7, scale = 2)
    private BigDecimal amountBrutto;



}
