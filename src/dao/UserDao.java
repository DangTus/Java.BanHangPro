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
                user = new User();
                user.setId(0);
            }
            return user;
        } else {
            return null;
        }
    }

    public int signUp(User user) throws SQLException {
        Connection con = Connect.getJDBCConnection();
        String sql = "INSERT INTO user(name_user, user_name, password) "
                + "VALUES (?, ?, ?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, user.getName());
        pstm.setString(2, user.getUserName());
        pstm.setString(3, user.getPassword());

        int rs = pstm.executeUpdate();

        return rs;
    }

    public String getPassword(int id) throws SQLException {
        Connection con = Connect.getJDBCConnection();
        String sql = "SELECT password FROM user WHERE id_user = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, id);

        ResultSet rs = pstm.executeQuery();

        rs.next();

        return rs.getString("password");
    }

    // 1: thanh cong
    // 0: mat khau cu sai
    public int editPassword(int id, String passwordOld, String passwordNew) throws SQLException {
        if (passwordOld.equals(getPassword(id))) {
            Connection con = Connect.getJDBCConnection();
            String sql = "UPDATE user SET password = ? WHERE id_user = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, passwordNew);
            pstm.setInt(2, id);

            int rs = pstm.executeUpdate();

            return rs;
        } else {
            return 0;
        }
    }
}
