package org.com.rev_hire.model;

public class UserModel {
        private int userId;
        private String email;
        private String password;
        private String role; // JOB_SEEKER or EMPLOYER
        private String securityQuestion;
        private String securityAnswer;

    public UserModel(String securityQuestion, String email, String password, String role, String securityAnswer, int userId) {
        this.securityQuestion = securityQuestion;
        this.email = email;
        this.password = password;
        this.role = role;
        this.securityAnswer = securityAnswer;
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

