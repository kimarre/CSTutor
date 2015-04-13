package CSTutor.Model.User;

/**
 * RecoverPass is responsible for sending password reset email to users that
 * have asked to reset their password. It is is derived from
 * <a href="../../requirements/functionalRequirements/login.html"> Section 2.6 
 * </a> the requirements.
 *
 * @author Kyle Reis
 */
public class RecoverPass {
    UserDB userDatabase;
    TokenDB tokenDatabase;
    String token;
    
    /**
     * Generates a password reset token based on a random number generated using
     * a cryptographic pseudo random number generator. The token is then added 
     * to the tokenDatabase.
      post:
        token.length() > 0;
        &&
        tokenDatabase.tokens.length() > 0;
     */
    void generateResetToken()
    {
        token = null;
        tokenDatabase.addToken(token);
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
