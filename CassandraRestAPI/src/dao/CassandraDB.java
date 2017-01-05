package dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraDB {

	public static Session getSession() throws Exception {

		Cluster cluster = null;
		Session session = null;

		try {
			cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
			session = cluster.connect("Devesh");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}
}