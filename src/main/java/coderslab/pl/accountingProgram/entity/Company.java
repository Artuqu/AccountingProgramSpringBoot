package coderslab.pl.accountingProgram.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.pl.NIP;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

import static javax.persistence.CascadeType.REMOVE;

@Getter
@Setter
@ToString
@Proxy(lazy = false)// rapid load of database
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name can't be null")
    private String name;

    //notnull only fo object
    @NotBlank(message = "address can't be null")
    private String address;

    @Email(message = "enter a correct address")
    @Column(unique = true)//unique e-mail address
    private String email;

    @NotBlank(message = "NIP can't be null")
    @NIP
    private String NIP;

    @Size(min = 26, max = 26, message = "Value has to have 26 numbers")
    private String bankAccount;


    @OneToMany(cascade = REMOVE, fetch = FetchType.EAGER, mappedBy = "company")// orphanRemoval is important for cascade deleting
    private List<Invoice> invoices;
}