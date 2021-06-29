package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.Company;
import com.example.invisiblegardening.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Company> getCompanys() {
        return repository.findAll();
    }

    @Override
    public Company getCompany(Long id) {
        return repository.getById(id);
    }

    @Override
    public Company saveCompany(Company company) {
        return repository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateCompany(Long id, Company company) {
        Optional<Company> optionalCompany = repository.findById(id);
        if (optionalCompany.isPresent()) {
            repository.save(company);
        } else {
            throw new RecordNotFoundException("company does not exist");
        }
    }

}
