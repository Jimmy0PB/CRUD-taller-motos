package segurity;
import dao.UserDAO;
import model.User;
public class UserAccessControl {
    public boolean userAuthenticate(String userName, String Password){
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUserName(userName);
        if(user != null){
            if(user.getUserPassword().equals(Password)){
                return true;
            }
        }
        return false;
    }
}
