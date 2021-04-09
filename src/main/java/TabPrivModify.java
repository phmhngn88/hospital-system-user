/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author phmhngn
 */
public class TabPrivModify {
    public static List<DbaTabPrivs> findAll() {
        List<DbaTabPrivs> resultTab = new ArrayList<>();
        // TODO Auto-generated method stub
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hospitalDBA";
		String password = yourpassword;
		
		try {
			Connection connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connected");
			String sql = "SELECT * FROM USER_TAB_PRIVS";
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
//			statement.setString(1, "myrole");
//			statement.setString(2, "NV001");
			while (resultSet.next()) {
				DbaTabPrivs line = new DbaTabPrivs(resultSet.getString(1),
                                    resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                                    resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),
                                    resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
				
                                resultTab.add(line);
				
			}
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("eo dc Biatch");
			e.printStackTrace();
		}
        return resultTab;
    }
    
    public static List<DbaTabPrivs> find(String objName) {
        List<DbaTabPrivs> resultTab = new ArrayList<>();
        // TODO Auto-generated method stub
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hospitalDBA";
		String password = yourpassword;
		
		try {
			Connection connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connected");
			String sql = "SELECT * FROM USER_TAB_PRIVS";
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
//			statement.setString(1, "myrole");
//			statement.setString(2, "NV001");
			while (resultSet.next()) {
                                if (objName.equals(resultSet.getString(1))) {
                                    DbaTabPrivs line = new DbaTabPrivs(resultSet.getString(1),
                                        resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                                        resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),
                                        resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));

                                    resultTab.add(line);
                                }
				
			}
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("eo dc Biatch");
			e.printStackTrace();
		}
        return resultTab;
    }
    
    public static void grantSelect(String obj, String table, boolean grantOption ) {
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
                        
			String sql = "Grant SELECT ON " + table + " to " + obj;
                        if (grantOption) {
                            sql += " with grant option";
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
    
    public static void grantDelete(String obj, String table, boolean grantOption ) {
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
                        
			String sql = "Grant DELETE ON " + table + " to " + obj;
                        if (grantOption) {
                            sql += " with grant option";
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
    
    public static void grantInsert(String obj, String table, String column, boolean grantOption ) {
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
                        
			String sql = "Grant INSERT ("+ column +") ON " + table + " to " + obj;
                        if (grantOption) {
                            sql += " with grant option";
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
    
    public static void grantUpdate(String obj, String table, String column, boolean grantOption ) {
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
                        
			String sql = "Grant UPDATE ("+ column +") ON " + table + " to " + obj;
                        if (grantOption) {
                            sql += " with grant option";
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
    
    public static void revokeSelect(String obj, String table) {
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
                        
			String sql = "REVOKE SELECT ON " + table + " FROM " + obj;
                        
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
    
    public static void revokeDelete(String obj, String table) {
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
                        
			String sql = "REVOKE DELETE ON " + table + " FROM " + obj;
                        
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
    
    public static void revokeInsert(String obj, String table) {
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
                        
			String sql = "REVOKE INSERT ON " + table + " FROM " + obj;
                        
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
    
    public static void revokeUpdate(String obj, String table) {
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
                        
			String sql = "REVOKE UPDATE ON " + table + " FROM " + obj;
                        
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
    
    public static void revokeRole(String obj, String role) {
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
                        
			String sql = "REVOKE " + role + " FROM " + obj;
                        
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
    
    public static void grantRole(String obj, String role) {
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
                        
			String sql = "GRANT " + role + " TO " + obj;
                        
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
