package service;

import dao.UserDao;
import java.sql.SQLException;
import model.User;

public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User login(String userName, String password) throws SQLException {
        return userDao.login(userName, password);
    }
    
    public int signUp(User user) throws SQLException {
        return userDao.signUp(user);
    }
    
    public int editPassword(int id, String passwordOld, String passwordNew) throws SQLException {
        return userDao.editPassword(id, passwordOld, passwordNew);
    }
}
