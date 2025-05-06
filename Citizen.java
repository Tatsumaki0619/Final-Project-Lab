
/**
 * This is a program that works as a blueprint and generate the citizen's information
 *
 * @author Qianyi Li
 * @version v1.0
 * @since 5/5/2025
 */
public class Citizen
{
    private String firstName, lastName;

    /**
     * This is a no-arg constructor and will initialize the information of the citizen's first and last name into "NO Name"
     */
    public Citizen(){
        firstName = "No Name";
        lastName = "No Name";
    }

    /**
     * This is a constructor that will initialize the information of the citizen based on the user's input
     */
    public Citizen(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * This is a setter method that will initiazie the citizen's first name
     * @param inFirst the citizen's first name
     */
    public void setFirstName(String inFirst){
        firstName = inFirst;
    }

    /**
     * This is a setter method that will initiazie the citizen's last name
     * @param inLast the citizen's last name
     */
    public void setLastName(String inLast){
        lastName = inLast;
    }

    /**
     * This is a getter method that will provide the citizen's first name.
     * @return the citizen's first name
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * This is a getter method that will provide the citizen's first name.
     * @return the citizen's first name
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * This is a toString method that will print out the citizen's first name and last name.
     * @return the full name of the citizen
     */
    public String toString(){
        String ans = String.format("%s %s", firstName, lastName);
        return ans;
    }
}
