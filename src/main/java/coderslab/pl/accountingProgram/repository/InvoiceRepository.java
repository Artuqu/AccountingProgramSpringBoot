package coderslab.pl.accountingProgram.repository;

import coderslab.pl.accountingProgram.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAllInvoicesByCompanyId(long id);
    List<Invoice> deleteAllInvoicesByCompanyId(long id);


    @Query(value = "SELECT Coalesce(Round(sum(amount_brutto)-sum(amount_netto),2),0) FROM invoice LEFT JOIN " +
            "invoice_direction ON invoice.invoice_direction_id=invoice_direction.id WHERE invoice_direction.direction = 'buy' AND company_id LIKE :id", nativeQuery = true)
    Object allVatSell(@Param("id") Long id);

    @Query(value = "SELECT Coalesce(Round(sum(amount_brutto)-sum(amount_netto),2),0) FROM invoice LEFT JOIN " +
            "invoice_direction ON invoice.invoice_direction_id=invoice_direction.id WHERE invoice_direction.direction = 'sell' AND company_id LIKE :id", nativeQuery = true)
    Object allVatBuy(@Param("id") Long id);


    //buying

    @Query("Select Coalesce(Round(sum(i.amountNetto),2),0) from Invoice i WHERE i.invoiceDirection.direction = 'buy' AND i.company.id LIKE :id")
    Object nettoBuy(@Param("id") Long id);


    @Query("Select Coalesce(Round(sum(i.amountBrutto),2),0) from Invoice i WHERE i.invoiceDirection.direction = 'buy' AND i.company.id LIKE :id")
    Object bruttoBuy(@Param("id") Long id);


    //        selling
    @Query("Select Coalesce(Round(sum(i.amountNetto),2),0) from Invoice i WHERE i.invoiceDirection.direction = 'sell' AND i.company.id LIKE :id")
    Object nettoSell(@Param("id") Long id);


    @Query("Select Coalesce(Round(sum(i.amountBrutto),2),0) from Invoice i WHERE i.invoiceDirection.direction = 'sell' AND i.company.id LIKE :id")
    Object bruttoSell(@Param("id") Long id);


}



