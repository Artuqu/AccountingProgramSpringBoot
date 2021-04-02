package coderslab.pl.accountingProgram.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
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



}