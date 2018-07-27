package org.gntp.db;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBConnection {
public static Connection getConnection() throws NamingException, SQLException, ClassNotFoundException {
	
	Context initCtv = new InitialContext();
	Context envCtv = (Context) initCtv.lookup("java:comp/env");
	DataSource ds = (DataSource) envCtv.lookup("jdbc/mariadb");
	Connection conn = ds.getConnection();
	
	return conn;
}
}
