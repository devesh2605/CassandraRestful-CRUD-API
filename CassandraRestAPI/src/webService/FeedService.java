package webService;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import dto.EmployeeDetails;
import dto.ResponseDetails;
import model.Manager;

@Path("/WebService")
public class FeedService {

	@GET
	@Path("/GetEmployeeData")
	@Produces("application/json")
	public String getEmployeeData() {
		String feeds = null;

		try {
			ArrayList<EmployeeDetails> feedData = null;
			Manager manager = new Manager();
			feedData = manager.getEmployeeFeeds();
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feeds;
	}

	@POST
	@Path("/InsertEmployeeData")
	@Produces("application/json")
	public String insertEmployeeData(@FormParam("employeeId") String employeeId,
			@FormParam("employeeName") String employeeName, @FormParam("employeeCity") String employeeCity) {
		String feeds = null;

		try {
			ArrayList<ResponseDetails> feedData = null;
			Manager manager = new Manager();
			feedData = manager.insertEmployeeFeeds(employeeId, employeeName, employeeCity);
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feeds;
	}

	@PUT
	@Path("/UpdateEmployeeData")
	@Produces("application/json")
	public String updateEmployeeDataCity(@FormParam("employeeId") String employeeId,
			@FormParam("employeeCity") String employeeCity) {
		String feeds = null;

		try {
			ArrayList<ResponseDetails> feedData = null;
			Manager manager = new Manager();
			feedData = manager.updateEmployeeFeedsCity(employeeId, employeeCity);
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feeds;
	}

	@DELETE
	@Path("/DeleteEmployeeData")
	@Produces("application/json")
	public String deleteEmployeeData(@FormParam("employeeId") String employeeId) {
		String feeds = null;

		try {
			ArrayList<ResponseDetails> feedData = null;
			Manager manager = new Manager();
			feedData = manager.deleteEmployeeFeeds(employeeId);
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feeds;
	}
}