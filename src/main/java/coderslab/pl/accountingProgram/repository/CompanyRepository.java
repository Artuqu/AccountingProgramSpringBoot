package coderslab.pl.accountingProgram.repository;

import coderslab.pl.accountingProgram.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;


@Transactional
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

long deleteCompanyById(long id);


}
