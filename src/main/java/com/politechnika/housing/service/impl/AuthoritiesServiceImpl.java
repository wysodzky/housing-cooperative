package com.politechnika.housing.service.impl;

import com.politechnika.housing.model.Authorities;
import com.politechnika.housing.repository.AuthoritiesRepository;
import com.politechnika.housing.service.inf.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Override
    public void save(Authorities authorities) {
        authoritiesRepository.saveAndFlush(authorities);
    }
}