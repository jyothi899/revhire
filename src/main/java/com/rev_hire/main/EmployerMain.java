package com.rev_hire.main;

import com.rev_hire.controller.EmployerController;
import com.rev_hire.model.Employer;
import com.rev_hire.controller.CompanyController;
import com.rev_hire.model.Company;

import java.util.List;
import java.util.Scanner;

public class EmployerMain {

    public static void start(Scanner sc, int userId) {

        EmployerController employerController = new EmployerController();
        CompanyController companyController = new CompanyController();

        Employer employer = employerController.getEmployerByUserId(userId);

        // ================= NEW EMPLOYER =================
        if (employer == null) {

            System.out.println("👋 Welcome New Employer!");
            System.out.println("1. Create New Company");
            System.out.println("2. Link Existing Company");
            System.out.print("Enter choice: ");

            int option;
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Invalid option");
                return;
            }

            int companyId = -1;

            // ================= CREATE NEW COMPANY =================
            if (option == 1) {

                Company company = new Company();

                System.out.print("Enter Company Name: ");
                company.setName(sc.nextLine());

                System.out.print("Enter Industry: ");
                company.setIndustry(sc.nextLine());

                System.out.print("Enter Company Size (e.g. 10-50, 50-200): ");
                company.setSize(sc.nextLine());

                System.out.print("Enter Description: ");
                company.setDescription(sc.nextLine());

                System.out.print("Enter Website: ");
                company.setWebsite(sc.nextLine());

                System.out.print("Enter Location: ");
                company.setLocation(sc.nextLine());

                boolean added = companyController.addCompany(company);

                if (!added) {
                    System.out.println("❌ Company creation failed");
                    return;
                }

                // Get latest company (simple approach)
                List<Company> companies = companyController.getAllCompanies();
                Company latest = companies.get(companies.size() - 1);
                companyId = latest.getCompanyId();

                System.out.println("✅ Company created with ID: " + companyId);
            }

            // ================= LINK EXISTING COMPANY =================
            else if (option == 2) {

                List<Company> companies = companyController.getAllCompanies();

                if (companies.isEmpty()) {
                    System.out.println("❌ No companies available. Create one first.");
                    return;
                }

                System.out.println("Available Companies:");
                for (Company c : companies) {
                    System.out.println("ID: " + c.getCompanyId()
                            + " | Name: " + c.getName()
                            + " | Industry: " + c.getIndustry()
                            + " | Location: " + c.getLocation());
                }

                System.out.print("Enter Company ID to link: ");
                try {
                    companyId = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("❌ Invalid ID.");
                    return;
                }
            }

            else {
                System.out.println("❌ Invalid option");
                return;
            }

            // ================= CREATE EMPLOYER PROFILE =================
            boolean created = employerController.createEmployer(userId, companyId);

            if (!created) {
                System.out.println("❌ Failed to create employer profile");
                return;
            }

            System.out.println("✅ Employer profile created successfully");

            employer = employerController.getEmployerByUserId(userId);
        }

        // ================= EMPLOYER MENU =================
        while (true) {

            System.out.println("""
                    ===== EMPLOYER MENU =====
                    1. Post New Job
                    2. View My Jobs
                    3. View Applicants
                    4. Update Application Status
                    5. Logout
                    """);

            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Please enter a valid number");
                continue;
            }

            switch (choice) {

                case 1 -> JobMain.start(sc, employer.getCompanyId());

                case 2 -> JobMain.start(sc, employer.getCompanyId());

                case 3 -> ApplicationEmployerMain.start(sc);

                case 4 -> ApplicationEmployerMain.start(sc);

                case 5 -> {
                    System.out.println("👋 Logged out");
                    return;
                }

                default -> System.out.println("❌ Invalid option");
            }
        }
    }
}