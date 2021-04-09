package coderslab.pl.accountingProgram.service;

import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.InvoiceDirection;
import coderslab.pl.accountingProgram.entity.Vat;
import coderslab.pl.accountingProgram.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Primary
@Repository
public class JpaAccountingService implements AccountingService {

    public CompanyRepository cr;
    public InvoiceRepository ir;
    public InvoiceDirectionRepository idr;
    public VatRepository vr;
    @PersistenceContext
    private EntityManager em;

    @Autowired
    JpaAccountingService(CompanyRepository cr,
                         InvoiceRepository ir, EntityManager em,
                         InvoiceDirectionRepository idr, VatRepository vr) {
        this.cr = cr;
        this.ir = ir;
        this.idr = idr;
        this.vr = vr;
        this.em = em;
    }


    @Override
    public List<Company> findAllCompanies() {
        return cr.findAll();
    }

    @Override
    public List<Invoice> findAllInvoices() {
        return ir.findAll();
    }

    @Override
    public List<Vat> findAllVates() {
        return vr.findAll();
    }

    @Override
    public List<InvoiceDirection> findAllDirections() {
        return idr.findAll();
    }

    @Override
    public Company save(Company company) {
        return cr.save(company);
    }

    @Override
    public Invoice save(Invoice invoice) {
        return ir.save(invoice);
    }

    @Override
    public Vat save(Vat vat) {
        return vr.save(vat);
    }

    @Override
    public void deleteCompany(Long id) {
        cr.deleteById(id);
    }

    @Override
    public void deleteVat(Long id) {
        vr.deleteById(id);
    }

    @Override
    public void deleteInvoice(Long id) {
        ir.deleteById(id);
    }


    @Override
    public Company findCompany(Long id) {
        return cr.getOne(id);
    }

    @Override
    public Invoice findInvoice(Long id) {
        return ir.getOne(id);
    }


    //selling
//    public List<Invoice> getAllNettoSell() {
//        Query q = em.createQuery ( "Select sum (i.amountNetto) from Invoice i WHERE i.invoiceDirection.id = 1" );
//        return q.getResultList ();
//    }
//
//    public List<Invoice> getAllBruttoSell() {
//        Query q = em.createQuery ( "Select sum (i.amountBrutto) from Invoice i WHERE i.invoiceDirection.id = 1" );
//        return q.getResultList ();
//    }
//
//
//    public List<Invoice> getAllVatSell() {
//        Query q = em.createNativeQuery ( "select Round((select sum(amountBrutto) from Invoice WHERE invoiceDirection_id = 1) - (select sum(amountNetto) from Invoice  WHERE invoicedirection_id = 1),2)" );
//        return q.getResultList ();
//    }
//
//
////buying
//
//    public List<Invoice> getAllNettoBuy() {
//        Query q = em.createQuery ( "Select sum (i.amountNetto) from Invoice i WHERE i.invoiceDirection.id = 2" );
//        return q.getResultList ();
//    }
//
//    public List<Invoice> getAllBruttoBuy() {
//        Query q = em.createQuery ( "Select sum (i.amountBrutto) from Invoice i WHERE i.invoiceDirection.id = 2" );
//        return q.getResultList ();
//    }
//
//
//    public List<Invoice> getAllVatBuy() {
//        Query q = em.createNativeQuery ( "Select Round((select sum(amountBrutto) from Invoice WHERE invoiceDirection_id = 2) - (select sum(amountNetto) from Invoice  WHERE invoicedirection_id = 2),2)" );
//        return q.getResultList ();
//
//    }

}
