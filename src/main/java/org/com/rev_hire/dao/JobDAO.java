package org.com.rev_hire.dao;

import org.com.rev_hire.model.JobModel;

import java.util.List;

public interface JobDAO {
    boolean addJob(JobModel job);


    List<JobModel> getAllJobs();
}
