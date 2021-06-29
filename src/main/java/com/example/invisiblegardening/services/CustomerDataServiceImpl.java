package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.repositories.CompanyRepository;
import com.example.invisiblegardening.repositories.CustomerDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDataServiceImpl implements CustomerDataService{
    private CustomerDataRepository customerDataRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public CustomerDataServiceImpl(CustomerDataRepository customerDataRepository,
                                   CompanyRepository companyRepository) {
        this.customerDataRepository = customerDataRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CustomerData> getCustomerDatas() {
        return customerDataRepository.findAll();
    }

    @Override
    public CustomerData getCustomerData(Long id) {
        var optionalCustomerData = customerDataRepository.findById(id);
        if (optionalCustomerData.isPresent()) {
            return optionalCustomerData.get();
        } else {
            throw new RecordNotFoundException("customerData does not exist");
        }
    }

    @Override
    public CustomerData saveCustomerData(CustomerData customerData) {
        return customerDataRepository.save(customerData);
    }

    @Override
    public void deleteCustomerData(Long id) {
        customerDataRepository.deleteById(id);
    }

    @Override
    public void updateCustomerData(Long id, CustomerData customerData) {
        Optional<CustomerData> optionalCustomerData = customerDataRepository.findById(id);
        if (optionalCustomerData.isPresent()) {
            customerDataRepository.save(customerData);
        } else {
            throw new RecordNotFoundException("customerData does not exist");
        }
    }

    @Override
    public void assignCompanyToCustomerData(Long companyId, Long customerDataId) {
        var optionalCompany = companyRepository.findById(companyId);
        var optionalCustomerData = customerDataRepository.findById(customerDataId);


        if (optionalCustomerData.isPresent() && optionalCompany.isPresent()) {
            var company = optionalCompany.get();
            var customerData = optionalCustomerData.get();

            customerData.setCompany(company);
            customerDataRepository.save(customerData);
        }
    }
 }
