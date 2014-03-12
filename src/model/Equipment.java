package model;

import javax.persistence.GenerationType;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;



@Entity(name="Equipment")
public class Equipment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4490215937264880467L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key equipmentKey;
	
	
	private Date eqAssignmentDate;
	private String eqType;
	private String eqName;
	

	@ManyToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="employee")
	private Employee employee;
	

	public void setOwner(Employee emp) {
	        
			//UPDATE OWNER RECORD
			this.employee = emp;
	        
	    }
	
	 public Employee getOwner()
	 {
		 return employee;
	 }
 
	public Key getKey(){
		return equipmentKey;
	}
	
	public Date getAssignmentDate(){
		return eqAssignmentDate;
	}
	
	public String getType(){
		return eqType;
	}
	
	public String getName(){
		return eqName;
	}

	public void setEquipmentType(String t){
		eqType = t;
	}
	
	public void setAssignmentDate(Date d){
		eqAssignmentDate = d;
	}
	
	public void setEquipmentName(String n){
		eqName = n;
	}

}
