package coderslab.pl.accountingProgram.service;

import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.Vat;
import coderslab.pl.accountingProgram.repository.AccountingService;
import coderslab.pl.accountingProgram.repository.CompanyRepository;
import coderslab.pl.accountingProgram.repository.InvoiceRepository;
import coderslab.pl.accountingProgram.repository.VatRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class JpaAccountingService implements AccountingService {

    private CompanyRepository cr;
    private InvoiceRepository ir;
    private VatRepository vr;




    @Override
    public List<Company> findAllCompanies() { return cr.findAll();}

    @Override
    public List<Invoice> findAllInvoices() {
        return ir.findAll();
    }

    @Override
    public List<Vat> findAllVates() { return vr.findAll(); }

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
    public Long deleteCompany(Long id) {
        return cr.deleteCompanyById(id);
    }

    @Override
    public Long deleteVat(Long id) {
        return vr.deleteVatById(id);
    }

    @Override
    public Long deleteInvoice(Long id) {
        return ir.deleteInvoiceById(id);
    }


}
