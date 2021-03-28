package coderslab.pl.accountingProgram.entity;


import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.*;

@Proxy(lazy = false)// otwiera sesję i daje dostęp do bazy danych
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name can't be null!")
    private String name;
    //notnull tylko dla obiektu
    @NotBlank
    private String address;

    @Email(message = "enter a correct address")
    @Column(unique = true)//daje unikatowy adres mailowy
    private String email;

    @NotBlank
    @NIP
    private String NIP;

    @Size(min = 26, max = 26)
    private String bankAccount;

//    @OneToMany(fetch = FetchType.EAGER)// rozwiązanie problemu z brakiem sesji
//    private List<Invoice> invoices;

    public Company() {
    }

    public long getId() {
        return id;
    }

    public Company setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Company setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Company setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNIP() {
        return NIP;
    }

    public Company setNIP(String NIP) {
        this.NIP = NIP;
        return this;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public Company setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

//    public List<Invoice> getInvoices() {
//        return invoices;
//    }
//
//    public Company setInvoices(List<Invoice> invoices) {
//        this.invoices = invoices;
//        return this;
//    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", NIP='" + NIP + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
//                ", invoices=" + invoices +
                '}';
    }
}
