package coderslab.pl.accountingProgram.service;
import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.InvoiceDirection;
import coderslab.pl.accountingProgram.entity.Vat;
import java.util.List;


public interface AccountingService {

public List <Company> findAllCompanies ();
public List <Invoice> findAllInvoices ();
public List <Invoice> findInvoicesView (Long companyId);
public List <Vat> findAllVates ();
public List <InvoiceDirection> findAllDirections ();

public Company save (Company company);
public Invoice save (Invoice invoice);
public Vat save (Vat vat);

public void deleteCompany(Long companyId);
public void deleteVat(Long id);
public void deleteInvoice(Long invoiceId);

public Company findCompany (Long companyId);
public Invoice findInvoice (Long invoiceId);


}
