package CSTutor.Model.Manager;

/**
 * Class User represents a user in the system.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public abstract class User {
	/* The name of the user */
   String name;
   /* The access level of the user*/
   AccessLevel access;

   /**
    * Each level corresponds to an access level. Guest is lowest, Professor
    * is highest.
    */
   enum AccessLevel {
      Guest, Student, Assistant, Professor
   }
}
