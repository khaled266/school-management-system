
package javaapplication12;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:db.db";
    private static Connection connection;

    
    //connection class
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }
    
    //methode to add Students to the database through GUI
    public static void addStudent(String name,String dateOfBirth,String email,
            String NationalID,String address,String phone,double  grade,String password){
        try(Connection conn=DriverManager.getConnection("jdbc:sqlite:db.db")){
           
            //SQlite code
            String sql = "INSERT INTO Student(Name, dateOfBirth, Email, NationalID, Address, Phone, Grade, Password) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //setting paramters to there values
            pstmt.setString(1,name);
            pstmt.setString(2,dateOfBirth);
            pstmt.setString(3,email);
            pstmt.setString(4,NationalID);
            pstmt.setString(5,address);
            pstmt.setString(6,phone);
            pstmt.setDouble(7,grade);
            pstmt.setString(8,password);
            
            //cheack if the task is done
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student added successfully!");
            
            
           
            
            
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }
    }
    
    //Method to add teachers
    public static void addTeacher(String teacherName , Integer taecherAge ,String teacherSubject
            , Double teacherSalary , String teacherPassword){
    
    try(Connection conn = DriverManager.getConnection("jdbc:sqlite:db.db")) {
            //SQlite code
            String sql = "INSERT INTO Teacher(Name, Age, subject, Salary, password) VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //setting paramters to there values
            pstmt.setString(1, teacherName);
            pstmt.setInt(2, taecherAge);
            pstmt.setString(3, teacherSubject);
            pstmt.setDouble(4, teacherSalary);
            pstmt.setString(5, teacherPassword);
            //cheack if the task is done
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Teacher added successfully!");

            } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }
    
    }
    
    //Methode to load data into table "DefaultTableModel"
    public static DefaultTableModel getStudentSubjects(String studentID) {
        DefaultTableModel model = new DefaultTableModel();

        //Addding colums to the table
        model.addColumn("Subject");
        model.addColumn("Grade");
        model.addColumn("Absence");
        
        //SQlite code
        String sql = "SELECT Arabic, ArabicAbsence, English, EnglishAbsence, Mathmatics, MathmaticsAbsence, " +
                     "Science, ScienceAbsence, SocialStudies, SocialStudiesAbsence " +
                     "FROM Student WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:db.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentID);
            ResultSet rs = pstmt.executeQuery();
                
            //setting the tabel rows
            if (rs.next()) {
                Object[][] data = {
                    {"Arabic", rs.getInt("Arabic"), rs.getInt("ArabicAbsence")},
                    {"English", rs.getInt("English"), rs.getInt("EnglishAbsence")},
                    {"Mathmatics", rs.getInt("Mathmatics"), rs.getInt("MathmaticsAbsence")},
                    {"Science", rs.getInt("Science"), rs.getInt("ScienceAbsence")},
                    {"SocialStudies", rs.getInt("SocialStudies"), rs.getInt("SocialStudiesAbsence")}
                };
                //viewing the data
                for (Object[] row : data) {
                    model.addRow(row);
                }
            }

        } catch (SQLException e) {
             
        }

        return model;
    }
    
    
    
    
    //Methode to load the top 10 students into the top10 list
    public static DefaultTableModel loadTop10(){
    DefaultTableModel model = new DefaultTableModel();
    
    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:db.db")) {
        //SQlite code
        String sql = "SELECT ID, Name, Arabic, English, Mathmatics, Science, SocialStudies, Total FROM Student ORDER BY Total DESC LIMIT 10";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        
        
        
        //Adding colums
        model.addColumn("Rank");
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Arabic");
        model.addColumn("English");
        model.addColumn("Mathmatics");
        model.addColumn("Science");
        model.addColumn("SocialStudies");
        model.addColumn("Total");

        
            //Adding data and ranking them
            int rank = 1;
            while (rs.next()) {
                Object[] row = {
                    rank++,
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getInt("Arabic"),
                    rs.getInt("English"),
                    rs.getInt("Mathmatics"),
                    rs.getInt("Science"),
                    rs.getInt("SocialStudies"),
                    rs.getInt("Total")
                };
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        
    return model; 
    }
    
}









        
    
    
    
    
    
    
    
    
    
    
    
    
    
    



