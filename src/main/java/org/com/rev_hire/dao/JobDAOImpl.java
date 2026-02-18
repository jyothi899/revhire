package org.com.rev_hire.dao;
import org.com.rev_hire.model.JobModel;
import org.com.rev_hire.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAOImpl implements JobDAO {

    @Override
    public boolean addJob(JobModel job) {

        String sql = "INSERT INTO job (employerId, title, description, skills, experienceRequired, education, location, salary, jobType, deadline, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, job.getEmployerId());
            ps.setString(2, job.getTitle());
            ps.setString(3, job.getDescription());
            ps.setString(4, job.getSkills());
            ps.setInt(5, job.getExperienceRequired());
            ps.setString(6, job.getEducation());
            ps.setString(7, job.getLocation());
            ps.setDouble(8, job.getSalary());
            ps.setString(9, job.getJobType());
            ps.setDate(10, new java.sql.Date(job.getDeadline().getTime()));
            ps.setString(11, job.getStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<JobModel> getAllJobs() {

        List<JobModel> jobs = new ArrayList<>();
        String sql = "SELECT * FROM job";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                JobModel job = new JobModel(
                        rs.getString("skills"),
                        rs.getDate("deadline"),
                        rs.getString("description"),
                        rs.getString("education"),
                        rs.getInt("employerId"),
                        rs.getInt("experienceRequired"),
                        rs.getInt("jobId"),
                        rs.getString("jobType"),
                        rs.getString("location"),
                        rs.getDouble("salary"),
                        rs.getString("status"),
                        rs.getString("title")
                );

                jobs.add(job);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobs;
    }
}
