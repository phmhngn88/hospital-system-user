
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phmhngn
 */
public class RoleModify {
    public static List<Role> findAll() {
        List<Role> roleList = new ArrayList<>();
        // TODO Auto-generated method stub
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hospitalDBA";
		String password = "";
		
		try {
			Connection connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connected");
			String sql = "SELECT DR.ROLE, DR.ROLE_ID, DR.PASSWORD_REQUIRED FROM DBA_ROLES DR ORDER BY DR.ROLE_ID DESC";
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Role line = new Role(resultSet.getString(1),
                                    resultSet.getString(2),resultSet.getString(3));
				
                                roleList.add(line);
				
			}
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("eo dc Biatch");
			e.printStackTrace();
		}
        return roleList;
        }
    
    public static void createRole(String role, String newPassword, boolean isNotIdentified) {
        // TODO Auto-generated method stub
                Connection connection = null;
                PreparedStatement statement = null;
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hospitalDBA";
		String password = "";
		
		try {
			connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connected");
                        
                        Statement setMode = connection.createStatement();
                        setMode.executeQuery("alter session set \"_ORACLE_SCRIPT\"=true");
                        
			String sql = new String();
                        if (isNotIdentified)
                            sql = "create role "+ role;
                        else
                            sql = "create role "+ role +" identified by " + newPassword;
			statement = connection.prepareCall(sql);
			
//                        statement.setString(1, userName);
//                        statement.setString(2, newPassword);
			
                        statement.execute();

			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("eo dc Biatch");
			e.printStackTrace();
		}
    }
    
    public static void deleteRole(String role) {
        // TODO Auto-generated method stub
                Connection connection = null;
                PreparedStatement statement = null;
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hospitalDBA";
		String password = yourpassword;
		
		try {
			connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connected");
                        
                        Statement setMode = connection.createStatement();
                        setMode.executeQuery("alter session set \"_ORACLE_SCRIPT\"=true");
                        
			String sql = "drop role "+ role;
			statement = connection.prepareCall(sql);
			
//                        statement.setString(1, userName);
//                        statement.setString(2, newPassword);
			
                        statement.execute();

			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("eo dc Biatch");
			e.printStackTrace();
		}
    }
    
    public static void editRole(String role, String newPassword, boolean isNotIdentified) {
        // TODO Auto-generated method stub
                Connection connection = null;
                PreparedStatement statement = null;
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hospitalDBA";
		String password = yourpassword;
		
		try {
			connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connected");
                        
                        Statement setMode = connection.createStatement();
                        setMode.executeQuery("alter session set \"_ORACLE_SCRIPT\"=true");
                        
			 
                        String sql = new String();
                        if (isNotIdentified) {
                            sql = "alter role "+ role +" not identified";
                        } else {
                            sql = "alter role "+ role +" identified by " + newPassword;
                        }
                            
			statement = connection.prepareCall(sql);
			
//                        statement.setString(1, userName);
//                        statement.setString(2, newPassword);
			
                        statement.execute();

			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("eo dc Biatch");
			e.printStackTrace();
		}
    }
}
