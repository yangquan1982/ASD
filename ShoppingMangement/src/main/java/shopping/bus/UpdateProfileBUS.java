package shopping.bus;

import framework.membership.StandardUserProfile;
import framework.membership.Template.AbstractUpdateProfile;
import shopping.dao.CustomerDAO;
import shopping.dao.CustomerProfileDAO;
import shopping.dao.ICustomerDAO;
import shopping.dao.ICustomerProfileDAO;
import shopping.dto.CustomerProfileDTO;

import java.sql.SQLException;

/**
 * Created by Duong Truong on 2/3/2018.
 */
public class UpdateProfileBUS extends AbstractUpdateProfile{
    private ICustomerProfileDAO profileDAO = new CustomerProfileDAO();
    @Override
    protected boolean saveProfileToDatabase(StandardUserProfile profileEncrypted) {
        try {
            return profileDAO.saveProfileToDatabase(profileEncrypted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void handleInvalidProfile() {
        System.out.println("Invalid information input");
    }

    @Override
    protected StandardUserProfile loadProfileFromInput() {
        return null;
    }

    @Override
    protected void showProfile(StandardUserProfile profileFromDatabase) {

    }

    @Override
    protected StandardUserProfile loadProfileFromDatabase() {
        return null;
    }
}
