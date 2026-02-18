package org.com.rev_hire.model;

import java.util.Date;

public class ApplicationModel {
    private int applicationId;
    private int jobId;
    private int seekerId;
    private String coverLetter;
    private String status; // APPLIED, SHORTLISTED, REJECTED, WITHDRAWN
    private
    Date appliedDate;

    public ApplicationModel(int applicationId, Date appliedDate, String coverLetter, int jobId, int seekerId, String status) {
        this.applicationId = applicationId;
        this.appliedDate = appliedDate;
        this.coverLetter = coverLetter;
        this.jobId = jobId;
        this.seekerId = seekerId;
        this.status = status;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
