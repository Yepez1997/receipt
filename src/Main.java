import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* Driver Class */
public class Main {
    public static void Main(String args[]) {

    // TODO: READ INPUT 
    // run main + /path to directory 
     try {
         // try to open the file 
        FileInputStream fd = new FileInputStream(args[0]);
        Scanner fileScanner = new Scanner(fd); 
        System.out.println("File has been opened");

        // open and get every line 
        while(fileScanner.hasNextLine()) {
            String oneLine = fileScanner.nextLine(); 
            System.out.println(oneLine);
        }



     }
     // file not found 
     catch(FileNotFoundException fnfe) {
         System.out.println("File was not found");
     }
    }
}