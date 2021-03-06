
package tools.creaters;

import entity.Book;
import entity.facade.BookFacade;
import factory.FacadeFactory;
import java.util.List;
import java.util.Scanner;





public class BookManager {
    private BookFacade bookFacade = FacadeFactory.getBookFacade();

    public Book createBook() {
        Book book = new Book();
        System.out.println("--- Добавить книгу ---");
        System.out.println("Введите название:");
        Scanner scanner = new Scanner(System.in);
        book.setName(scanner.nextLine());
        System.out.println("Введите автора:");
        book.setAuthor(scanner.nextLine());
        int numPublishedYear;
        do{
            System.out.println("Введите год издания:");
            String strPublichedYear = scanner.nextLine();
            try {
                numPublishedYear = Integer.parseInt(strPublichedYear);
                break;
            } catch (Exception e) {
                System.out.println("Вводите цифры!");
            }
        }while(true);
        book.setPublishedYear(numPublishedYear);
        bookFacade.create(book);
        return book;
    }
    
    public boolean printListBooks() {
        List<Book> listBooks = bookFacade.findAll();
        if(listBooks == null || listBooks.size() < 1){
            System.out.println("Книг нет!");
            return false;
        }
        for (Book b : listBooks) {
            if(b != null){
                System.out.println(b.getId()+". "+b.toString());
            }
        }
        return true;
    }
    
}
