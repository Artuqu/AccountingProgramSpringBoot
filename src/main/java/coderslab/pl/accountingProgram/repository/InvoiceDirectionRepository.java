package coderslab.pl.accountingProgram.repository;


import coderslab.pl.accountingProgram.entity.InvoiceDirection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;


@Transactional
@Repository
public interface InvoiceDirectionRepository extends JpaRepository<InvoiceDirection, Long> {



}
