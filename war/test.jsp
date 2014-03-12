<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,presenter.EmployeeManager,model.Employee"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>Employee Manager</title>
    </head>
 
    <body>

        <hr><ol> 
        <%
            @SuppressWarnings("unchecked") 
			EmployeeManager mgr = new EmployeeManager();
			List<Employee> results;
		
			results = mgr.retrieveEmployeeList();
		
				for (Employee e : results) { %>
			    	<li><%=e.getLastName()+", "+ e.getFirstName() + " - "+ e.getDepartment() + " - "+ e.getEmail()%></li>
			    <% } %>
        </ol><hr>
        
        Add New Employee
 		<form action="/employeelist" method="post">
        First Name:<input type="text" name="firstName"/><br/>        
        Last Name:<input type="text" name="lastName"/><br/>
        Department:<input type="text" name="dept"/><br/>
        Email Address:<input type="text" name="email"/><br/>
        <input type="submit" value="submit">            
    </form>
     </body>
 </html>