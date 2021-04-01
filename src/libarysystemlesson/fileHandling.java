
package libarysystemlesson;

import java.io.*;
import java.util.*;


public class fileHandling {
    
    private static String folderDirectory = System.getProperty("user.dir") + "\\bookList.txt";

    public static void writeFile(ArrayList<book> books) {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false); //overright
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < books.size(); i++) {
                printToFile.println(books.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<book> readFile() {
        ArrayList<book> books = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] bookDetails = lineFromFile.split(",");
                book myBook = new book(bookDetails[0], bookDetails[1], bookDetails[2], Double.parseDouble(bookDetails[3]), bookDetails[4]);
                books.add(myBook);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);

        }
        return books;
    }
}
