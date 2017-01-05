package dao;

import java.util.ArrayList;
import java.util.List;
import com.datastax.driver.core.Session;
import dto.EmployeeDetails;
import dto.ResponseDetails;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class CrudData {

	public ArrayList<EmployeeDetails> getFeeds(Session session) {

		ArrayList<EmployeeDetails> employeeData = new ArrayList<EmployeeDetails>();

		try {
			String query = "SELECT EMPLOYEEID, EMPLOYEENAME, EMPLOYEECITY FROM EMPLOYEE";
			ResultSet result = session.execute(query);
			List<Row> rows = result.all();

			for (Row row : rows) {
				EmployeeDetails feedObject = new EmployeeDetails();
				feedObject.setEmployeeID(row.getString("employeeid"));
				feedObject.setEmployeeName(row.getString("employeename"));
				feedObject.setEmployeeCity(row.getString("employeecity"));
				employeeData.add(feedObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeData;
	}

	public ArrayList<ResponseDetails> insertFeeds(Session session, String employeeId, String employeeName,
			String employeeCity) {

		ArrayList<ResponseDetails> response = new ArrayList<ResponseDetails>();

		try {
			String query = "INSERT INTO EMPLOYEE (EMPLOYEEID, EMPLOYEENAME, EMPLOYEECITY) VALUES ('" + employeeId
					+ "','" + employeeName + "','" + employeeCity + "')";
			session.execute(query);
			ResponseDetails details = new ResponseDetails();
			ResultSet resultSet = session.execute(query);
			boolean result = resultSet.isExhausted();
			if (result == true) {
				details.setResponse("Sucess");
			} else {
				details.setResponse("Error");
			}
			response.add(details);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public ArrayList<ResponseDetails> updatetFeedsCity(Session session, String employeeId, String employeeCity) {

		ArrayList<ResponseDetails> response = new ArrayList<ResponseDetails>();

		try {
			String query = "UPDATE EMPLOYEE SET EMPLOYEECITY = '" + employeeCity + "' WHERE EMPLOYEEID = '" + employeeId
					+ "'";
			session.execute(query);
			ResponseDetails details = new ResponseDetails();
			ResultSet resultSet = session.execute(query);
			boolean result = resultSet.isExhausted();
			if (result == true) {
				details.setResponse("Sucess");
			} else {
				details.setResponse("Error");
			}
			response.add(details);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public ArrayList<ResponseDetails> deletetFeeds(Session session, String employeeId) {

		ArrayList<ResponseDetails> response = new ArrayList<ResponseDetails>();

		try {
			String query = "DELETE FROM EMPLOYEE WHERE EMPLOYEEID = '" + employeeId + "'";
			session.execute(query);
			ResponseDetails details = new ResponseDetails();
			ResultSet resultSet = session.execute(query);
			boolean result = resultSet.isExhausted();
			if (result == true) {
				details.setResponse("Sucess");
			} else {
				details.setResponse("Error");
			}
			response.add(details);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}