package org.com.rev_hire.model;

public class JobSeekerModel {
    private int seekerId;
    private int userId;
    private String fullName;
    private String phone;
    private String location;
    private int experienceYears;
    public JobSeekerModel(int experienceYears, String fullName, String location, String phone, int seekerId, int userId) {
        this.experienceYears = experienceYears;
        this.fullName = fullName;
        this.location = location;
        this.phone = phone;
        this.seekerId = seekerId;
        this.userId = userId;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
