package CSTutor.Model.User;

import java.util.*;
import java.security.*;

/**
 * RecoverPass is responsible for sending password reset email to users that
 * have asked to reset their password. It is is derived from
 * <a href="../../requirements/functionalRequirements/login.html"> Section 2.6 
 * </a> the requirements.
 *
 * @author Kyle Reis
 */
public class RecoverPass 
{
    UserDB userDatabase;
    TokenDB tokenDatabase;
    String token;
    SecureRandom numGenerator;
    
    public RecoverPass()
    {
        numGenerator = new SecureRandom();
        tokenDatabase = new TokenDB();
    }
    
    /**
     * Generates a password reset token based on a random number generated using
     * a cryptographic pseudo random number generator. The token is then added 
     * to the tokenDatabase.
      post:
        token.length() > 0;
        &&
        tokenDatabase.tokens.length() > 0;
     */
    public void generateResetToken()
    {
        token = "";
        
        for (int i = 0; i <=6; i++)
        {
            token += Integer.toString(numGenerator.nextInt());
            if (i != 6)
            {
                token += ':';
            }
        }
        
        System.out.println(token);
        
        //token = Base64.getEncoder().encodeToString(token.getBytes());
        
        System.out.println(token);
        
        if(tokenDatabase.addToken(token))
        {
            sendEmail();
            System.out.println("Reset Token Generated");
        } else {
            // generate again
        }
        
    }
    
    /**
     * Sends the user an email with the reset token so that they can reset their
     * password.
      pre:
        token.length() > 0;
      post:
        token.length() == 0;
     */
    void sendEmail()
    {
        //this might not get implemented
    }
}
