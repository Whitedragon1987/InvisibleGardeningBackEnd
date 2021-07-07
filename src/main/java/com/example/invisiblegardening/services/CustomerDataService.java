package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.CustomerData;

import java.util.List;

public interface CustomerDataService {
    List<CustomerData> getCustomerDatas();
    List<CustomerData> findCustomerDataListByCustomersNameContainingIngnoreCase(String customersName);

    CustomerData getCustomerData(Long id);
    CustomerData saveCustomerData(CustomerData customerData);

    void deleteCustomerData(Long id);
    void updateCustomerData(Long id, CustomerData customerData);
    void assignCompanyToCustomerData(Long companyId, Long customerDataId);
}
