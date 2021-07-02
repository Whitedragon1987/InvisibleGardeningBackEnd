package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.Company;

import java.util.List;

public interface CompanyService {

    Company getCompany(Long id);
    Company saveCompany(Company company);
    void deleteCompany(Long id);
    void updateCompany(Long id, Company company);
}
