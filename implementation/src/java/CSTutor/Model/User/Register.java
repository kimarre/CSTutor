package CSTutor.Model.User;

/**
 * Register is responsible for validating registration information and creating
 * and adding the user to the UserDB. It is is derived from
 * <a href="../../requirements/functionalRequirements/login.html"> Section 2.6 
 * </a> the requirements.
 * 
 * @author Kyle Reis
 */
public class Register {
    UserDB database = new UserDB();
    
    /**
     * Validates that all of the needed information for a User was entered and
     * adds the user to the UserDB if all of the information was entered and 
     * there isn't already a user with that information.
     * 
       post:
         database.users.length() > 0;
     */
    void createUser()
    {
        User user = new User();
        database.addUser(user);
    }
}
