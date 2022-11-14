package peaksoft.dao.impl;
import org.springframework.stereotype.Repository;
import peaksoft.dao.CompanyDAO;
import peaksoft.entity.Company;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompanies() {
        List<Company>companies=entityManager.createQuery("from Company",Company.class).getResultList();
        Comparator<Company>comparator=((o1,o2)->(int)(o1.getId()-o2.getId()));
        companies.sort(comparator);
        return companies;
    }

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        Company company;
        company=entityManager.find(Company.class,id);
        return company;
    }

    @Override
    public void updateCompany(Company company) {
        entityManager.merge(company);
    }

    @Override
    public void deleteCompany(Company company) {
        entityManager.remove(entityManager.contains(company)?company:entityManager.merge(company));
    }
}

