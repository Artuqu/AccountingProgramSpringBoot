package coderslab.pl.accountingProgram.service;

import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.InvoiceDirection;
import coderslab.pl.accountingProgram.entity.Vat;

import java.util.List;


public interface AccountingService {

List <Company> findAllCompanies ();
List <Invoice> findAllInvoices (Long companyId);
//List <Invoice> findInvoicesView ();
List <Vat> findAllVates ();
List <InvoiceDirection> findAllDirections ();

Company save (Company company);
Invoice save (Invoice invoice);
Vat save (Vat vat);

void deleteCompany(Long companyId);
void deleteInvoice(Long invoiceId);
void deleteAllInvoices(Long companyId);

Company findCompany (Long companyId);
Invoice findInvoice (Long invoiceId);

Object getAllVatSell(Long companyId);
Object getAllVatBuy(Long companyId);

Object getNettoSell(Long companyId);
Object getNettoBuy(Long companyId);
Object getBruttoBuy(Long companyId);
Object getBruttoSell(Long companyId);


}
