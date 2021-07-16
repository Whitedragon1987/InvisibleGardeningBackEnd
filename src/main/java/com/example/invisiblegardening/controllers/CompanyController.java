package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.CompanyDto;
import com.example.invisiblegardening.controllers.dto.CompanyInputDto;
import com.example.invisiblegardening.controllers.dto.JobDto;
import com.example.invisiblegardening.models.Company;
import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/{id}")
    public CompanyDto getCompany(@PathVariable("id") Long id) {
        var company = companyService.getCompany(id);
        return CompanyDto.fromCompany(company);
    }

    @PostMapping
    public CompanyDto saveCompany(@RequestBody CompanyInputDto dto) {
        var company = companyService.saveCompany(dto.toCompany());
        return CompanyDto.fromCompany(company);
    }

    @PutMapping("/{id}")
    public CompanyDto updateCompany(@PathVariable Long id, @RequestBody Company company) {
        companyService.updateCompany(id, company);
        return CompanyDto.fromCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
    }


}
