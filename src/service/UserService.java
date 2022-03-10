package service;

import dao.UserDao;
import java.sql.SQLException;
import java.util.List;
import model.User;

public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User login(String userName, String password) throws SQLException {
        return userDao.login(userName, password);
    }

//    public int editPassword(int id, String passwordOld, String passwordNew, String passwordConfirm) throws SQLException {
//        return userDao.editPassword(id, passwordOld, passwordNew, passwordConfirm);
//    }
//
//    public int drawMoney(int id, long money) throws SQLException {
//        return userDao.drawMoney(id, money);
//    }
//
//    public List<User> getAllUser() throws SQLException {
//        return userDao.getAllUser();
//    }
//
//    public User getUserById(int id) throws SQLException {
//        return userDao.getUserById(id);
//    }
//
//    public int updateUserById(User user) throws SQLException {
//        return userDao.updateUserById(user);
//    }
//    
//    public int addUser(User user) throws SQLException {
//        return userDao.addUser(user);
//    }
//    
//    public int deleteUser(int id) throws SQLException {
//        return userDao.deleteUser(id);
//    }
}
