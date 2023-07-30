package segurity;
import dao.UserDAO;
import model.User;
public class UserAccessControl {
    public boolean userAuthenticate(String userName, String password){
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUserName(userName);
        if(user != null){
            if(user.getUserPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
