package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.IdInputDto;
import com.example.invisiblegardening.services.JobRequiredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dienst/benodigdheden")
public class JobRequiredController {
    private final JobRequiredService jobRequiredService;

    @Autowired
    public JobRequiredController(JobRequiredService jobRequiredService) {
        this.jobRequiredService = jobRequiredService;
    }

    @PostMapping("/{id}/machine")
    public void assignJobToJobRequired(@PathVariable("id") Long jobRequiredId, @RequestBody IdInputDto input) {
        jobRequiredService.assignJobToJobRequired(jobRequiredId, input.id);
    }
}
