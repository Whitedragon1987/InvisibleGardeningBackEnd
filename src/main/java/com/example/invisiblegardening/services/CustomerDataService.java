package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.models.Employee;

import java.util.List;

public interface CustomerDataService {
    List<CustomerData> getCustomerDatas();

    CustomerData getCustomerData(Long id);
    List<CustomerData> findCustomerDataListByCustomersName(String customersName);
    CustomerData saveCustomerData(CustomerData customerData);
    void deleteCustomerData(Long id);
    void updateCustomerData(Long id, CustomerData customerData);
    void assignCompanyToCustomerData(Long companyId, Long customerDataId);
}
