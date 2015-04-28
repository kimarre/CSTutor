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
    /**
     * The token database
     */
    TokenDB tokenDatabase;
    /**
     * The generated token
     */
    String token;
    /**
     * The cryptographically secure pseudo random number generator.
     */
    SecureRandom numGenerator;
    
    /**
     * The Constructor for RecoverPass.
     * @param tokens The token database.
     */
    public RecoverPass(TokenDB tokens)
    {
        numGenerator = new SecureRandom();
        tokenDatabase = tokens;
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
    public void generateResetToken(String email)
    {
        boolean generating = true;
        
        while (generating)
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

            //token = Base64.getEncoder().encodeToString(token.getBytes());

            System.out.println("Token: " + token);

            if(tokenDatabase.addToken(token, email))
            {
                System.out.println("Reset Token Generated");
                sendEmail();
                generating = false;
            }
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
        System.out.println("Reset token sent");
    }
}
