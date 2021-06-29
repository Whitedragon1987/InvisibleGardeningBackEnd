package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.repositories.JobRepository;
import com.example.invisiblegardening.repositories.JobRequiredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobRequiredServiceImpl implements JobRequiredService{
    private JobRequiredRepository jobRequiredRepository;
    private JobRepository jobRepository;

    @Autowired
    public JobRequiredServiceImpl(JobRequiredRepository jobRequiredRepository,
                                  JobRepository jobRepository) {
        this.jobRequiredRepository = jobRequiredRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public void assignJobToJobRequired(Long jobId, Long jobRequiredId) {
        var optionalJob = jobRepository.findById(jobId);
        var optionalJobRequired = jobRequiredRepository.findById(jobRequiredId);

        if (optionalJob.isPresent() && optionalJobRequired.isPresent()) {
            var job  = optionalJob.get();
            var jobRequired = optionalJobRequired.get();

            jobRequired.setJob(job);
            jobRequiredRepository.save(jobRequired);
        } else {
            throw new RecordNotFoundException();
        }

    }
}
