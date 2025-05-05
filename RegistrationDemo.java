import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 * Write a description of class RegistrationDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
        
        System.out.println(dmv.getOutputFileName());
    }
}
