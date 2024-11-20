package Login;

import java.sql.*;

public class login_database {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/signup";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    
    public static boolean authenticateUser(String userID, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT * FROM user WHERE UserID = ? AND Password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userID);
            stmt.setString(2, password); 

            rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
