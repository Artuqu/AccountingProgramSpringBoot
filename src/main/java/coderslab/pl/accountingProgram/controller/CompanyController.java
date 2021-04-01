package coderslab.pl.accountingProgram.controller;


import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.repository.AccountingService;
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




@Controller
@RequestMapping("/admin/company")
public class CompanyController {

    public final AccountingService as;

    @Autowired
    public CompanyController(AccountingService as) {
        this.as = as;

    }
    @GetMapping("/all")
    public String showCompanies(Model m) {

        List<Company> companies = as.findAllCompanies();
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
        this.as.save(company);
        m.addAttribute("company", company);

        return "redirect::all";
    }

    //edit
    @GetMapping("edit/{id}")
    public String editCompany(@PathVariable long id, Model m) {
        m.addAttribute("company", as.getCompany(id));
        return "companies/editCompany";
    }


    @PostMapping("edit")
    public String editInvoice(@ModelAttribute("company") @Valid Company company, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "companies/editCompany";
        }
        Company one = as.getCompany(company.getId());
                one.setName(company.getName());
                one.setAddress(company.getAddress());
                one.setBankAccount(company.getBankAccount());
                one.setEmail(company.getEmail());
                one.setNIP(company.getNIP());

        this.as.save(one);
        m.addAttribute("company", one);
        return "redirect:all";
    }


    //delete
    @Transactional
    @GetMapping("delete/{id}")
    public String deleteCompany(@PathVariable long id) {
        this.as.deleteCompany(id);
        return "redirect:../all";
    }


}

