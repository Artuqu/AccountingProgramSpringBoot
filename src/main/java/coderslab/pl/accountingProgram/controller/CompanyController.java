package coderslab.pl.accountingProgram.controller;


import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.repository.CompanyRepository;
import coderslab.pl.accountingProgram.repository.VatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;


//@SessionScope po co to?

@Controller
@RequestMapping("/admin/company")
public class CompanyController {

    public final CompanyRepository cr;
    public final VatRepository vr;
//    private final InvoiceRepository ir;


    @Autowired
    public CompanyController(VatRepository vr, CompanyRepository cr) {

        this.vr = vr;
//        this.ir = ir;
        this.cr = cr;
    }
    @GetMapping("/all")
    public String showCompanies(Model m) {

        List<Company> companies = cr.findAll();
        m.addAttribute("companies", companies);
        return "companies/allCompanies";
    }

    //add
    @GetMapping("/add")
    public String addCompany(Model m) {
        m.addAttribute("company", new Company());
        return "companies/addCompany";
    }

    @Transactional
    @PostMapping("/add")
    public String addCompanyPost(@ModelAttribute("company") @Valid Company company, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "companies/addCompany";
        }
        this.cr.save(company);
        m.addAttribute("company", company);

        return "redirect:all";
    }

    //edit
    @GetMapping("edit/{id}")
    public String editCompany(@PathVariable long id, Model m) {
        m.addAttribute("company", cr.getOne(id));
        return "companies/editCompany";
    }


    @PostMapping("edit")
    public String editInvoice(@ModelAttribute("company") @Valid Company company, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "companies/editCompany";
        }
        Company one = cr.getOne(company.getId())
                .setName(company.getName())
                .setAddress(company.getAddress())
                .setBankAccount(company.getBankAccount())
                .setEmail(company.getEmail())
                .setNIP(company.getNIP());


        this.cr.save(one);
        m.addAttribute("company", one);
        return "redirect:all";
    }


    //delete
    @Transactional
    @GetMapping("delete/{id}")
    public String deleteCompany(@PathVariable long id) {
        this.cr.deleteById(id);
        return "redirect:../all";
    }


}

