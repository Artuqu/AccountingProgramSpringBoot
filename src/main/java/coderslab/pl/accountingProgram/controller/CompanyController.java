package coderslab.pl.accountingProgram.controller;
import coderslab.pl.accountingProgram.entity.Company;
import coderslab.pl.accountingProgram.service.JpaAccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@Controller
@RequestMapping("/admin/company")
public class CompanyController {

    public final JpaAccountingService jas;


    @Autowired
    public CompanyController(JpaAccountingService jas) {
        this.jas = jas;


    }

    @GetMapping("/all")
    public String showCompanies(Model m) {
        m.addAttribute("companies", jas.findAllCompanies());
        return "companies/all";
    }

    //add
    @GetMapping("/add")
    public String addCompany(Model m) {
        m.addAttribute("company", new Company());
        return "companies/add";
    }

    @PostMapping("/add")
    public String addCompanyPost(@ModelAttribute("company") @Valid Company company, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "companies/add";
        }
        this.jas.save(company);
        m.addAttribute("company", company);

        return "redirect:all";
    }

    //edit
    @GetMapping("edit/{id}")
    public String editCompany(@PathVariable long id, Model m) {
        m.addAttribute("company", jas.findCompany(id));
        return "companies/edit";
    }


    @PostMapping("edit")
    public String editInvoice(@ModelAttribute("company") @Valid Company company, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "companies/edit";
        }
        Company one = jas.findCompany(company.getId());
        one.setName(company.getName());
        one.setAddress(company.getAddress());
        one.setBankAccount(company.getBankAccount());
        one.setEmail(company.getEmail());
        one.setNIP(company.getNIP());

        this.jas.save(one);
        m.addAttribute("company", one);
        return "redirect:all";
    }


    //delete
    @GetMapping("delete/{id}")
    public String deleteCompany(@PathVariable long id) {
        this.jas.deleteCompany(id);
        return "redirect:../all";
    }


}

