package coderslab.pl.accountingProgram.controller;


import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.InvoiceDirection;
import coderslab.pl.accountingProgram.entity.Vat;
import coderslab.pl.accountingProgram.service.JpaAccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;


@Controller
//@SessionScope
@RequestMapping("invoice")
public class InvoiceController {

    private final JpaAccountingService jas;

    @Autowired
    public InvoiceController(JpaAccountingService jas){

        this.jas=jas;
    }

    @GetMapping("/all/{id}")
    public String showInvoices(Model m, @PathVariable long id) {
        jas.findCompany(id);
        List<Invoice> invoices = jas.findAllInvoices();
        m.addAttribute("invoices", invoices);
        return "invoices/allInvoices";
    }

    //add
    @GetMapping("/add/{id}")
    public String addInvoice(Model m, @PathVariable long id) {
        m.addAttribute("invoice", new Invoice());
        jas.findCompany(id);
        return "invoices/addInvoice";
    }

//    @GetMapping("/add/{id}")
//    public String addInvoice(Model m, @PathVariable long id) {
//        cr.getOne(id);
//        m.addAttribute("company", cr.getOne(id));
//        m.addAttribute("invoice", new Invoice());
//
//        return "invoices/addInvoice";
//    }

    @Transactional
    @PostMapping("/add/{id}")
    public String addInvoicePost(@ModelAttribute("invoice") @Valid Invoice invoice, BindingResult result, Model m,  @PathVariable long id) {
        if (result.hasErrors()) {
            return "invoices/addInvoice";
        }
        invoice.getCompany();
        this.jas.save(invoice);
        m.addAttribute("invoice", invoice);

        return "redirect:../all/{id}";
    }



    @ModelAttribute("companies")
    public List<Company> companies(){return jas.findAllCompanies();}

    @ModelAttribute("vates")
    public List<Vat> vates(){return jas.findAllVates();}

    @ModelAttribute("directions")
    public List<InvoiceDirection> directions(){return jas.findAllDirections();}

//    @ModelAttribute("netto")
//    public List<Invoice> netto(@PathVariable double amountNetto) {
//        List<Invoice> netto = ir.findAllAmountNetto(amountNetto) }
;
    //delete
    @Transactional
    @GetMapping("delete/{id}")
    public String deleteInvoice(@PathVariable long id) {
        this.jas.deleteInvoice(id);
        return "invoices/deleted";
    }

    //edit

    //edit
    @GetMapping("edit/{id}")
    public String editCompany(@PathVariable long id, Model m) {
        m.addAttribute("invoice", jas.findInvoice(id));
        return "invoices/editInvoices";
    }


    @PostMapping("edit")
    public String editInvoice(@ModelAttribute("invoice") @Valid Invoice invoice, BindingResult result, Model m) {
//        if (result.hasErrors()) {
//            return "invoices/editInvoices";
//        }
        Invoice one = jas.findInvoice(invoice.getId());
                one.setDate(invoice.getDate());
                one.setInvoiceNumber(invoice.getInvoiceNumber());
                one.setInvoiceDirection(invoice.getInvoiceDirection());
                one.setAmountNetto(invoice.getAmountNetto());
                one.setAmountBrutto(invoice.getAmountBrutto());
                one.setVat(invoice.getVat());



        this.jas.save(one);
        m.addAttribute("invoice", one);
        return "invoices/success";
    }

    //model for selling
    @ModelAttribute("nettosSell")
    public List<Invoice> netto(){return jas.getAllNettoSell();}

    @ModelAttribute("bruttosSell")
    public List<Invoice> brutto(){return jas.getAllBruttoSell();}

    @ModelAttribute("allVatSell")
    public List<Invoice> allVates(){return jas.getAllVatSell();}


//    model for buying

    @ModelAttribute("nettosBuy")
    public List<Invoice> nettoBuy(){return jas.getAllNettoBuy();}

    @ModelAttribute("bruttosBuy")
    public List<Invoice> bruttoBuy(){return jas.getAllBruttoBuy();}

    @ModelAttribute("allVatBuy")
    public List<Invoice> allVatesBuy(){return jas.getAllVatBuy();}

}
