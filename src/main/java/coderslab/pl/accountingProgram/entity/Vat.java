package coderslab.pl.accountingProgram.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Proxy(lazy = false)
@Entity
public class Vat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String percents;


    private double value;

    public Vat() {
    }

    public String getPercents() {
        return percents;
    }

    public Vat setPercents(String percents) {
        this.percents = percents;
        return this;
    }
    public double getValue() {
        return value;}

    public Vat setValue(double value) {
        this.value = value;
        return this;
    }





    public long getId() {
        return id;
    }

    public Vat setId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Vat{" +
                "id=" + id +
                ", percents='" + percents + '\'' +
                ", value=" + value +
                '}';
    }
}
