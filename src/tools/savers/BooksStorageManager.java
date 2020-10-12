package tools.savers;
import entity.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BooksStorageManager {

    public void saveBooksToFile(Book[] books) {
        String fileName = "books";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
    try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет такого файла");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода ввывода");
        }
    }
    public Book[] loadBooksFromFile(){
        Book[] books = null;
        String fileName = "books";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
        fis = new FileInputStream(fileName);
        ois = new ObjectInputStream(fis);
        return (Book[]) ois.readObject();
     } catch (FileNotFoundException ex) {
            System.out.println("Нет такого файла");
     } catch (IOException ex) {
            System.out.println("Ошибка ввода ввывода");
        } catch (ClassNotFoundException ex) {       
           System.out.println("Нет такого класса");
        }
        return books;
    }
    
}

        
