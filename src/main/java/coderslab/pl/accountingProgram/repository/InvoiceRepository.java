package coderslab.pl.accountingProgram.repository;
import coderslab.pl.accountingProgram.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAllInvoicesByCompanyId(long id);


}
