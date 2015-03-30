package User;

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
public abstract class User {
    String firstName;
    String lastName;
    String email;
    Password password;
    boolean instructor;
}
