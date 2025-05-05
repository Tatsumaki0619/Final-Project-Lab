import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 * Write a description of class RegistrationMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class RegistrationMethods
{
    private String inputFileName, outputFileName;
    static final int REG_MONTH = 4;
    static final int REG_YEAR = 2025;

    public void setFileName() throws IOException{
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please provide the input file's location: ");
        String fileName = keyboard.next();
        File test = new File(fileName);

        do{
            System.out.print("Please check again and provide the file's location: ");
            fileName = keyboard.next();
            test = new File(fileName);
        }while(!test.exists());
        inputFileName = fileName;

        System.out.print("Please provide the input file's location: ");
        outputFileName = keyboard.next();
    }

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

    public void printArrayToFile(CarOwner[] inArray, String inMsg)throws IOException{
        FileWriter fileWriter = new FileWriter(outputFileName, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(inMsg);
        for(CarOwner owner: inArray){
            printWriter.println(owner);
        }
        printWriter.println();
    }

    public CarOwner[] flagOverdueOwners(CarOwner[] inArray){
        int monthsTotal = REG_YEAR * 12 + REG_MONTH;
        int count = 0;

        for(int i = 0; i < inArray.length; i++){
            if(inArray[i].getYear()*12 + inArray[i].getMonth() > monthsTotal){
                count++;
            }
        }
        
        int index = 0;
        CarOwner[] overdue = new CarOwner[count];
        for(int i = 0; i < inArray.length; i++){
            if(inArray[i].getYear()*12 + inArray[i].getMonth() > monthsTotal){
                overdue[index] = inArray[i];
                index++;
            }
        }
        
        return overdue;
    }

    public CarOwner[] flagAlmostdueOwners(CarOwner[] inArray){
        int count = 0;
        int monthsTotal = REG_YEAR * 12 + REG_MONTH;
        
        for(int i = 0; i < inArray.length; i++){
            if((inArray[i].getYear()-REG_YEAR)*12 - inArray[i].getMonth() + 4 > 9 && inArray[i].getYear()*12 + inArray[i].getMonth() < monthsTotal){
                count++;
            }
        }
        
        int index = 0;
        CarOwner[] nearOverdue = new CarOwner[count];
        for(int i = 0; i < inArray.length; i++){
            if((inArray[i].getYear()-REG_YEAR)*12 - inArray[i].getMonth() + 4 > 9 && inArray[i].getYear()*12 + inArray[i].getMonth() < monthsTotal){
                nearOverdue[index] = inArray[i];
                index++;
            }
        }
        
        return nearOverdue;
    }

    public String getOutputFileName()throws IOException{
        File output = new File(outputFileName);
        return output.getAbsolutePath();
    }
}
