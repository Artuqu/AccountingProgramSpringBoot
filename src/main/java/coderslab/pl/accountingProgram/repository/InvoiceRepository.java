package coderslab.pl.accountingProgram.repository;
import coderslab.pl.accountingProgram.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    long deleteInvoiceById(long id);

}
