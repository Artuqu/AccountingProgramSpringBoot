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
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("invoice")
public class InvoiceController {

    private final JpaAccountingService jas;

    @Autowired
    public InvoiceController(JpaAccountingService jas) {
        this.jas = jas;
    }

    @GetMapping("/all")
    public ModelAndView showInvoices(ModelAndView mav) {
        mav.setViewName("invoices/all");
        mav.addObject("invoices", jas.findAllInvoices());

        mav.addObject("bruttosSell", jas.getBruttoSell());
        mav.addObject("nettosSell", jas.getNettoSell());
        mav.addObject("allVatSell", jas.getAllVatSell());

        mav.addObject("bruttosBuy", jas.getBruttoBuy());
        mav.addObject("nettosBuy", jas.getNettoBuy());
        mav.addObject("allVatBuy", jas.getAllVatBuy());

        return mav;
    }

    //add
    @GetMapping("/add/{id}")
    public String addInvoice(Model m) {
        m.addAttribute("invoice", new Invoice());
        return "invoices/add";
    }


    @Transactional
    @PostMapping("/add/{id}")
    public String addInvoicePost(@ModelAttribute("invoice") @Valid Invoice invoice, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "invoices/add";
        }
        this.jas.save(invoice);
        m.addAttribute("invoice", invoice);

        return "redirect:../all";
    }


    @ModelAttribute("companies")
    public List<Company> companies() {
        return jas.findAllCompanies();
    }

    @ModelAttribute("vates")
    public List<Vat> vates() {
        return jas.findAllVates();
    }

    @ModelAttribute("invoiceDirections")
    public List<InvoiceDirection> directions() {
        return jas.findAllDirections();
    }


    //delete
    @GetMapping("delete/{id}")
    public String deleteInvoice(@PathVariable long id) {
        this.jas.deleteInvoice(id);
        return "invoices/deleted";
    }


    //edit
    @GetMapping("edit/{id}")
    public String editCompany(@PathVariable long id, Model m) {
        m.addAttribute("invoice", jas.findInvoice(id));
        return "invoices/edit";
    }


    @PostMapping("edit")
    public String editInvoice(@ModelAttribute("invoice") @Valid Invoice invoice, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "invoices/edit";
        }
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


}
