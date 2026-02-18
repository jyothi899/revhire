package org.com.rev_hire.model;

public class EmployerModel {
    private int employerId;
    private int userId;
    private int companyId;

    public EmployerModel(int userId, int employerId, int companyId) {
        this.userId = userId;
        this.employerId = employerId;
        this.companyId = companyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
