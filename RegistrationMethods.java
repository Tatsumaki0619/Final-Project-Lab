import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 * This is a program that works as a blueprint to help organize and anaylize the inforamtion 
 * based on the file the user provided. This program can generate the analysis for 
 * drivers' information, overdue driver and almostoverdue drivers' inforamtion
 *
 * @author Qianyi Li
 * @version v1.0
 * @since 5/5/2025
 */
public class RegistrationMethods
{
    private String inputFileName, outputFileName;
    static final int REG_MONTH = 4;
    static final int REG_YEAR = 2025;
    
    /**
     * This is a method that will initialize the input file's path for other methods to use.
     */
    public void setFileName() throws IOException{
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please provide the input file's location (ie. c:/tmp/registration.csv): ");
        String fileName = keyboard.nextLine();
        File test = new File(fileName);
        
        while(!test.exists()){
            System.out.print("Please check again and provide the file's location: ");
            fileName = keyboard.nextLine();
            test = new File(fileName);
        }
        
        inputFileName = fileName;
        
        System.out.print("Please provide the output file's location (ie. c:/tmp/output.txt): ");
        outputFileName = keyboard.nextLine();
    }
    
    /**
     * This is a method that will calculate the number of the dirvers provided by the user. 
     * The value will be used for creating the driver's inforamtion list.
     * @return the length of the array.
     */
    public int getArraySize()throws IOException{
        File file = new File(inputFileName);
        Scanner inputFile = new Scanner(file);
        int accumulator = 0;
        inputFile.nextLine();
        
        while(inputFile.hasNextLine()){
            accumulator++;
            inputFile.nextLine();
        }
        inputFile.close();
        
        return accumulator;
    }
    
    /**
     * This is a methof that will generate the dirver's information list based on the file the user provided.
     * @param inArray an array that stores information for each drive
     */
    public void processTextToArray(CarOwner[] inArray)throws IOException{
        CarOwner carOwner = new CarOwner();
        File file = new File(inputFileName);
        Scanner inputFile = new Scanner(file);
        inputFile.nextLine();

        for(int i = 0; i < inArray.length; i++){
            String line = inputFile.nextLine();
            String temp[] = line.split(",");
            CarOwner tempOwner = new CarOwner(temp[1], temp[0], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
            inArray[i] = tempOwner;
        }

        inputFile.close();
    }
    
    /**
     * This is a method that will print information to the output fie based on the program's analysis.
     * @param inArray This contains information for each driver
     * @param inMsg This provides information for the header of the information that will be printed.
     */
    public void printArrayToFile(CarOwner[] inArray, String inMsg)throws IOException{
        FileWriter fileWriter = new FileWriter(outputFileName, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        printWriter.println(inMsg);
        for(CarOwner owner: inArray){
            printWriter.println(owner);
        }
        printWriter.println();
        
        printWriter.close();
    }
    
    /**
     * This is a method that print out information of overdue drivers.
     * @param inArray this list contains information of all the drivers based on the user's input file
     * @return The lsit of the overdue drivers
     */
    public CarOwner[] flagOverdueOwners(CarOwner[] inArray){
        int monthsTotal = REG_YEAR * 12 + REG_MONTH;
        int count = 0;

        for(int i = 0; i < inArray.length; i++){
            if(monthsTotal - (inArray[i].getYear()*12 + inArray[i].getMonth()) > 12){
                count++;
            }
        }

        int index = 0;
        CarOwner[] overdue = new CarOwner[count];
        for(int i = 0; i < inArray.length; i++){
            if(monthsTotal - (inArray[i].getYear()*12 + inArray[i].getMonth()) > 12){
                overdue[index] = inArray[i];
                index++;
            }
        }

        return overdue;
    }
    
    /**
     * This is a method that print out information of almost overdue drivers.
     * @param inArray this list contains information of all the drivers based on the user's input file
     * @return The lsit of the almost overdue drivers
     */
    public CarOwner[] flagAlmostdueOwners(CarOwner[] inArray){
        int count = 0;
        int monthsTotal = REG_YEAR * 12 + REG_MONTH;

        for(int i = 0; i < inArray.length; i++){
            if( monthsTotal - (inArray[i].getYear()*12 + inArray[i].getMonth()) > 9 && monthsTotal - (inArray[i].getYear()*12 + inArray[i].getMonth()) <= 12){
                count++;
            }
        }

        int index = 0;
        CarOwner[] nearOverdue = new CarOwner[count];
        for(int i = 0; i < inArray.length; i++){
            if( monthsTotal - (inArray[i].getYear()*12 + inArray[i].getMonth()) > 9 && monthsTotal - (inArray[i].getYear()*12 + inArray[i].getMonth()) <= 12){
                nearOverdue[index] = inArray[i];
                index++;
            }
        }

        return nearOverdue;
    }
    
    /**
     * This is a method that will print out the path to the output file.
     * @return the path to the output file
     */
    public String getOutputFileName()throws IOException{
        File output = new File(outputFileName);
        
        return output.getAbsolutePath();
    }
}
