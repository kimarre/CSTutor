package User;

/**
 * Password is a hash of the password that the user entered when registering. 
 * It is is derived from
 * <a href="../../requirements/functionalRequirements/login.html"> Section 2.6 
 * </a> the requirements.
 *
 * @author kylereis
 */
public abstract class Password {
    String Hash;
    
    /**
     * Gets the hashed version of the password.
     * @return the hash of the password.
      pre:
        Hash.length() > 0;
     */
    abstract String getPassword();
    
    /**
     * Hashes the password after first validating that the password meets length
     * and character requirements.
     * @param password The password that is trying to be set.
     * @return true if the password was valid and set.
      post:
        Hash.length() > 0;
     */
    abstract boolean setPassword(String password);
}
