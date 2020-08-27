package com.wolox.challenge.service;

import com.wolox.challenge.service.dto.CompanyDto;
import org.springframework.http.ResponseEntity;

public interface CompanyService {

    CompanyDto add(CompanyDto companyDto);
}
