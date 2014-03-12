package presenter;

import java.io.IOException;
import javax.servlet.http.*;
import presenter.EmployeeManager;


@SuppressWarnings("serial")
public class EmployeeList extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		EmployeeManager mgr = new EmployeeManager();
		boolean success = false;
		
		
		//COLLECT ALL THE VARIOUS PARAMETERS

		String firstName = req.getParameter("firstName");
	    String lastName = req.getParameter("lastName");
	    String email = req.getParameter("email");
	    String dept = req.getParameter("dept");
		String eqType = req.getParameter("eqType");
		String eqName = req.getParameter("eqName");
		
		
		
		// CHECK FOR AN EQUIPMENT PARAMETER
		
		if (!(req.getParameter("eqType")==null || req.getParameter("eqName")==null || req.getParameter("email")==null))
		{
		
			 //ADD EQUIPMENT
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
			
			 //ASSUME NEW EMPLOYEE AND ADD THE EMPLOYEE RECORD
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

	
}


