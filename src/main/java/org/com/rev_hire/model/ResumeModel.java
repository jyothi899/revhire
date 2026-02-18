package org.com.rev_hire.model;

public class ResumeModel {
    private int resumeId;
    private int seekerId;
    private String objective;
    private String education;
    private String experience;
    private String skills;
    private String projects;

    public ResumeModel(String education, String experience, String objective, String projects, int resumeId, int seekerId, String skills) {
        this.education = education;
        this.experience = experience;
        this.objective = objective;
        this.projects = projects;
        this.resumeId = resumeId;
        this.seekerId = seekerId;
        this.skills = skills;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
