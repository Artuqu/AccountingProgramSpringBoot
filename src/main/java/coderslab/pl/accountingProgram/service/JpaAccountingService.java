package coderslab.pl.accountingProgram.service;
import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.InvoiceDirection;
import coderslab.pl.accountingProgram.entity.Vat;
import coderslab.pl.accountingProgram.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
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
                         InvoiceRepository ir,EntityManager em,
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
    public List<Invoice> findInvoicesView(Long companyId) {
        return ir.findAllInvoicesByCompanyId(companyId);
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




//    selling
    public Object getAllNettoSell() {
        Query q = em.createQuery ( "Select Coalesce(Round(sum(i.amountNetto),2),0) from Invoice i WHERE i.invoiceDirection.id = 1" );
        return q.getSingleResult ();
    }

    public Object getAllBruttoSell() {
        Query q = em.createQuery ( "Select Coalesce(Round(sum(i.amountBrutto),2),0) from Invoice i WHERE i.invoiceDirection.id = 1");
        return q.getSingleResult ();
    }


    public Object getAllVatSell() {
        Query q = em.createNativeQuery ( "select Coalesce((select Round(sum(amount_brutto),2) from Invoice WHERE invoice_direction_id = 1) - (select Round(sum(amount_netto),2) from Invoice  WHERE invoice_direction_id = 1),0)" );
        return q.getSingleResult ();
    }


//buying

    public Object getAllNettoBuy() {
        Query q = em.createQuery ( "Select Coalesce(Round(sum(i.amountNetto),2),0) from Invoice i WHERE i.invoiceDirection.id = 2" );
        return q.getSingleResult ();
    }

    public Object getAllBruttoBuy() {
        Query q = em.createQuery ( "Select Coalesce(Round(sum(i.amountBrutto),2),0) from Invoice i WHERE i.invoiceDirection.id = 2" );
        return q.getSingleResult ();
    }


    public Object getAllVatBuy() {
        Query q = em.createNativeQuery ( "Select Coalesce((select Round(sum(amount_brutto),2) from Invoice  WHERE invoice_direction_id = 2) - (select Round(sum(amount_netto),2) from Invoice   WHERE invoice_direction_id = 2),0)" );
        return q.getSingleResult ();

    }

}
