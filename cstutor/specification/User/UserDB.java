package User;

import java.util.Collection;

/**
 * UserDB holds all of the registered users for cstutor. It is is derived from
 * <a href="../../requirements/functionalRequirements/login.html"> Section 2.6 
 * </a> the requirements.
 *
 * @author Kyle Reis
 */
public abstract class UserDB {
    Collection<User> users;
    
    /**
     * Adds the given user to the UserDB. Checks to make sure a user with the 
     * same email address doesn't already exist in the UserDB.
     * @param user The User to be added.
     * 
      pre:
        //There is no user with the same email in the UserDB as the user to be 
        //added.
        (! exists (User user_other ;
                users.contains(user_other) ;
                    user_other.email.equals(user.email)))
     * 
     */
    abstract void addUser(User user);
    
    /**
     * Gets a user from the UserDB based on the email address.
     * 
     * @param email The email address for the user that we want to find.
     * @return The user that has the given email or null if user doesn't exist.
     * 
      pre:
        //There are records in the database.
        (users.size() != 0)
        
      post:
        //
        // If there is a record with the given email in the input data, then the
        // output record is equal to that record, otherwise the output record
        // is null.
        //
        exists (User user_found ; users.contains(user_found) ;
                user_found.email.equals(email) && user_found.equals(return))
            ||
        !exists (User user_found ; users.contains(user_found) ;
                user_found.email.equals(email)) && return == null;
     * 
     */
    abstract User getUser(String email);
}
