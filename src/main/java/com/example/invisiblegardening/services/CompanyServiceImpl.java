package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.Company;
import com.example.invisiblegardening.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

//  vind een bedrijf aan de hand van een id
    @Override
    public Company getCompany(Long id) {
        return repository.getById(id);
    }

//  sla een nieuw bedrijf op
    @Override
    public Company saveCompany(Company company) {
        return repository.save(company);
    }

//  verwijder een bedrijf aan de hand van een id
    @Override
    public void deleteCompany(Long id) {
        repository.deleteById(id);
    }

//  wijzig een bedrijf aan de hand van een id, als id niet bestaat geef record not found exception
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
