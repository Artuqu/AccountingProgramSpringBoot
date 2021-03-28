package coderslab.pl.accountingProgram.repository;

import coderslab.pl.accountingProgram.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;

@Transactional
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

//    @Query("SELECT amountNetto FROM Invoice WHERE Invoice.id = :id")
//    List <Invoice> findAllAmountNetto(double amountNetto);



}
