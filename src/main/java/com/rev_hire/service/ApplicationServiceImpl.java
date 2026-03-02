package com.rev_hire.service;

import com.rev_hire.dao.IApplicationDao;
import com.rev_hire.dao.ApplicationDaoImpl;
import com.rev_hire.model.Application;
import com.rev_hire.model.Notification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ApplicationServiceImpl implements IApplicationService {

    private static final Logger logger =
            LogManager.getLogger(ApplicationServiceImpl.class);

    private final IApplicationDao applicationDao;          // ✅ MUST
    private final INotificationService notificationService;

    // 🔹 REAL APP CONSTRUCTOR
    public ApplicationServiceImpl() {
        this.applicationDao = new ApplicationDaoImpl();
        this.notificationService = new NotificationServiceImpl();
    }

    // 🔹 TEST CONSTRUCTOR
    public ApplicationServiceImpl(IApplicationDao applicationDao,
                                  INotificationService notificationService) {
        this.applicationDao = applicationDao;
        this.notificationService = notificationService;
    }

    @Override
    public boolean applyJob(Application application) {
        return applicationDao.applyJob(application);
    }

    @Override
    public List<Application> getApplicationsByJobSeeker(int jobSeekerId) {
        return applicationDao.getApplicationsByJobSeeker(jobSeekerId);
    }

    @Override
    public List<Application> getApplicationsByJob(int jobId) {
        return applicationDao.getApplicationsByJob(jobId);
    }

    @Override
    public boolean updateStatus(int applicationId, String status) {

        boolean updated = applicationDao.updateStatus(applicationId, status);

        if (updated) {
            int userId = applicationDao.getUserIdByApplication(applicationId);

            if (userId != -1) {
                Notification n = new Notification();
                n.setUserId(userId);
                n.setMessage("Your application status changed to " + status);

                notificationService.sendNotification(n);
                logger.info("Notification sent to userId {}", userId);
            }
        }
        return updated;
    }

    @Override
    public boolean withdrawApplication(int applicationId, String reason) {
        return applicationDao.withdrawApplication(applicationId, reason);
    }
}