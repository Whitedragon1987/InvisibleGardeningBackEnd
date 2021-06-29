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
public class RequestServiceImpl implements RequestService {
    private RequestRepository requestRepository;
    private MachineRepository machineRepository;
    private CustomerRequestRepository customerRequestRepository;
    private JobRepository jobRepository;
    private CustomerDataRepository customerDataRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository,
                              MachineRepository machineRepository,
                              CustomerRequestRepository customerRequestRepository,
                              JobRepository jobRepository,
                              CustomerDataRepository customerDataRepository) {
        this.requestRepository = requestRepository;
        this.machineRepository = machineRepository;
        this.customerRequestRepository = customerRequestRepository;
        this.jobRepository = jobRepository;
        this.customerDataRepository = customerDataRepository;
    }

    @Override
    public List<Request> getRequestsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return requestRepository.findByPlannedStartTimeBetween(start, end);
    }

    @Override
    public List<Request> getRequestsForMachines(Long machineId) {
        var optionalMachine = machineRepository.findById(machineId);
        if ( optionalMachine.isPresent()) {
            var machine = optionalMachine.get();
            return requestRepository.findByMachine(machine);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public List<Request> getRequestsForCustomerRequest(Long customerRequestId) {
        var optionalCustomerRequest = customerRequestRepository.findById(customerRequestId);
        if ( optionalCustomerRequest.isPresent()) {
            var customerRequest = optionalCustomerRequest.get();
            return requestRepository.findByCustomerRequest(customerRequest);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public List<Request> getRequestsForJob(Long jobId) {
        var optionalJob = jobRepository.findById(jobId);
        if ( optionalJob.isPresent()) {
            var job = optionalJob.get();
            return requestRepository.findByJob(job);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void assignMachineToRequest(Long machineId, Long requestId) {
        var optionalMachine = machineRepository.findById(machineId);
        var optionalRequest = requestRepository.findById(requestId);

        if (optionalRequest.isPresent() && optionalMachine.isPresent()) {
            var request  = optionalRequest.get();
            var machine = optionalMachine.get();

            request.setMachine(machine);
            requestRepository.save(request);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void assignCustomerRequestToRequest(Long customerRequestId, Long requestId) {
        var optionalCustomerRequest = customerRequestRepository.findById(customerRequestId);
        var optionalRequest = requestRepository.findById(requestId);

        if (optionalRequest.isPresent() && optionalCustomerRequest.isPresent()) {
            var request  = optionalRequest.get();
            var customerRequest = optionalCustomerRequest.get();

            request.setCustomerRequest(customerRequest);
            requestRepository.save(request);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void assignJobToRequest(Long jobId, Long requestId) {
        var optionalJob = jobRepository.findById(jobId);
        var optionalRequest = requestRepository.findById(requestId);

        if (optionalRequest.isPresent() && optionalJob.isPresent()) {
            var request  = optionalRequest.get();
            var job = optionalJob.get();

            request.setJob(job);
            requestRepository.save(request);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void assignCustomerDataToRequest(Long customerDataId, Long requestId) {
        var optionalCustomerData = customerDataRepository.findById(customerDataId);
        var optionalRequest = requestRepository.findById(requestId);

        if (optionalRequest.isPresent() && optionalCustomerData.isPresent()) {
            var customerData = optionalCustomerData.get();
            var request = optionalRequest.get();

            request.setCustomerData(customerData);
            requestRepository.save(request);
        }
    }

    @Override
    public void planRequest(Long customerRequestId, Long machineId, Long jobId, LocalDateTime plannedStartTime, LocalDateTime plannedEndTime) {
        var optionalCustomerRequest = customerRequestRepository.findById(customerRequestId);
        var optionalMachine = machineRepository.findById(machineId);
        var optionalJob = jobRepository.findById(jobId);

        if (optionalCustomerRequest.isEmpty() && (optionalMachine.isEmpty() && optionalJob.isEmpty())) {
            throw new RecordNotFoundException();
        }

        var customerRequest = optionalCustomerRequest.get();
        var machine = optionalMachine.get();
        var job = optionalJob.get();

        validateRequestSlotIsFree(plannedStartTime, plannedEndTime, machine, job);

        var request = new Request();
        request.setCustomerRequest(customerRequest);
        request.setMachine(machine);
        request.setJob(job);
        request.setPlannedStartTime(plannedStartTime);
        request.setPlannedEndTime(plannedEndTime);
        request.setStatus(RequestStatus.PLANNED);

        requestRepository.save(request);
    }

    private void validateRequestSlotIsFree(LocalDateTime startTime, LocalDateTime endTime, Machine machine, Job job) {
        var overlappingStartRequests = requestRepository.findByPlannedStartTimeBetweenAndMachineAndJob(startTime, endTime, machine, job);
        var overlappingEndRequests = requestRepository.findByPlannedEndTimeBetweenAndMachineAndJob(startTime, endTime, machine, job);
        if ( overlappingStartRequests.size() > 0 || overlappingEndRequests.size() > 0) {
            throw new BadRequestException();
        }
    }

    @Override
    public Request completeRequest(Long requestId, LocalDateTime actualStartTime, LocalDateTime actualEndTime) {
        var optionalRequest = requestRepository.findById(requestId);

        if ( optionalRequest.isEmpty()) {
            throw new RecordNotFoundException();
        }
        var request = optionalRequest.get();

        request.setActualStartTime(actualStartTime);
        request.setActualEndTime(actualEndTime);
        request.setStatus(RequestStatus.INVOICED);

        return requestRepository.save(request);
    }
}
