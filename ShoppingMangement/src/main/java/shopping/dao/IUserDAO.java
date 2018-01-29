package shopping.dao;

import shopping.dto.UserDTO;

import java.sql.SQLException;

public interface IUserDAO {

    UserDTO getUserByUserNameAndPassword(String username, String password) throws SQLException;

    boolean insertUser(UserDTO user) throws SQLException;

    boolean updateUser(UserDTO user) throws SQLException;
}