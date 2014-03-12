<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,javax.persistence.EntityManager,presenter.EmployeeManager,model.Employee,model.Equipment,shared.EMF"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>Employee Manager</title>
    </head>
 
    <body>

<%
		EntityManager em = EMF.get().createEntityManager();
		EmployeeManager mgr = new EmployeeManager();
		List<Employee> results;
		List<Equipment> equipList;
		results = mgr.retrieveEmployeeList();
		
		for (Employee e : results) 
		{
%>			<p />
	    	<%= e.getLastName()+", "+ e.getFirstName() + " - "+ e.getDepartment() + " - "+ e.getEmail() %>
	    	<hr />
	    	<%
	    	equipList = em.merge(e).getAllEquipment();	
	    	
	    	for(Equipment eq : equipList)
	    	{
	    			equipList = mgr.retrieveEmployeeEquipment(e);%>	    		
	    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    			<%=eq.getName()+"  -  " + eq.getType()%>
	    			<br />
	    	<%		
	    	}
	    		
	    }
%>

</body>

</html>