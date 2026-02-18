package org.com.rev_hire.model;

public class CompanyModel {
    private int companyId;
    private String name;
    private String industry;
    private String size;
    private String description;
    private String website;
    private String location;

    public CompanyModel(int companyId, String description, String industry, String location, String name, String size, String website) {
        this.companyId = companyId;
        this.description = description;
        this.industry = industry;
        this.location = location;
        this.name = name;
        this.size = size;
        this.website = website;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
