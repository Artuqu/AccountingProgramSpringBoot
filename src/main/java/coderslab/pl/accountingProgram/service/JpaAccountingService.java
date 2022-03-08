package coderslab.pl.accountingProgram.service;

import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.InvoiceDirection;
import coderslab.pl.accountingProgram.entity.Vat;
import coderslab.pl.accountingProgram.repository.CompanyRepository;
import coderslab.pl.accountingProgram.repository.InvoiceDirectionRepository;
import coderslab.pl.accountingProgram.repository.InvoiceRepository;
import coderslab.pl.accountingProgram.repository.VatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class JpaAccountingService implements AccountingService {

    CompanyRepository cr;
    InvoiceRepository ir;
    InvoiceDirectionRepository idr;
    VatRepository vr;
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

//    @Override
//    public List<Invoice> findInvoicesView(Long companyId) {
//        return ir.findAllInvoicesByCompanyId(companyId);
//    }


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




    @Override
    public Object getAllVatSell() {
        return ir.allVatSell();
    }

    @Override
    public Object getAllVatBuy() {
        return ir.allVatBuy();
    }

    @Override
    public Object getNettoSell() {
        return ir.nettoSell();
    }

    @Override
    public Object getNettoBuy() {
        return ir.nettoBuy();
    }

    @Override
    public Object getBruttoBuy() {
        return ir.bruttoBuy();
    }

    @Override
    public Object getBruttoSell() {
        return ir.bruttoSell();
    }

}
