
package javaapplication12;


public class studentInfo extends Person {

    
    private String dateOfBirth;
    private String nationalID;
    private String Address;
    private String Phone;
    private Double Grade;
    private String password;
   

    /**
     *
     */
    
    
    public studentInfo(int id, String name, int age, String email) {
        super(id, name, age, email);
    }
    
    public studentInfo(){
        
    }
    
//Setter and Getters
    
 public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Double getGrade() {
        return Grade;
    }

    public void setGrade(Double Grade) {
        this.Grade = Grade;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    @Override
    public String toString() {
        return "studentInfo{" + "dateOfBirth=" + dateOfBirth + ", nationalID=" + nationalID + ", Address=" + Address + ", Phone=" + Phone + ", Grade=" + Grade + '}';
    }

        
   
    
        
    
    
}
