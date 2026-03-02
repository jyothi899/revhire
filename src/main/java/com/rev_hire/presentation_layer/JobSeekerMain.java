package com.rev_hire.presentation_layer;

import com.rev_hire.controller.JobController;
import com.rev_hire.controller.JobSeekerController;
import com.rev_hire.model.Job;
import com.rev_hire.model.JobSeeker;

import java.util.List;
import java.util.Scanner;

public class JobSeekerMain {

    public static void start(Scanner sc, int userId) {

        JobController jobController = new JobController();
        JobSeekerController controller = new JobSeekerController();

        JobSeeker js = controller.getJobSeekerByUserId(userId);

        if (js == null) {
            System.out.println("👋 Welcome New Job Seeker!");

            js = new JobSeeker();
            js.setUserId(userId);

            System.out.print("Enter Name: ");
            js.setName(sc.nextLine());

            System.out.print("Enter Phone: ");
            js.setPhone(sc.nextLine());

            System.out.print("Experience (years): ");
            try {
                js.setExperienceYears(Integer.parseInt(sc.nextLine()));
            } catch (Exception e) {
                js.setExperienceYears(0);
            }

            js.setProfileCompletion(40);

            if (!controller.createJobSeeker(js)) {
                System.out.println("❌ Failed to create profile");
                return;
            }

            js = controller.getJobSeekerByUserId(userId);
        }

        while (true) {
            System.out.println("""
                    ===== JOB SEEKER MENU =====
                    1. View Profile
                    2. Search Jobs
                    3. Manage Resume
                    4. Apply / View Applications
                    5. View Notifications
                    6. Logout
                    """);

            System.out.print("Enter choice: ");
            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Enter valid number");
                continue;
            }

            switch (choice) {
                case 1 -> controller.viewProfile(userId);

                case 2 -> {
                    List<Job> jobs = jobController.searchJobs();

                    if (jobs.isEmpty()) {
                        System.out.println("❌ No jobs available");
                    } else {
                        for (Job job : jobs) {
                            System.out.println(
                                    "Job ID: " + job.getJobId()
                                            + " | Title: " + job.getTitle()
                                            + " | Location: " + job.getLocation()
                                            + " | Experience: " + job.getExperienceRequired()
                                            + " | Salary: " + job.getSalaryRange()
                            );
                        }
                    }
                }

                case 3 -> ResumeMain.start(sc, js.getJobSeekerId());

                case 4 -> {
                    int resumeId = controller.getResumeId(js.getJobSeekerId());
                    if (resumeId == -1) {
                        System.out.println("❌ Create resume first");
                    } else {
                        ApplicationJobSeekerMain.start(sc, js.getJobSeekerId(), resumeId);
                    }
                }

                case 5 -> NotificationMain.start(sc, userId);

                case 6 -> {
                    System.out.println("👋 Logged out");
                    return;
                }

                default -> System.out.println("❌ Invalid option");
            }
        }
    }
}