package presenter;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

import model.Employee;
import presenter.EmployeeManager;
import model.Equipment;


@SuppressWarnings("serial")
public class EmployeeList extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		EmployeeManager mgr = new EmployeeManager();
		boolean success = false;
		

		String firstName = req.getParameter("firstName");
	    String lastName = req.getParameter("lastName");
	    String email = req.getParameter("email");
	    String dept = req.getParameter("dept");
		String eqType = req.getParameter("eqType");
		String eqName = req.getParameter("eqName");
		 
		if (!(req.getParameter("eqType")==null || req.getParameter("eqName")==null || req.getParameter("email")==null))
		{
			 
			 success = mgr.addEquipment(eqType, eqName,email);
			 
			 if (success)
			 {
				 resp.getWriter().println("EQUIPMENT RECORD INSERTED");
			 }
			 else
			 {
				 resp.getWriter().println("EQUIPMENT NOT ADDED (No Employee with that email, or problem accessing the database)");
			 }
			 
		}
		else
		 
		{
			 success = mgr.addEmployee(firstName, lastName, dept, email);
			 
			 if (success)
			 {
				 resp.getWriter().println("EMPLOYEE RECORD INSERTED");
			 }
			 else
			 {
				 resp.getWriter().println("ERROR INSERTING EMPLOYEE RECORD");
			 }
			 
		}
	
	}


	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			
		EmployeeManager mgr = new EmployeeManager();
		List<Employee> results;
		List<Equipment> equipList;
		boolean hasEquipment = false;
		results = mgr.retrieveEmployeeList();
		
		
		for (Employee e : results) {
	    	resp.getWriter().println(e.getLastName()+", "+ e.getFirstName() + " - "+ e.getDepartment() + " - "+ e.getEmail());
	    	resp.getWriter().println("----- Equipment Records ---------");
	    	
	    	
	    	hasEquipment = e.hasEquipment();
	    	if(hasEquipment){
	    		equipList = mgr.retrieveEmployeeEquipment(e);	    		
	    		for(Equipment q : equipList){
	    		resp.getWriter().println(q.getName()+"  -  " + q.getType());
	    		}
	    		
	    	}
	    	
	    }

		
		
	    	
	}
	


	
}


