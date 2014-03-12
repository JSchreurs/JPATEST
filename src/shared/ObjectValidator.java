package shared;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Employee;

public class ObjectValidator {
	
	
	public boolean checkForDuplicate(Employee empObject)
	{
		boolean isDuplicate = false;
		EntityManager em = EMF.get().createEntityManager();
		TypedQuery<Employee> myQuery;
		List<Employee> results;
		
		myQuery = em.createQuery("SELECT e FROM Employee e where e.email = :email", Employee.class);
		myQuery.setParameter("email", empObject.getEmail());
		results = myQuery.getResultList();
		
		if (!(results.isEmpty())) 
	    {
			isDuplicate = true;
	    }		
					
		if (isDuplicate)
			return true;
		else
			return false;
		
	}
	
	public Employee findEmployee(String email){
		EntityManager em = EMF.get().createEntityManager();
		TypedQuery<Employee> myQuery;
		Employee result;
		
		
		myQuery = em.createQuery("SELECT e FROM Employee e where e.email = :email", Employee.class);
		myQuery.setParameter("email", email);
		
		result = myQuery.getSingleResult();
		
		try
		{
			if  (result.getEmail().length()>3)
			{
			return result;
			}
			else
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			return null;
		}
		finally{
			
			em.close();
		}
				
	}
	
}
