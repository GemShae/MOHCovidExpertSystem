package database;

import views.Dashboard;
import views.QueryStats;

import javax.swing.*;
import java.sql.*;

public class PatientAddDb {
    private static Connection myConn;

    public PatientAddDb() {
        try {
            myConn = DBConnectorFactory.getDatabaseConnection();
        }catch (SQLException ex) {
            System.out.println("SQL Exception Occurred");
            ex.printStackTrace();
        }
    }

    public void insert(String firstName, String lastName, int age, String gender, String country, Boolean covidExposure,
                       Boolean followsProtocol, String sysmptoms, String temperature, String bloodPressure,
                       Boolean highRiskPatient, String diagnosisReport) {
        String sql = "insert into patientrecords(first_name,last_name,age,gender,country,covid_exposure," +
                "follows_protocol,symptoms,temperature,bloodPressure,highriskPatient,diagnosisReport) values (?,?,?" +
                "?,?,?,?,?,?,?,?,?)";

        //int id = 0;

        try {
            PreparedStatement ps = myConn.prepareStatement(sql);

            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ps.setInt(3,age);
            ps.setString(4,gender);
            ps.setString(5,country);
            ps.setBoolean(6,covidExposure);
            ps.setBoolean(7,followsProtocol);
            ps.setString(8,sysmptoms);
            ps.setString(9,temperature);
            ps.setString(10,bloodPressure);
            ps.setBoolean(11,highRiskPatient);
            ps.setString(12,diagnosisReport);

            ps.executeUpdate();

            System.out.println("Insert Complete");
            myConn.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void readAll() throws SQLException {
        String sql = "select* from students";

        try {
            PreparedStatement ps= myConn.prepareStatement(sql);
            ResultSet result = ps.executeQuery(sql);

            System.out.println("Data Retrieved: ");

            while (result.next()) {
                String id = result.getString("id");
                String name = result.getString("name");
                System.out.println("ID #: " + id);
                System.out.println("Name: " + name);
            }
            System.out.println("End of Data Retrieved");
        }catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void update(String id, String name) throws SQLException {
        String sql = "update students set name = ? where id = ?";

        try {
            PreparedStatement ps = myConn.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2, id);

            ps.executeUpdate();

            System.out.println("Update Complete");
        }catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void delete(String id) throws SQLException{
        String sql = "delete from students where id=?";

        try {
            PreparedStatement ps = myConn.prepareStatement(sql);

            ps.setString(1,id);

            ps.executeUpdate();

            System.out.println("Delete Complete");
        }catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void selectAllForQuery() {
        String sql = "select * from patientrecords";

        try {
            PreparedStatement ps= myConn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            QueryStats.performStats(resultSet);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }

    public void signIn (String username, String password) {

        try {
            Statement loginStatement = (Statement) myConn.createStatement();
            String sql = "Select * from login";
            ResultSet loginResultSet = loginStatement.executeQuery(sql);

            while (loginResultSet.next()) {
                String usernameVerify = loginResultSet.getString("username");
                String passwordVerify = loginResultSet.getString("password");

                if (username.equals(usernameVerify) && password.equals(passwordVerify)) {
                    new Dashboard().setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                    myConn.close();
                }
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }
}
