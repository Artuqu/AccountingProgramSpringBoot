package coderslab.pl.accountingProgram.repository;

import coderslab.pl.accountingProgram.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


    List<Invoice> findAllInvoicesByCompanyId(long id);


    @Query(value = "SELECT Coalesce(sum(amount_brutto)-sum(amount_netto),0) FROM invoice WHERE invoice_direction_id = 1", nativeQuery = true)
    Object allVatSell();

    @Query(value = "SELECT Coalesce(sum(amount_brutto)-sum(amount_netto),0) FROM invoice WHERE invoice_direction_id = 2", nativeQuery = true)
    Object allVatBuy();


    //buying

    @Query("Select Coalesce(Round(sum(i.amountNetto),2),0) from Invoice i WHERE i.invoiceDirection.id = 2")
    Object nettoBuy();


    @Query("Select Coalesce(Round(sum(i.amountBrutto),2),0) from Invoice i WHERE i.invoiceDirection.id = 2")
    Object bruttoBuy();


    //        selling
    @Query("Select Coalesce(Round(sum(i.amountNetto),2),0) from Invoice i WHERE i.invoiceDirection.id = 1")
    Object nettoSell();


    @Query("Select Coalesce(Round(sum(i.amountBrutto),2),0) from Invoice i WHERE i.invoiceDirection.id = 1")
    Object bruttoSell();


}



