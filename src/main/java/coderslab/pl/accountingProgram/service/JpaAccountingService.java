package coderslab.pl.accountingProgram.service;

import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.Vat;
import coderslab.pl.accountingProgram.repository.AccountingService;
import coderslab.pl.accountingProgram.repository.CompanyRepository;
import coderslab.pl.accountingProgram.repository.InvoiceRepository;
import coderslab.pl.accountingProgram.repository.VatRepository;

import java.util.List;

public class JpaAccountingService implements AccountingService {

    private CompanyRepository cr;
    private InvoiceRepository ir;
    private VatRepository vr;




    @Override
    public List<Company> findAllCompanies() {
        return null;
    }

    @Override
    public List<Invoice> findAllInvoices() {
        return null;
    }

    @Override
    public List<Vat> findAllVates() {
        return null;
    }

    @Override
    public Company save(Company company) {
        return null;
    }

    @Override
    public Invoice save(Invoice invoice) {
        return null;
    }

    @Override
    public Vat save(Vat vat) {
        return null;
    }

    @Override
    public Company delete(Company company) {
        return null;
    }

    @Override
    public Invoice delete(Invoice invoice) {
        return null;
    }

    @Override
    public Vat delete(Vat vat) {
        return null;
    }
}
