package coderslab.pl.accountingProgram.repository;
import coderslab.pl.accountingProgram.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{


}
