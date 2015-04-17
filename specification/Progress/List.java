package Progress;

/**
 * Expandable list type that will be displayed in the left side bar.
 */
public abstract class List{
    private String name;
    private Collection<String> topics;
    
    /**
     * Adds a link to the list.
     *                                 <pre>

      pre:
        // The String topic must not equal null.
        topic != null
 
          &&

        // The String topic must not be empty.
        !topic.isEmpty();
   
      post:
        // The String topic is now in this.topics.
        topics'.contains(topic);
     *
     */
    public abstract void addToList(String topic);
}
