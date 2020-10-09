/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr19library;




import tools.UserCardManager;
import tools.BooksStorageManager;
import tools.ReadersStorageManager;
import tools.BookManager;
import tools.ReaderManager;
import entity.Reader;
import entity.Book;
import entity.History;
import java.util.Scanner;
import tools.HistoriesStorageManager;


/**
 *
 * @author pupil
 */
public class App {
    private  Scanner scanner = new Scanner(System.in);
    private  Reader[] readers = new Reader[10];
    private  Book[] books = new Book[10];
    private  History[] histories = new History[10];
    

    public App() {
        ReadersStorageManager rsm = new ReadersStorageManager();
        BooksStorageManager bsm = new BooksStorageManager();
        HistoriesStorageManager hsm = new HistoriesStorageManager();
        readers = rsm.loadReadersFromFile();
        books = bsm.loadBooksFromFile();
        histories = hsm.loadHistoriesFromFile();
    }
    
    
    
    
    public void run(){
        System.out.println("---- Библиотека ----");
        boolean repeat = true;
        do{
            
        
        System.out.println("=============================");
        System.out.println("Задачи библиотеки");
        System.out.println("0.выйти из программы");
        System.out.println("1.Добавить книгу");
        System.out.println("2.посмотреть список книг");
        System.out.println("3.Добавить читателей");
        System.out.println("4. список читателей");
        System.out.println("5.выдать книгу");
        System.out.println("6.вернуть книгу");
        System.out.println("7.список читаемых книг:");
        System.out.println("выбирите задачу: ");
        String task = scanner.nextLine();
        System.out.println("=============================");
        switch (task){
            case "0":
                System.out.println("-----конец программы------");
                repeat = false;
                break;
            case "1":
                System.out.println("--Добавить книгу--");
                BookManager bookManager = new BookManager();
                Book book = bookManager.addBook();
                for(int s = 0;s < books.length;s++){
                    if(books[s] == null){
                        books[s]=book;
                        break;
                    }                   
                }  
              BooksStorageManager booksStorageManager = new BooksStorageManager();
              booksStorageManager.saveBooksToFile(books);
                break;
            case "2":
                System.out.println("--посмотреть список книг--");
                int i = 0;
                for(Book b : books){
                    if (b != null){
                        System.out.println(i+1+"."+b.toString());
                        i++;
                    }
                }
                break;
            case "3":
                System.out.println("--Добавить читателей--");
                ReaderManager readerManager = new ReaderManager();
                Reader reader = readerManager.addReader();
                for(int p = 0;p < readers.length;p++){
                    if(readers[p] == null){
                        readers[p]=reader;
                        break;
                    }                   
                }  
                ReadersStorageManager readersStorageManager = new ReadersStorageManager();
                readersStorageManager.saveReadersToFile(readers);
                break;
            case "4":
                System.out.println("--список читателей--");
                int j = 0;
                for(Reader r : readers){
                    if (r != null){
                        System.out.println(j+1+"."+r.toString());
                        j++;
                    }
                }
                
                break;
            case "5":
                System.out.println("--выдать книгу--");
                UserCardManager userCardManager = new UserCardManager();
                History history = userCardManager.giveBook(books,readers);
                
                for(i = 0;i < histories.length;i++){
                    if(histories[i] == null){
                        histories[i]=history;
                        break;
                    }
                }
                break;
            case "6":
                System.out.println("--вернуть книгу--");
                break;
                
                case"7":
                    System.out.println("список читаемых книг:");
                    int n = 0;
                for(History h : histories){
                    if (h != null && h.getReturnDate() == null){
                        System.out.println(n+1+"."+h.toString());
                        n++;
                    }
                }
               HistoriesStorageManager historiesStorageManager = new HistoriesStorageManager();
              historiesStorageManager.saveHistoriesToFile(histories);
                  break;  
         }
        }while(repeat);
    }

    private HistoriesStorageManager newStorageManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
