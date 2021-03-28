package coderslab.pl.accountingProgram.entity;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    public Invoice() {
    }

    public long getId() {
        return id;
    }

    public Invoice setId(long id) {
        this.id = id;
        return this;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Invoice setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Invoice setDate(String date) {
        this.date = date;
        return this;
    }

    public Vat getVat() {
        return vat;
    }

    public Invoice setVat(Vat vat) {
        this.vat = vat;
        return this;
    }




    public double getAmountNetto() {
        return amountNetto;
    }

    public Invoice setAmountNetto(double amountNetto) {
        this.amountNetto = amountNetto;
        return this;
    }

    public double getAmountBrutto() {
        return amountBrutto;
    }

    public Invoice setAmountBrutto(double amountBrutto) {
        this.amountBrutto = amountBrutto;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Invoice setCompany(Company company) {
        this.company = company;
        return this;
    }

    public InvoiceDirection getInvoiceDirection() {
        return invoiceDirection;
    }

    public Invoice setInvoiceDirection(InvoiceDirection invoiceDirection) {
        this.invoiceDirection = invoiceDirection;
        return this;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", company=" + company +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", invoiceDirection=" + invoiceDirection +
                ", date='" + date + '\'' +
                ", amountNetto=" + amountNetto +
                ", vat=" + vat +
                ", amountBrutto=" + amountBrutto +
                '}';
    }
}
