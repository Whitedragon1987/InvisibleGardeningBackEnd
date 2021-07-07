package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.BadRequestException;
import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.*;
import com.example.invisiblegardening.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class CustomerRequestServiceImpl implements CustomerRequestService {
    private CustomerRequestRepository customerRequestRepository;
    private CustomerDataRepository customerDataRepository;
    private MachineRepository machineRepository;
    private JobRepository jobRepository;

    @Autowired
    public CustomerRequestServiceImpl(CustomerRequestRepository customerRequestRepository,
                                      CustomerDataRepository customerDataRepository,
                                      MachineRepository machineRepository,
                                      JobRepository jobRepository){
        this.customerRequestRepository = customerRequestRepository;
        this.customerDataRepository = customerDataRepository;
        this.machineRepository = machineRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public List<CustomerRequest> getCustomerRequestBetweenDates(LocalDateTime start, LocalDateTime end) {
        return customerRequestRepository.findByRequestedStartTimeBetween(start, end);
    }

    @Override
    public List<CustomerRequest> getCustomerRequestsForMachine(Long machineId) {
        var optionalMachine = machineRepository.findById(machineId);

        if (optionalMachine.isPresent()) {
            var machine = optionalMachine.get();
            return customerRequestRepository.findByMachine(machine);
        } else {
            throw new RecordNotFoundException("geen aanvragen gevonden voor machine");
        }
    }

    @Override
    public List<CustomerRequest> getCustomerRequestsForJob(Long jobId) {
        var optionalJob = jobRepository.findById(jobId);

        if (optionalJob.isPresent()) {
            var job = optionalJob.get();
            return customerRequestRepository.findByJob(job);
        } else {
            throw new RecordNotFoundException("geen aanvragen gevonden voor dienst");
        }
    }

    @Override
    public List<CustomerRequest> getCustomerRequestsForCustomerData(Long customerDataId) {
        var optionalCustomerData = customerDataRepository.findById(customerDataId);

        if (optionalCustomerData.isPresent()) {
            var customerData = optionalCustomerData.get();
            return customerRequestRepository.findByCustomerData(customerData);
        } else {
            throw new RecordNotFoundException("geen aanvragen gevonden voor klant");
        }
    }

    @Override
    public void planCustomerRequest(Long machineId, Long jobId, Long customerDataId, LocalDateTime requestedStartTime, LocalDateTime requestedEndTime) {
        var optionalCustomerData = customerDataRepository.findById(customerDataId);
        var optionalMachine = machineRepository.findById(machineId);
        var optionalJob = jobRepository.findById(jobId);

        if (optionalCustomerData.isEmpty() || (optionalMachine.isEmpty() && optionalJob.isEmpty())) {
            throw new BadRequestException("er ontbreken gegevens");
        }

        var customerData = optionalCustomerData.get();
        var machine = optionalMachine.get();
        var job = optionalJob.get();

        if(machine != null && job != null) {
            validateRequestedSlotIsFreeMachine(requestedStartTime, requestedEndTime, machine);
            validateRequestedSlotIsFreeJob(requestedStartTime, requestedEndTime, job);
        }else if(machine != null) {
            validateRequestedSlotIsFreeMachine(requestedStartTime, requestedEndTime, machine);
        } else {
            validateRequestedSlotIsFreeJob(requestedStartTime, requestedEndTime, job);
        }

        var customerRequest = new CustomerRequest();
        customerRequest.setCustomerData(customerData);
        customerRequest.setMachine(machine);
        customerRequest.setJob(job);
        customerRequest.setRequestedStartTime(requestedStartTime);
        customerRequest.setRequestedEndTime(requestedEndTime);
        customerRequest.setStatus(RequestStatus.PLANNED);

        customerRequestRepository.save(customerRequest);
    }

    private void validateRequestedSlotIsFreeMachine(LocalDateTime startTime, LocalDateTime endTime, Machine machine) {
        var overlappingStartCustomerRequests = customerRequestRepository.findByRequestedStartTimeBetweenAndMachine(startTime,
                endTime, machine);
        var overlappingEndCustomerRequests = customerRequestRepository.findByRequestedEndTimeBetweenAndMachine(startTime,
                endTime, machine);
        if (overlappingStartCustomerRequests.size() > 0 || overlappingEndCustomerRequests.size() > 0) {
            throw new BadRequestException();
        }
    }


    private void validateRequestedSlotIsFreeJob(LocalDateTime startTime, LocalDateTime endTime, Job job) {
        var overlappingStartCustomerRequests = customerRequestRepository.findByRequestedStartTimeBetweenAndJob(startTime,
                endTime, job);
        var overlappingEndCustomerRequests = customerRequestRepository.findByRequestedEndTimeBetweenAndJob(startTime,
                endTime, job);

        if (overlappingStartCustomerRequests.size() > 0 || overlappingEndCustomerRequests.size() > 0) {
            throw new BadRequestException();
        }
    }

    @Override
    public CustomerRequest completeCustomerRequest(Long customerRequestId, LocalDateTime actualStartTime, LocalDateTime actualEndTime) {
        var optionalCustomerRequest = customerRequestRepository.findById(customerRequestId);

        if (optionalCustomerRequest.isEmpty()) {
            throw new RecordNotFoundException("geen klantaanvraag gevonden");
        }
        var customerRequest = optionalCustomerRequest.get();

        customerRequest.setConfirmedStartTime(actualStartTime);
        customerRequest.setConfirmedEndTime(actualEndTime);
        customerRequest.setStatus(RequestStatus.INVOICED);

        return customerRequestRepository.save(customerRequest);
    }

    @Override
    public CustomerRequest cancelCustomerRequest(Long customerRequestId) {
        var optionalCustomerRequest = customerRequestRepository.findById(customerRequestId);

        if (optionalCustomerRequest.isEmpty()) {
            throw new RecordNotFoundException("geen klantaanvraag gevonden");
        }
        var customerRequest = optionalCustomerRequest.get();

        customerRequest.setStatus(RequestStatus.CANCELED);

        return customerRequestRepository.save(customerRequest);
    }
}
