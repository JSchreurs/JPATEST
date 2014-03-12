package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import com.google.appengine.api.datastore.Key;


@Entity(name="Employee")
public class Employee implements Serializable
{


	private static final long serialVersionUID = 3651574605433901101L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="EMP_ID")
    private long EMP_ID;
    
    private String firstName;
    private String lastName;
    private Date hireDate;
    private int salary;
	private String email;   
    private String department;
    
    
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "employee", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Equipment> empEquipment;
        
   
    public void addEquipment(Equipment eq) {
        

        //CHECK IS THIS RECORD ALREADY EXISTS - IF NO ADD IT IN
        if (!this.empEquipment.contains(eq)) {
        	this.empEquipment.add(eq);
        } 
        
        //CHECK IF THE OWNER SHOULD BE UPDATED
        if (eq.getOwner() != this) {
            eq.setOwner(this);
        }
        
    }
    
    public List<Equipment> getAllEquipment()
    {
    	return empEquipment;
    }
        
    
    
    public void setEqList(List<Equipment> eqList) {
        this.empEquipment = eqList;
      }
    

    
    
    public long getID(){
    	return EMP_ID;
    }
    
    public void setDepartment (String dept){
    	department = dept;
    }
    
    public String getDepartment(){
    	return department;
    }
    
    public Key getKey() {
        return key;
    }
    
    
    public String getEmail(){
    	return email;
    	
    }

    public void setEmail(String eml)
    {
    	email = eml;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String fname) {
        this.firstName = fname;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lname) {
        lastName = lname;
    }

    public Date getHireDate() {
        return hireDate;
    }
    public void setHireDate(Date hdate) {
        hireDate = hdate;
    }
    
    public void setSalary(int sal){
    	salary = sal;
    }
    
    public int getSalary(){
    	return salary;
    }
   
    
    public boolean hasEquipment(){
    	
    	if(empEquipment.size()<1)
    	   return false;
    	else
    	
    		return true;
    }

    
}