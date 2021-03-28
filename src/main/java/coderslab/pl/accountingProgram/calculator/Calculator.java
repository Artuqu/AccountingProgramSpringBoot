package coderslab.pl.accountingProgram.calculator;

import coderslab.pl.accountingProgram.entity.Invoice;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class Calculator {

    @PersistenceContext
    private EntityManager em;

    //selling
    public List<Invoice> getAllNettoSell() {
        Query q = em.createQuery ( "Select sum (i.amountNetto) from Invoice i WHERE i.invoiceDirection.id = 1" );
        return q.getResultList ();
    }

    public List<Invoice> getAllBruttoSell() {
        Query q = em.createQuery ( "Select sum (i.amountBrutto) from Invoice i WHERE i.invoiceDirection.id = 1" );
        return q.getResultList ();
    }


    public List<Invoice> getAllVatSell() {
        Query q = em.createNativeQuery ( "select Round((select sum(amountBrutto) from Invoice WHERE invoiceDirection_id = 1) - (select sum(amountNetto) from Invoice  WHERE invoicedirection_id = 1),2)" );
        return q.getResultList ();
    }


//buying

    public List<Invoice> getAllNettoBuy() {
        Query q = em.createQuery ( "Select sum (i.amountNetto) from Invoice i WHERE i.invoiceDirection.id = 2" );
        return q.getResultList ();
    }

    public List<Invoice> getAllBruttoBuy() {
        Query q = em.createQuery ( "Select sum (i.amountBrutto) from Invoice i WHERE i.invoiceDirection.id = 2" );
        return q.getResultList ();
    }


    public List<Invoice> getAllVatBuy() {
        Query q = em.createNativeQuery ( "Select Round((select sum(amountBrutto) from Invoice WHERE invoiceDirection_id = 2) - (select sum(amountNetto) from Invoice  WHERE invoicedirection_id = 2),2)" );
        return q.getResultList ();

    }
}


