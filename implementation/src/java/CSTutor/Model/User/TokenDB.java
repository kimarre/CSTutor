package CSTutor.Model.User;

import java.util.*;

/**
 * TokenDB holds all of the currently valid password reset tokens. 
 * It is is derived from
 * <a href="../../requirements/functionalRequirements/login.html"> Section 2.6 
 * </a> the requirements.
 *
 * @author Kyle Reis
 */
public class TokenDB {
    /**
     * The database of reset tokens
     */
    private Map<String, String> tokens;
    
    /**
     * Constructs a new Token Database.
     */
    public TokenDB() {
        tokens = new HashMap();
    }
    
    /**
     * Adds a token to the collection of currently valid tokens.
     * @param token the token to be added.
     * 
      pre:
        //There is no tokens that are the same as the token to be added in TokenDB
        (! exists (User token_other ;
                tokens.contains(token_other) ;
                    token_other.equals(token)))
     * 
     */
    boolean addToken(String token, String email)
    {
        if (!isToken(token))
        {
            tokens.put(token, email);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Checks to make sure that the token is a currently valid token.
     * @param token the token to be checked.
     * @return true if token is a valid token.
     * 
      pre:
        //There are tokens in the database.
        (tokens.size() != 0)
        
      post:
        //
        // If there is a token that matches the input token in the TokenDB then
        // true is returned otherwise false is returned.
        //
        exists (tokens.contains(token));
            ||
        !exists (tokens.contains(token));
     * 
     */
    boolean isToken(String token)
    {
        return tokens.containsKey(token);
    }
    
    /**
     * Removes a token from the collection of tokens.
     * @param token the token to be removed.
     * 
      pre:
        //There are tokens in the database.
        (tokens.size() != 0)
     * 
     */
    void removeToken(String token)
    {
        tokens.remove(token);
    }
}
