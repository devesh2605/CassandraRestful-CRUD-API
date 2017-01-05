package model;

import java.util.ArrayList;

import dao.CassandraDB;
import dao.CrudData;
import dto.EmployeeDetails;
import dto.ResponseDetails;

public class Manager {

	public ArrayList<EmployeeDetails> getEmployeeFeeds() {

		ArrayList<EmployeeDetails> feeds = null;

		try {
			CrudData crudData = new CrudData();
			feeds = crudData.getFeeds(CassandraDB.getSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feeds;
	}

	public ArrayList<ResponseDetails> insertEmployeeFeeds(String employeeId, String employeeName, String employeeCity) {

		ArrayList<ResponseDetails> feeds = null;

		try {
			CrudData crudData = new CrudData();
			feeds = crudData.insertFeeds(CassandraDB.getSession(), employeeId, employeeName, employeeCity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feeds;
	}

	public ArrayList<ResponseDetails> updateEmployeeFeedsCity(String employeeId, String employeeCity) {

		ArrayList<ResponseDetails> feeds = null;

		try {
			CrudData crudData = new CrudData();
			feeds = crudData.updatetFeedsCity(CassandraDB.getSession(), employeeId, employeeCity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feeds;
	}

	public ArrayList<ResponseDetails> deleteEmployeeFeeds(String employeeId) {

		ArrayList<ResponseDetails> feeds = null;

		try {
			CrudData crudData = new CrudData();
			feeds = crudData.deletetFeeds(CassandraDB.getSession(), employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feeds;
	}
}