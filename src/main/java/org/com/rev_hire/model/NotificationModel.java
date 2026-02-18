package org.com.rev_hire.model;

import java.util.Date;

public class NotificationModel {
    private int notificationId;
    private int userId;
    private String message;
    private boolean isRead;
    private Date createdAt;

    public NotificationModel(int userId, int notificationId, String message, boolean isRead, Date createdAt) {
        this.userId = userId;
        this.notificationId = notificationId;
        this.message = message;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
