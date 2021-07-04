package com.example.invisiblegardening.services;
import com.example.invisiblegardening.exeptions.BadRequestException;
import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.*;
//
import com.example.invisiblegardening.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerRequestServiceImpl implements CustomerRequestService{
    private CustomerRequestRepository customerRequestRepository;
    private CustomerDataRepository customerDataRepository;
    private MachineRepository machineRepository;

    @Autowired
    public CustomerRequestServiceImpl(CustomerRequestRepository customerRequestRepository,
                                      CustomerDataRepository customerDataRepository,
                                      MachineRepository machineRepository){
        this.customerRequestRepository = customerRequestRepository;
        this.customerDataRepository = customerDataRepository;
        this.machineRepository = machineRepository;
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
        var optionalCustomerDataId = customerDataRepository.findById(customerData.getId());

        if (optionalCustomerDataId.isPresent()) {
            var customerDataId = optionalCustomerDataId.get();
            return customerRequestRepository.findByCustomerData(customerDataId);
        } else {
            throw new RecordNotFoundException("geen aanvragen gevonden voor klant");
        }
    }

    @Override
    public List<CustomerRequest> getCustomerRequestsBetweenDates(LocalDateTime start, LocalDateTime end) {
       return customerRequestRepository.findByRequestedStartTimeBetween(start, end);
    }

    @Override
    public void planCustomerRequest(Long customerDataId,List<Machine> machines, LocalDateTime requestedStartTime, LocalDateTime requestedEndTime) {
        var optionalCustomerData  = customerDataRepository.findById(customerDataId);
        var optionalMachines = machineRepository.findAll();

        if (optionalCustomerData.isEmpty()){
            throw new BadRequestException("klantgegevens mogen niet leeg zijn");
        } else if (optionalMachines.isEmpty()){
            throw new BadRequestException("machinesaanvraag mag niet leeg zijn");
        }

        var customerdata = optionalCustomerData.get();
        var machine = optionalMachines.addAll(machines);

//        vallidatRequestSlotIsFree(requestedStartTime, requestedEndTime);

        var customerRequest = new CustomerRequest();
        customerRequest.setCustomerData(customerdata);
        customerRequest.setRequestedStartTime(requestedStartTime);
        customerRequest.setRequestedEndTime(requestedEndTime);
        customerRequest.setStatus(RequestStatus.PLANNED);
        customerRequest.setMachines(machines);
    }

    @Override
    public List<Machine> getMachines() {
        return machineRepository.findAll();
    }
}
