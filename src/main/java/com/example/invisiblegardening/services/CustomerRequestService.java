package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.CustomerRequest;


public interface CustomerRequestService {
      CustomerRequest getID(Long id);
      void deleteCustomerRequest(Long id);
      void updateCustomerRequest(Long id,CustomerRequest customerRequest);

      CustomerRequest saveCustomerRequest(CustomerRequest toCustomerRequest);
}
