package coderslab.pl.accountingProgram.service;
import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.InvoiceDirection;
import coderslab.pl.accountingProgram.entity.Vat;
import java.util.List;


public interface AccountingService {

public List <Company> findAllCompanies ();
public List <Invoice> findAllInvoices ();
public List <Vat> findAllVates ();
public List <InvoiceDirection> findAllDirections ();

public Company save (Company company);
public Invoice save (Invoice invoice);
public Vat save (Vat vat);

public void deleteCompany(Long id);
public void deleteVat(Long id);
public void deleteInvoice(Long id);

public Company findCompany (Long id);
public Invoice findInvoice (Long id);


}
