package com.example.invisiblegardening.services;
import com.example.invisiblegardening.exeptions.BadRequestException;
import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.models.Machine;
//import com.example.invisiblegardening.models.MachineRequest;
import com.example.invisiblegardening.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerRequestServiceImpl implements CustomerRequestService{
    private CustomerRequestRepository customerRequestRepository;
    private MachineRepository machineRepository;
    private CustomerDataRepository customerDataRepository;
    private JobRepository jobRepository;

    @Autowired
    public CustomerRequestServiceImpl(CustomerRequestRepository customerRequestRepository,
                                      MachineRepository machineRepository,
                                      CustomerDataRepository customerDataRepository,
                                      JobRepository jobRepository) {
        this.customerRequestRepository = customerRequestRepository;
        this.machineRepository = machineRepository;
        this.customerDataRepository = customerDataRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public CustomerRequest getById(Long id) {
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
    public List<CustomerRequest> getCustomerRequestsForCustomerData(CustomerData customerData) {
        return null;
    }

    @Override
    public List<CustomerRequest> getCustomerRequestsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public void planCustomerRequest(List<Machine> machineList, CustomerData customerData, LocalDateTime startTime, LocalDateTime endTime) {

    }

    @Override
    public List<CustomerRequest> getCustomerRequestsForMachineId(Machine machineId) {
        var optionalMachine = machineRepository.findById(machineId.getId());

        if (optionalMachine.isPresent()) {
            var machine = optionalMachine.get();
            return customerRequestRepository.findByMachine(machine);
        } else {
            throw new RecordNotFoundException("machine bestaat niet");
        }
    }

}
