package CSTutor.Model.User;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * Register is responsible for validating registration information and creating
 * and adding the user to the UserDB. It is is derived from
 * <a href="../../requirements/functionalRequirements/login.html"> Section 2.6 
 * </a> the requirements.
 * 
 * @author Kyle Reis
 */
public class Register {
    UserDB database;
    
    public Register(UserDB database)
    {
        this.database = database;
    }
    /**
     * Validates that all of the needed information for a User was entered and
     * adds the user to the UserDB if all of the information was entered and 
     * there isn't already a user with that information.
     * 
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param email The user's email address.
     * @param pass The user's password.
     * @param instructor Whether or not a user is an instructor.
     * 
       post:
         database.users.length() > 0;
     */
    public boolean createUser(String firstName, String lastName, String email, String pass, boolean instructor)
    {
        EmailValidator validator = EmailValidator.getInstance(false);
        if (validator.isValid(email))
        {
            User user = new User(firstName, lastName, email, pass, instructor);
            database.addUser(user);
            return true;
        } else {
            return false;
        }
        //User user = new User();
        //database.addUser(user);
        //System.out.println("New User Created.");
    }
}
