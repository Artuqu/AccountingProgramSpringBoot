package coderslab.pl.accountingProgram.repository;

import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.Vat;

import java.util.List;

public interface AccountingService {

public List <Company> findAllCompanies ();
public List <Invoice> findAllInvoices ();
public List <Vat> findAllVates ();

public Company save (Company company);
public Invoice save (Invoice invoice);
public Vat save (Vat vat);

public Company delete (Company company);
public Invoice delete (Invoice invoice);
public Vat delete (Vat vat);



}
