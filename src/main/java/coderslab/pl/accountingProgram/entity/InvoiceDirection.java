package coderslab.pl.accountingProgram.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Transactional
@Proxy(lazy = false)
@Entity
public class InvoiceDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String direction;

}
