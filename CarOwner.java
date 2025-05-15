
/**
 * This is a program that works as a blueprint and intializes the inforamtion for each car owner.
 *
 * @author Qianyi Li
 * @version v1.1
 * @since 5/15/2025
 */
public class CarOwner extends Citizen
{
    private String license;
    private int month, year;
    // private Citizen citizen = new Citizen();

    /**
     * This method works as a no-arg constructor that will initialize the information to "None" and "0"
     * for citizen's first name, last name, license, month and year.
     */
    public CarOwner(){
        // citizen.setFirstName("No Name");
        // citizen.setLastName("No Name");
        super();
        license = "Not Assigned";
        month = 0;
        year = 0;
    }

    /**
     * This is a constructor that will initialize the information of driver
     * for citizen's first name, last name, license, month and year.
     */
    public CarOwner(String firstName, String lastName, String license, int month, int year){
        // citizen.setFirstName(firstName);
        // citizen.setLastName(lastName);
        super(firstName, lastName);
        this.license = license;
        this.month = month;
        this.year = year;
    }

    /**
     * This method works as a setter method and will set the driver's license
     */
    public void setLicense(String inLicense){
        license = inLicense;
    }

    /**
     * This method works as a getter method and provides the driver's license
     * @return driver's license
     */    
    public String getLicense(){
        return this.license;
    }

    /**
     * This method works as a setter method and will set the driver's valid month
     */
    public void setMonth(int inMonth){
        month = inMonth;
    }

    /**
     * This method works as a getter method and provides the driver's valid month
     * @return the driver's valid month
     */
    public int getMonth(){
        return this.month;
    }

    /**
     * This method works as a setter method and will set the driver's valid year
     */
    public void setYear(int inYear){
        year = inYear;
    }

    /**
     * This method works as a getter method and provides the driver's valid year
     * @return the driver's valid year
     */
    public int getYear(){
        return this.year;
    }
    
    /**
     * This method works as a toString method and will provide the outprint of the driver's information
     * @return the summary of the driver's information
     */
    public String toString(){
        String ans = String.format("\t\t%s\t\t%d/%d", getLicense(), getMonth(), getYear());
        return super.toString() + ans;
    }
}
