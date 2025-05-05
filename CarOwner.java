
/**
 * Write a description of class CarOwner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarOwner
{
    private String license;
    private int month, year;
    private Citizen citizen;
    
    public CarOwner(){
        citizen.setFirstName("No Name");
        citizen.setLastName("No Name");
        license = "Not Assigned";
        month = 0;
        year = 0;
    }
    
    public CarOwner(String firstName, String lastName, String license, int month, int year){
        citizen.setFirstName(firstName);
        citizen.setLastName(lastName);
        this.license = license;
        this.month = month;
        this.year = year;
    }
    
    public void setLicense(String inLicense){
        license = inLicense;
    }
    
    public String getLicense(){
        return this.license;
    }
    
    public void setMonth(int inMonth){
        month = inMonth;
    }
    
    public int getMonth(){
        return this.month;
    }
    
    public void setYear(int inYear){
        year = inYear;
    }
    
    public int getYear(){
        return this.year;
    }
    
    // public int compareTo(Object o){
        // return ;
    // }
    
    public String toString(){
        String ans = String.format("%s\t\t%s\t\t%d/%d", citizen, getLicense(), getMonth(), getYear());
        return ans;
    }
}
