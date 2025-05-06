
/**
 * This is a program that works as a blueprint and intializes the inforamtion for each car owner.
 *
 * @author Qianyi Li
 * @version v1.0
 */
public class CarOwner
{
    private String license;
    private int month, year;
    private Citizen citizen = new Citizen();

    /**
     * This method works as a no-arg constructor that will initialize the information to "None" and "0"
     * for citizen's first name, last name, license, month and year.
     */
    public CarOwner(){
        citizen.setFirstName("No Name");
        citizen.setLastName("No Name");
        license = "Not Assigned";
        month = 0;
        year = 0;
    }

    /**
     * This is a constructor that will initialize the information of driver
     * for citizen's first name, last name, license, month and year.
     */
    public CarOwner(String firstName, String lastName, String license, int month, int year){
        citizen.setFirstName(firstName);
        citizen.setLastName(lastName);
        this.license = license;
        this.month = month;
        this.year = year;
    }

    /**
     * This method will set the driver's license
     */
    public void setLicense(String inLicense){
        license = inLicense;
    }

    /**
     * This method provide the driver's license
     * @return driver's license
     */    
    public String getLicense(){
        return this.license;
    }

    /**
     * This method will set the driver's valid month
     */
    public void setMonth(int inMonth){
        month = inMonth;
    }

    /**
     * This method will provide the driver's valid month
     * @return the driver's valid month
     */
    public int getMonth(){
        return this.month;
    }

    /**
     * This method will set the driver's valid year
     */
    public void setYear(int inYear){
        year = inYear;
    }

    /**
     * This method will provide the driver's valid year
     * @return the driver's valid year
     */
    public int getYear(){
        return this.year;
    }

    // public int compareTo(Object o){
    // return ;
    // }
    
    /**
     * This method will provide the outprint of the driver's information
     * @return the summary of the driver's information
     */
    public String toString(){
        String ans = String.format("%s\t\t%s\t\t%d/%d", citizen, getLicense(), getMonth(), getYear());
        return ans;
    }
}
