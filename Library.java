import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Library {
    
    private ArrayList<Book> books;
    
    public Library(){
        
        importLibrary();
        
    }
    
    public void add(String s){
        books.add(new Book(s));
    }
    public void remove(String s){
        Book deletedBook = null;
        for(Book b : books){
            if(b.getTitle().equals(s))
                deletedBook = b;
        }
        books.remove(deletedBook);
        
    }
    
    private void saveToFile(){
         try {
            BufferedWriter out = new BufferedWriter(new FileWriter("db.txt"));
            for(Book b : books)
                out.write(b.toString());
            out.close();
        }
        catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    
    private void importLibrary(){
        books = new ArrayList<Book>();
        try{ 
            Scanner reader = new Scanner(new File("db.txt"));
            reader.useDelimiter(", ");
        
             while(reader.hasNext())
                books.add(new Book(reader.nextLine()));  
        }
        catch(IOException e){
            System.out.println("Unable to read file. " + e.getMessage());
        }
    
    }
    public String toString(){
        String str = "";
        for(Book b : books)
            str += (b + " ");
        return str;
    }
}