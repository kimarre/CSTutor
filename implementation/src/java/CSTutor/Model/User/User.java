package CSTutor.Model.User;

import CSTutor.Model.Database.TutorDB;
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
 * @author Kyle Reis (kjreis@calpoly.edu)
 */
public class User {
    /**
     * Shockingly this is the users first name.
     */
    private String firstName;
    /**
     * Shockingly this is the users last name.
     */
    private String lastName;
    /**
     * Shockingly this is the users email
     */
    private String email;
    /**
     * Shockingly this is the users password.
     */
    private static Password password;
    /**
     * Whether or not the user is an instructor.
     */
    private boolean instructor;

    /**
     * The constructor for a User.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param email The user's email address.
     * @param pass The user's password.
     * @param instructor Whether or not a user is an instructor.
     * @param newUser Whether or not this is a newly registered User.
     */
    public User(String firstName, String lastName, String email, String pass, boolean instructor, boolean newUser)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructor = instructor;
        if (newUser)
        {
            password = new Password();
            password.setPassword(pass);
        } else {
            System.out.println("Instructor: " + instructor);
            password = new Password(pass);
        }
    }
    
    /**
     * Gets a copy of the password object.
     * @return The password object for this user if one existe. Otherwise null.
     */
    public Password getPassword(){
        return password;
    }
    
    /**
     * Gets the email for this user.
     * @return The users email.
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * Gets the users full name.
     * @return The users full name.
     */
    public String getName(){
        return firstName + " " + lastName;
    }

    /**
     * Gets the users first name.
     * @return The users first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the users last Name.
     * @return The users last name.
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Whether or not the User is an instructor.
     * @return True if the user is an instructor, otherwise false.
     */
    public Boolean isInstructor()
    {
        return instructor;
    }
    
    /**
     * Makes the user an instructor.
     */
    public void setInstructor()
    {
        instructor = true;
    }

    /**
     * Validates that all of the needed information for a User was entered and
     * adds the user to the TutorDB's user table if all of the information was entered and
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
    public static boolean registerUser(String firstName, String lastName, String email, String pass, boolean instructor)
    {
        EmailValidator validator = EmailValidator.getInstance(false);
        if (TutorDB.getUser(email) == null)
        {
            User user = new User(firstName, lastName, email, pass, instructor, true);
            TutorDB.setUser(email, user.getPassword().getHash(), firstName, lastName, instructor ? "Professor" : "Student");

            return true;
        } else {
            return false;
        }
    }
}
