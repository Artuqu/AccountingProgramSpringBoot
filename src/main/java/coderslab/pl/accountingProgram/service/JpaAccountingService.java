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
    public List<Invoice> findAllInvoices(Long companyId) {
        return ir.findAllInvoicesByCompanyId(companyId);
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
    public Object getAllVatSell(Long id) {
        return ir.allVatSell(id);
    }

    @Override
    public Object getAllVatBuy(Long id) {
        return ir.allVatBuy(id);
    }

    @Override
    public Object getNettoSell(Long id) {
        return ir.nettoSell(id);
    }

    @Override
    public Object getNettoBuy(Long id) {
        return ir.nettoBuy(id);
    }

    @Override
    public Object getBruttoBuy(Long id) {
        return ir.bruttoBuy(id);
    }

    @Override
    public Object getBruttoSell(Long id) {
        return ir.bruttoSell(id);
    }

}
