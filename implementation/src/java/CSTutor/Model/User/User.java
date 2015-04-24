package CSTutor.Model.User;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * User holds the information for a registered user of CSTutor. The first and 
 * last names are used for identification purposes by other users. The email
 * address is used to contact the user and as a unique identifier for each user.
 * The password is a hashed version of the users password which is used to
 * authenticate the user on login. Instructor is used to indicate whether or
 * not the user is an instructor.
 * 
 * <p>
 * A User is derived from
 * <a href="../../requirements/functionalRequirements/login.html"> Section 2.6 
 * </a> the requirements.
 * @author Kyle Reis
 */
public class User {
    String firstName;
    String lastName;
    String email;
    private static Password password;
    boolean instructor;
    
    /**
     * The constructor for a User.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param email The user's email address.
     * @param pass The user's password.
     * @param instructor Whether or not a user is an instructor.
     */
    public User(String firstName, String lastName, String email, String pass, boolean instructor)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructor = instructor;
        password = new Password(pass);
    }
    
    public Password getPassword(){
        return password;
    }
}
