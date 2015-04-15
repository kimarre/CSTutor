package CSTutor.Model.Manager;

/**
 * The user class is based on the requirement that classes need students.
 * Each user has a name and access level associated with them.
 * 
 * @author Simon Vurens
 */
public abstract class User {
   String name;
   AccessLevel access;

   /**
    * Each level corresponds to an access level. Guest is lowest, Professor
    * is highest.
    */
   enum AccessLevel {
      Guest, Student, Assistant, Professor
   }
}
