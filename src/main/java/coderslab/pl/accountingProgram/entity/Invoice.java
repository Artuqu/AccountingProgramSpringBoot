package coderslab.pl.accountingProgram.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Entity

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Company company;

    @NotBlank (message = "Please add an invoice number")
    private String invoiceNumber;

    @OneToOne
    @NotNull (message = "Please select a direction")
    private InvoiceDirection invoiceDirection;

    @NotBlank (message = "Please select a date")
    private String date;

    private double amountNetto;

    @OneToOne
    @NotNull(message = "Please choose value of vat")
    private Vat vat;

    private double amountBrutto;


}
