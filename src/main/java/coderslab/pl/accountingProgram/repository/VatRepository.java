package coderslab.pl.accountingProgram.repository;
import coderslab.pl.accountingProgram.entity.Vat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VatRepository extends JpaRepository<Vat, Long> {


}
