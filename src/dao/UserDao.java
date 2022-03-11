package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.User;

public class UserDao {

    User user = null;

    public User login(String userName, String password) throws SQLException {
        Connection con = Connect.getJDBCConnection();
        String sql = "SELECT * FROM user WHERE user_name = ?";
        PreparedStatement prepareStatement = con.prepareStatement(sql);
        prepareStatement.setString(1, userName);
        ResultSet rs = prepareStatement.executeQuery();
        if (rs.next()) {
            if (password.equals(rs.getString("password"))) {
                user = new User(rs.getInt("id_user"), rs.getString("name_user"), userName, password);
            } else {
                user.setId(0);
            }
            return user;
        } else {
            return null;
        }
    }
}
