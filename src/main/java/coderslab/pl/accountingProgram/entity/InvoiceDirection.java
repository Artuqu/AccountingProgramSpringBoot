package coderslab.pl.accountingProgram.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;

@Transactional
@Proxy(lazy = false)
@Entity
public class InvoiceDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String direction;

    public InvoiceDirection() {
    }

    public long getId() {
        return id;
    }

    public InvoiceDirection setId(long id) {
        this.id = id;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public InvoiceDirection setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    @Override
    public String toString() {
        return "InvoiceDirection{" +
                "id=" + id +
                ", direction='" + direction + '\'' +
                '}';
    }
}
