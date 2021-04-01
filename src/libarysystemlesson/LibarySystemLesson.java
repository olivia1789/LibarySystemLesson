
package libarysystemlesson;

import java.util.Scanner;
import java.util.ArrayList;


public class LibarySystemLesson {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<book> bookList = new ArrayList<>();
    
    public static void main(String[] args) {
        
        bookList = fileHandling.readFile();
        mainMenu();
    }
    public static void mainMenu() {
        System.out.println("Welcome to my libary system");
        while (true) {
            System.out.println("What would you like to do next");
            System.out.println("1- Add a new book");
            System.out.println("2- View all books");
            System.out.println("3- Edit a book");
            System.out.println("4- Delete a book");

            System.out.println("0- Exit");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
//                case 3:
//                    editBook();
//                    break;
//                case 4:
//                    deleteBook();
//                    break;
//                case 5:
//                    borrowBook();
//                    break;
//                case 0:
//                    fileHandling.writeFile(bookList);
//                    System.exit(0);
            }
        }
    }
    public static void addBook(){
        //String name, String ISBN, String author, double price, String genre
        System.out.println("Please type in a name");
        input.nextLine();//to stop it skipping lines
        String name = input.nextLine();
        System.out.println("Please type in an ISBN");
        String ISBN = input.next();
        System.out.println("Please type in an author");
        input.nextLine();//to stop it skipping lines
        String author = input.nextLine();
        System.out.println("Please type in a price");
        double price = input.nextDouble();
        System.out.println("Please type in a genre");
        input.nextLine();//to stop it skipping lines
        String genre = input.nextLine();
        
        book myBook = new book(name,ISBN,author,price,genre);
        bookList.add(myBook);
        
        System.out.println(myBook.toString());
    }
    public static void viewBooks(){
        //print the books bookList bit
        
        if(bookList.isEmpty()){
            System.out.println("Sorry, there are no books right now");
        }
        else{
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(bookList.get(i).toString());
                
            }
        }
    }
    
    public static void editBook(){        
        //find the book they are after
        //do bookList.get(number)
        
        int index = getBookIndex();
            if(index != -1){
                System.out.println("Which bit would you like to edit");
                System.out.println("1- name");
                System.out.println("2- ISBN");
                System.out.println("3- author");
                System.out.println("4- price");
                System.out.println("5- genre");
                int userChoice = input.nextInt();
                switch (userChoice) {
                    case 1:
                        System.out.println("please type in the name");
                        input.nextLine();//to stop it skipping lines
                        String newName = input.nextLine();
                        bookList.get(index).setName(newName);
                        break;
                    case 2:
                        System.out.println("please type in the ISBN");
                        input.nextLine();//to stop it skipping lines
                        String newISBN = input.nextLine();
                        bookList.get(index).setISBN(newISBN);
                        break;
                    case 3:
                        System.out.println("please type in the author");
                        input.nextLine();//to stop it skipping lines
                        String newAuthor = input.nextLine();
                        bookList.get(index).setAuthor(newAuthor);
                        break;
                    case 4:
                        System.out.println("please type in the price");
                        double newPrice = input.nextDouble();
                        bookList.get(index).setPrice(newPrice);
                        break;
                    case 5:
                        System.out.println("please type in the genre");
                        input.nextLine();//to stop it skipping lines
                        String newGenre = input.nextLine();
                        bookList.get(index).setGenre(newGenre);
                        break;                       
                        
                }
                
                System.out.println("The book has been succesfully changed to " + bookList.get(index).toString());
            }
            else{
                System.out.println("Cannot find the book");
            }               
        
    }
    
    public static void deleteBook(){
        
            int index = getBookIndex();
            if(index != -1){
                bookList.remove(index);
                System.out.println("Successfully removed");
            }
            else{
                System.out.println("Sorry, i cant find that book");
            }
        
    }
    public static int getBookIndex(){
        if(bookList.isEmpty()){
            System.out.println("No books in the system at the moment");
            return -1;
        }
        else{             
            System.out.println("Please type in the ISBN");
            String isbn = input.next();
            for (int i = 0; i < bookList.size(); i++) {
                if(isbn.equals(bookList.get(i).getISBN())){
                    return i;
                }
            }
        }
        return -1;
    }
    public static void borrowBook(){
        
    }
    
}
    
    
