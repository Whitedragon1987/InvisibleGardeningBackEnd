package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.models.JobRequired;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class JobRequiredDto {
    @JsonSerialize
    Long id;

    @JsonSerialize
    JobDto job;

    public static JobRequiredDto fromJobRequired(JobRequired jobRequired) {
        var dto = new JobRequiredDto();
        dto.id = jobRequired.getId();
        dto.job = JobDto.fromJob(jobRequired.getJob());
        return dto;
    }
}
