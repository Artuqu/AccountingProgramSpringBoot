package coderslab.pl.accountingProgram.service;

import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.InvoiceDirection;
import coderslab.pl.accountingProgram.entity.Vat;

import java.util.List;


public interface AccountingService {

List <Company> findAllCompanies ();
List <Invoice> findAllInvoices ();
//List <Invoice> findInvoicesView ();
List <Vat> findAllVates ();
List <InvoiceDirection> findAllDirections ();

Company save (Company company);
Invoice save (Invoice invoice);
Vat save (Vat vat);

void deleteCompany(Long companyId);
void deleteVat(Long id);
void deleteInvoice(Long invoiceId);

Company findCompany (Long companyId);
Invoice findInvoice (Long invoiceId);

Object getAllVatSell();
Object getAllVatBuy();

Object getNettoSell();
Object getNettoBuy();
Object getBruttoBuy();
Object getBruttoSell();


}
