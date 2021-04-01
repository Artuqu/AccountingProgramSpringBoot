package coderslab.pl.accountingProgram.repository;

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

public long deleteCompany(long id);
public long deleteVat(long id);
public long deleteInvoice(long id);

public Company findCompany (Long id);
public Invoice findInvoice (Long id);


}
