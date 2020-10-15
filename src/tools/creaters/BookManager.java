
package tools.creaters;

import entity.Book;
import java.util.Scanner;


public class BookManager {

    //форма заполнения 




    public Book addBook() {
        Book book = new Book();
        System.out.println("--- Добавить книгу ---");
        System.out.println("Введите название:");
        Scanner scanner = new Scanner(System.in);
        book.setName(scanner.nextLine());
        System.out.println("Введите автора:");
        book.setAuthor(scanner.nextLine());
        System.out.println("Введите год издания:");
        book.setPublishedYear(scanner.nextInt());
        return book;
    }
    


    public void addBookToArray(Book book, Book[] books) {
           for (int i = 0; i < books.length; i++) {
                        if(books[i] == null){
                            books[i] = book;
                            break;
                        }
                    }
    }

    public void printListBooks(Book[] books) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
