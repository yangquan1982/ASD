package shopping.dao;

import shopping.dto.UserProfileDTO;

import java.sql.SQLException;
import java.util.List;

public interface IUserProfileDAO {

    List<UserProfileDTO> getUserSettingsByUsername(String username) throws SQLException;

    boolean insertUserSetting(UserProfileDTO userProfile) throws SQLException;

    boolean updateUserSetting(UserProfileDTO userProfile) throws SQLException;
}