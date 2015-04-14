package CSTutor.Model.Manager;

/**
 * Derived from section 2.2.
 *
 * Each Page is either a page in the tutorial or a quiz. 
 * However, they are treated the same way by the manager, 
 * as they are part of a Tutorial. The name is the name of the page.
 */
public abstract class Page {
   String name;
}
