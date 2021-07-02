package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.models.Machine;

import java.util.List;

public interface JobService {
    List<Job> getJobs();

//    List<Job> getJobsForMachineRequest(Long machineRequestId);

    Job getJob(Long id);

    Job saveJob(Job job);

    void deleteJob(Long id);

    void updateJob(Long id, Job job);
}
