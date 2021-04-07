package coderslab.pl.accountingProgram.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Transactional
@Proxy(lazy = false)
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @NotBlank
    private String invoiceNumber;

    @OneToOne
    private InvoiceDirection invoiceDirection;

    @NotBlank
    private String date;


    private double amountNetto;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Vat vat;

    private double amountBrutto;



}
