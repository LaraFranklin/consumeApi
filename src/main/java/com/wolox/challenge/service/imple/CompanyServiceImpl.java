package com.wolox.challenge.service.imple;

import com.wolox.challenge.persistence.model.Company;
import com.wolox.challenge.persistence.repository.RepositoryCompany;
import com.wolox.challenge.service.CompanyService;
import com.wolox.challenge.service.dto.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    RepositoryCompany repositoryCompany;

    @Override
    public Company add(CompanyDto companyDto) {

        Company company;
        if (repositoryCompany.findByName(companyDto.getName().trim()).isPresent()) {
            return repositoryCompany.findByName(companyDto.getName().trim()).get();
        } else {
            company = new Company();
            company.setId(companyDto.getId());
            company.setName(companyDto.getName().trim());
            company.setCatchPhrase(companyDto.getCatchPhrase());
            company.setBs(companyDto.getBs());

        }

        return repositoryCompany.saveAndFlush(company);
    }
}
