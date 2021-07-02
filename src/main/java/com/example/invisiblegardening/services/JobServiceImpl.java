package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.repositories.JobRepository;
import com.example.invisiblegardening.repositories.MachineRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{
    private JobRepository jobRepository;
    private MachineRequestRepository machineRequestRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository,
                          MachineRequestRepository machineRequestRepository) {
        this.jobRepository = jobRepository;
        this.machineRequestRepository = machineRequestRepository;
    }

//  vind alle diensten en geef deze in een lijst terug
    @Override
    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

////  vind alle machines voor een machineRequest en geef deze in een lijst terug
//    @Override
//    public List<Job> getJobsForMachineRequest(Long machineRequestId) {
//        var optionalMachineRequest = machineRequestRepository.findById(machineRequestId);
//
//        if(optionalMachineRequest.isPresent()) {
//            var machineRequest = optionalMachineRequest.get();
//            return jobRepository.findByMachineRequest(machineRequest);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }

//  vind een dienst op basis van een id
    @Override
    public Job getJob(Long id) {
        return jobRepository.getById(id);
    }

//  sla een nieuwe dienst op
    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

//  verwijder een dienst aan de hand van het id
    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

//  wijzig een bestaande dienst aan de hand van het id
    @Override
    public void updateJob(Long id, Job job) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            jobRepository.save(job);
        } else {
            throw new RecordNotFoundException("job does not exist");
        }
    }
}
