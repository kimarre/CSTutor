package Progress;

/****
 * Class ListItem creates a customizable item that populates the lists in the side bars
 * of the Student and Instructor UIs.
 * @author Erica Solum
 * @version 6Apr15
 */
public class ListItem
{
    private boolean isHeader;
    private String title;
    
    public ListItem(String title, boolean header)
    {
        this.title = title;
        this.isHeader = header;
    }
}
