package presenter;



import java.io.IOException;




import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presenter.EmployeeManager;

@SuppressWarnings("serial")
public class cleanUp extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
// Manual Clean Up
/*
      http://localhost:8888/_ah/admin/
 */
		
		EmployeeManager mgr = new EmployeeManager();
		boolean result;
		
		result = mgr.eraseAllRecords();
		
		if (result)
			resp.getWriter().print("All Records Moved");
		else
			resp.getWriter().print("Error Occured Removing Records");

  }
}
	