
/**
 * Write a description of class Citizen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Citizen
{
    private String firstName, lastName;
    
    public Citizen(){
        firstName = "No name";
        lastName = "No Name";
    }
    
    public Citizen(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void setFirstName(String inFirst){
        firstName = inFirst;
    }
    
    public void setLastName(String inLast){
        lastName = inLast;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String toString(){
        String ans = String.format("%s %s", firstName, lastName);
        return ans;
    }
}
