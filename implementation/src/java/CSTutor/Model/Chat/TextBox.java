package CSTutor.Model.Chat;

/**
 * TextBox is an object that takes user inputted text and transfers to the data to the console.
 * 
 *  @author Stephen Daily
 */


public class TextBox{
    String buffer;
    StudentText convertedText;
    
    
    public TextBox(String buffer) {
    	this.buffer = buffer; 
    }
    
    /**
     * pushText will take the text in the buffer, and push it to the console.
     *
     * pre:
             //
             // The string isn't null
             //
         (text != null);
     *
     */
     public void pushText() {
    	 convertedText = new StudentText(buffer);
     }
}
