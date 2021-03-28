package coderslab.pl.accountingProgram.controller;

import coderslab.pl.accountingProgram.calculator.Calculator;
import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.entity.Invoice;
import coderslab.pl.accountingProgram.entity.InvoiceDirection;
import coderslab.pl.accountingProgram.entity.Vat;
import coderslab.pl.accountingProgram.repository.CompanyRepository;
import coderslab.pl.accountingProgram.repository.InvoiceDirectionRepository;
import coderslab.pl.accountingProgram.repository.InvoiceRepository;
import coderslab.pl.accountingProgram.repository.VatRepository;
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

    private final CompanyRepository cr;
    private final VatRepository vr;
    private final InvoiceRepository ir;
    private final InvoiceDirectionRepository idr;
    private final Calculator c;

    @Autowired
    public InvoiceController(Calculator c, InvoiceDirectionRepository idr, VatRepository vr, InvoiceRepository ir, CompanyRepository cr){
        this.ir=ir;
        this.vr=vr;
        this.cr=cr;
        this.idr=idr;
        this.c=c;
    }

    @GetMapping("/all/{id}")
    public String showInvoices(Model m, @PathVariable long id) {
        cr.getOne(id);
        List<Invoice> invoices = ir.findAll();
        m.addAttribute("invoices", invoices);
        return "invoices/allInvoices";
    }

    //add
    @GetMapping("/add/{id}")
    public String addInvoice(Model m, @PathVariable long id) {
        m.addAttribute("invoice", new Invoice());
        cr.getOne(id);
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
        this.ir.save(invoice);
        m.addAttribute("invoice", invoice);

        return "redirect:../all/{id}";
    }



    @ModelAttribute("companies")
    public List<Company> companies(){
        return cr.findAll();
    }

    @ModelAttribute("vates")
    public List<Vat> vates(){return vr.findAll();}

    @ModelAttribute("directions")
    public List<InvoiceDirection> directions(){return idr.findAll();}

//    @ModelAttribute("netto")
//    public List<Invoice> netto(@PathVariable double amountNetto) {
//        List<Invoice> netto = ir.findAllAmountNetto(amountNetto) }
;
    //delete
    @Transactional
    @GetMapping("delete/{id}")
    public String deleteInvoice(@PathVariable long id) {
        this.ir.deleteById(id);
        return "invoices/deleted";
    }

    //edit

    //edit
    @GetMapping("edit/{id}")
    public String editCompany(@PathVariable long id, Model m) {
        m.addAttribute("invoice", ir.getOne(id));
        return "invoices/editInvoices";
    }


    @PostMapping("edit")
    public String editInvoice(@ModelAttribute("invoice") @Valid Invoice invoice, BindingResult result, Model m) {
//        if (result.hasErrors()) {
//            return "invoices/editInvoices";
//        }
        Invoice one = ir.getOne(invoice.getId())
                .setInvoiceNumber(invoice.getInvoiceNumber())
                .setDate(invoice.getDate())
                .setInvoiceDirection(invoice.getInvoiceDirection())
                .setAmountNetto(invoice.getAmountNetto())
                .setAmountBrutto(invoice.getAmountBrutto())
                .setVat(invoice.getVat());



        this.ir.save(one);
        m.addAttribute("invoice", one);
        return "invoices/success";
    }

    //model for selling
    @ModelAttribute("nettosSell")
    public List<Invoice> netto(){return c.getAllNettoSell();}

    @ModelAttribute("bruttosSell")
    public List<Invoice> brutto(){return c.getAllBruttoSell();}

    @ModelAttribute("allVatSell")
    public List<Invoice> allVates(){return c.getAllVatSell();}


//    model for buying

    @ModelAttribute("nettosBuy")
    public List<Invoice> nettoBuy(){return c.getAllNettoBuy();}

    @ModelAttribute("bruttosBuy")
    public List<Invoice> bruttoBuy(){return c.getAllBruttoBuy();}

    @ModelAttribute("allVatBuy")
    public List<Invoice> allVatesBuy(){return c.getAllVatBuy();}

}
