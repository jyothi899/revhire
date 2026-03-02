package com.rev_hire.service;

import com.rev_hire.dao.IApplicationDao;
import com.rev_hire.model.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceTest {

    @Mock
    private IApplicationDao applicationDao;

    @Mock
    private INotificationService notificationService;   // ✅ FIXED

    private ApplicationServiceImpl applicationService;

    @BeforeEach
    void setUp() {
        applicationService =
                new ApplicationServiceImpl(applicationDao, notificationService);
    }

    @Test
    void testApplyJob() {
        Application app = new Application();

        when(applicationDao.applyJob(any())).thenReturn(true);

        boolean result = applicationService.applyJob(app);

        assertTrue(result);
        verify(applicationDao).applyJob(app);
    }

    @Test
    void testGetApplicationsByJobSeeker() {
        when(applicationDao.getApplicationsByJobSeeker(101))
                .thenReturn(Arrays.asList(new Application(), new Application()));

        List<Application> result =
                applicationService.getApplicationsByJobSeeker(101);

        assertEquals(2, result.size());
    }

    @Test
    void testUpdateStatus() {
        when(applicationDao.updateStatus(1, "Reviewed")).thenReturn(true);
        when(applicationDao.getUserIdByApplication(1)).thenReturn(10);

        boolean result =
                applicationService.updateStatus(1, "Reviewed");

        assertTrue(result);

        verify(notificationService).sendNotification(any());
    }
}