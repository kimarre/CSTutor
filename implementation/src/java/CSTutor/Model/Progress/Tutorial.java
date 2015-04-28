package CSTutor.Model.Progress;

public class Tutorial
{
    private String name;
    private boolean complete;
    
    
    public Tutorial(String name)
    {
        this.name = name;
        complete = false;
    }
    
    public String toString()
    {
        return name;
    }

}