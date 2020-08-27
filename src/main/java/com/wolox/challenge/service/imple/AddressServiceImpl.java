package com.wolox.challenge.service.imple;

import com.wolox.challenge.persistence.repository.RepositoryAddress;
import com.wolox.challenge.service.AddressService;
import com.wolox.challenge.service.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    RepositoryAddress repositoryAddress;

    @Override
    public AddressDto add(AddressDto addressDto) {
        return null;
    }
}
