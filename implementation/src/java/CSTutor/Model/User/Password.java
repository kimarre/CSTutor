package CSTutor.Model.User;

import java.util.regex.*;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Password is a hash of the password that the user entered when registering. 
 * It is is derived from
 * <a href="../../requirements/functionalRequirements/login.html"> Section 2.6 
 * </a> the requirements.
 *
 * @author Kyle Reis
 */
public class Password {
    String hash;
    
    /**
     * Gets the hashed version of the password.
     * @return the hash of the password.
      pre:
        Hash.length() > 0;
     */
    public boolean validateHash(String password)
    {
        return BCrypt.checkpw(password, hash);
    }
    
    /**
     * Hashes the password after first validating that the password meets length
     * and character requirements.
     * @param password The password that is trying to be set.
     * @return true if the password was valid and set.
      post:
        Hash.length() > 0;
     */
    boolean setPassword(String password)
    {
        boolean valid = false;
        
        if(checker(password))
        {
            hash = BCrypt.hashpw(password, BCrypt.gensalt());
            valid = true;
        }
        return valid;
        
        
        //boolean correct = BCrypt.checkpw("password", hash);
    }
    
    /**
     * Checks to see if the password meets the character requirements.
     * @param password the password to be checked.
     * @return True - if the password meets all of the criteria.
     */
    boolean checker(String password)
    {
        Pattern regex = Pattern.compile("[^!@#$%^&*()a-zA-Z0-9]");
        Matcher m = regex.matcher(password);
        return (password.length() > 5 && password.length() < 40 && !m.find());
    }
}
