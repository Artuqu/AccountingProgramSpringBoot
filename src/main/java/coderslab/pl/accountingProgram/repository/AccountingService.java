package coderslab.pl.accountingProgram.repository;

import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.Vat;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AccountingService {

public List <Company> findAllCompanies ();
public List <Invoice> findAllInvoices ();
public List <Vat> findAllVates ();

public Company save (Company company);
public Invoice save (Invoice invoice);
public Vat save (Vat vat);

public Long deleteCompany(Long id);
public Long deleteVat(Long id);
public Long deleteInvoice(Long id);

public Company getCompany (Long id);
public Invoice getInvoice (Long id);


}
