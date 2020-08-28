package com.wolox.challenge.service;

import com.wolox.challenge.persistence.model.Company;
import com.wolox.challenge.service.dto.CompanyDto;

public interface CompanyService {

    Company add(CompanyDto companyDto);
}
