package CSTutor.Model.Progress;


/****
 * Class Class is a data structure that represents a real-life class
 * taught by an instructor. Class Class provides methods to get the name of
 * the class and a list of sections under that class. 
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class Class
{
    private String name;
    
    public Class(String name)
    {
        this.name = name;
    }
    
    /**
     * Returns a string representation of the class, also know as the name of
     * the class.
     *                                                  <pre>
     pre:
       // String name must not be null.
       name != null && !name.isEmpty();
     *                                                  </pre>
     */
    public String toString()
    {
        return name;
    }
    
    /**
     * Returns the list of sections listed under this class.
     */
    public void getSections()
    {
        System.out.println("In Class.getSections");
    }
    
    /**
     * Returns if the names of the classes are the same.
     *                                                  <pre>
     pre:
       // String name must not be null.
       name != null && !name.isEmpty();
       // Class cl must not be null.
       cl != null;
     *                                                  </pre>
     */
    public boolean equals(Class cl)
    {
        if(cl.toString().equals(name))
        {
            return true;
        }
        return false;
    }

}