package coderslab.pl.accountingProgram.repository;

import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


    List<Invoice> findAllInvoicesByCompanyId(long id);


    @Query(value = "SELECT Coalesce(sum(amount_brutto)-sum(amount_netto),0) FROM invoice WHERE invoice_direction_id = 1 AND company_id LIKE :id", nativeQuery = true)
    Object allVatSell(@Param("id") Long id);

    @Query(value = "SELECT Coalesce(sum(amount_brutto)-sum(amount_netto),0) FROM invoice WHERE invoice_direction_id = 2 AND company_id LIKE :id", nativeQuery = true)
    Object allVatBuy(@Param("id") Long id);


    //buying

    @Query("Select Coalesce(Round(sum(i.amountNetto),2),0) from Invoice i WHERE i.invoiceDirection.id = 2 AND i.company.id LIKE :id")
    Object nettoBuy(@Param("id") Long id);


    @Query("Select Coalesce(Round(sum(i.amountBrutto),2),0) from Invoice i WHERE i.invoiceDirection.id = 2 AND i.company.id LIKE :id")
    Object bruttoBuy(@Param("id") Long id);


    //        selling
    @Query("Select Coalesce(Round(sum(i.amountNetto),2),0) from Invoice i WHERE i.invoiceDirection.id = 1 AND i.company.id LIKE :id")
    Object nettoSell(@Param("id") Long id);


    @Query("Select Coalesce(Round(sum(i.amountBrutto),2),0) from Invoice i WHERE i.invoiceDirection.id = 1 AND i.company.id LIKE :id")
    Object bruttoSell(@Param("id") Long id);


}



