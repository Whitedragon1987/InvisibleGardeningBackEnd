package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.JobDto;
import com.example.invisiblegardening.controllers.dto.JobInputDto;
import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("karweien")
public class JobController {
    private final JobService jobService;

    @Autowired
    public  JobController(JobService jobService) { this.jobService = jobService;}

    @GetMapping
    public List<JobDto> getJobs() {
        var dtos = new ArrayList<JobDto>();
        var jobs = jobService.getJobs();

        for (Job job : jobs) {
            dtos.add(JobDto.fromJob(job));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public JobDto getJob(@PathVariable("id") Long id) {
        var job = jobService.getJob(id);
        return JobDto.fromJob(job);
    }

    @PostMapping
    public JobDto saveJob(@RequestBody JobInputDto dto) {
        var job = jobService.saveJob(dto.toJob());
        return JobDto.fromJob(job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable("id") Long id) {
        jobService.deleteJob(id);
    }

    @PutMapping("/{id}")
    public JobDto updateJob(@PathVariable Long id, @RequestBody Job job) {
        jobService.updateJob(id, job);
        return JobDto.fromJob(job);
    }
}
