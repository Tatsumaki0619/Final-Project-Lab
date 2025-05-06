import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 * This is a program that will generate an analysis for drivers' information and another two tables for overdue drivers 
 * and almost due driver's information. The user needs to provide the input file(registration.csv) and the path to the output file.
 *
 * @author Qianyi Li
 * @version v1.0
 * @since 5/5/2025
 */
public class RegistrationDemo
{
    public static void main(String[] args)throws IOException{
        RegistrationMethods dmv = new RegistrationMethods();
        dmv.setFileName();
        int size = dmv.getArraySize();
        CarOwner[] ltState = new CarOwner[size];
        dmv.processTextToArray(ltState);
        String inMsg = "List of Car Owners";
        dmv.printArrayToFile(ltState, inMsg);
        
        CarOwner[] overdue = dmv.flagOverdueOwners(ltState);
        String overdueInMsg = "Owners with Expired Registration";
        dmv.printArrayToFile(overdue, overdueInMsg);
        
        CarOwner[] almostOverdue = dmv.flagAlmostdueOwners(ltState);
        String almostOverdueInMsg = "Owners with registration expiring in three months or less";
        dmv.printArrayToFile(almostOverdue, almostOverdueInMsg);
        
        System.out.println("The output file can be found at: "+dmv.getOutputFileName());
    }
}
