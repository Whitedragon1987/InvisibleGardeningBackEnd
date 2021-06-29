package com.example.invisiblegardening.services;
import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.repositories.CustomerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerRequestServiceImpl implements CustomerRequestService{
    private CustomerRequestRepository customerRequestRepository;

    @Autowired
    public CustomerRequestServiceImpl(CustomerRequestRepository customerRequestRepository) {
        this.customerRequestRepository = customerRequestRepository;

    }

    @Override
    public CustomerRequest getID(Long id) {
        return customerRequestRepository.getById(id);
    }

    @Override
    public void deleteCustomerRequest(Long id) {
        customerRequestRepository.deleteById(id);
    }

    @Override
    public void updateCustomerRequest(Long id, CustomerRequest customerRequest) {
        Optional<CustomerRequest> optionalCustomerRequest = customerRequestRepository.findById(id);
        if (optionalCustomerRequest.isPresent()) {
            customerRequestRepository.save(customerRequest);
        } else {
            throw new RecordNotFoundException("customerRequest does not exist");
        }
    }

    @Override
    public CustomerRequest saveCustomerRequest(CustomerRequest customerRequest) {
        return customerRequestRepository.save(customerRequest);
    }
}
