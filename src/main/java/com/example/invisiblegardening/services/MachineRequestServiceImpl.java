//package com.example.invisiblegardening.services;
//
//import com.example.invisiblegardening.exeptions.RecordNotFoundException;
//import com.example.invisiblegardening.models.*;
//import com.example.invisiblegardening.repositories.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MachineRequestServiceImpl implements MachineRequestService {
//    private MachineRequestRepository machineRequestRepository;
//    private CustomerRequestRepository customerRequestRepository;
//
//    @Autowired
//    public MachineRequestServiceImpl(MachineRequestRepository machineRequestRepository,
//                                     CustomerRequestRepository customerRequestRepository) {
//        this.machineRequestRepository = machineRequestRepository;
//        this.customerRequestRepository = customerRequestRepository;
//
//    }
//
//    @Override
//    public MachineRequest getMachineRequest(Long id) {
//        Optional<MachineRequest> machineRequest = machineRequestRepository.findById(id);
//
//        if(machineRequest.isPresent()) {
//            return machineRequest.get();
//        } else {
//            throw new RecordNotFoundException("MachineRequest does not exist");
//        }
//    }
//
//    @Override
//    public MachineRequest saveMachineRequest(MachineRequest machineRequest) {
//        return machineRequestRepository.save(machineRequest);
//    }
//
//    @Override
//    public void deleteMachineRequest(Long id) {
//        machineRequestRepository.deleteById(id);
//    }
//
//    @Override
//    public void updateMachineRequest(Long id, MachineRequest machineRequest) {
//        Optional<MachineRequest> optionalMachineRequest = machineRequestRepository.findById(id);
//        if(optionalMachineRequest.isPresent()) {
//            machineRequestRepository.save(machineRequest);
//        } else {
//            throw new RecordNotFoundException("Machine does not exist");
//        }
//    }
//
//    @Override
//    public void assignCustomerRequestToMachineRequest(Long machineRequestId, Long customerRequestId) {
//        var optionalMachineRequest = machineRequestRepository.findById(machineRequestId);
//        var optionalCustomerRequest = customerRequestRepository.findById(customerRequestId);
//
//        if (optionalCustomerRequest.isPresent() && optionalMachineRequest.isPresent()) {
//            var machineRequest = optionalMachineRequest.get();
//            var customerRequest = optionalCustomerRequest.get();
//
//            machineRequest.setCustomerRequest(customerRequest);
//            machineRequestRepository.save(machineRequest);
//        }else {
//            throw new RecordNotFoundException("data niet gevonden");
//        }
//    }
//}
