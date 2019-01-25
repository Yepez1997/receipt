import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Driver Class */
public class Main {

    public static void main(String[] args) {

    // TODO: READ INPUT 
    // run main + /path to directory 
     try {
         // try to open the file 
        FileInputStream fd = new FileInputStream(args[0]);
        Scanner fileScanner = new Scanner(fd); 
        System.out.println("File has been opened");

        // open and get every line 
        Integer quantity = 0; 
        String itemName = "";
        Double itemCost = 0.0;

        while(fileScanner.hasNextLine()) {
            String oneLine = fileScanner.nextLine(); 
            System.out.println(oneLine);
        }
        fileScanner.close();
     }
     // file not found 
     catch(FileNotFoundException fnfe) {
         System.out.println("File was not found");
     }
    }
}