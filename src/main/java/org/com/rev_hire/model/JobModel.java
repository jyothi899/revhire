package org.com.rev_hire.model;

import java.util.Date;

public class JobModel {
    private int jobId;
    private int employerId;
    private String title;
    private String description;
    private String skills;
    private int experienceRequired;
    private String education;
    private String location;
    private double salary;
    private String jobType;
    private Date deadline;
    private String status;
    public JobModel(){}

    public JobModel(String skills, Date deadline, String description, String education, int employerId, int experienceRequired, int jobId, String jobType, String location, double salary, String status, String title) {
        this.skills = skills;
        this.deadline = deadline;
        this.description = description;
        this.education = education;
        this.employerId = employerId;
        this.experienceRequired = experienceRequired;
        this.jobId = jobId;
        this.jobType = jobType;
        this.location = location;
        this.salary = salary;
        this.status = status;
        this.title = title;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public int getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(int experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





}
