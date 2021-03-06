
package jktvr19library;





import entity.Reader;
import entity.Book;
import entity.History;
import entity.User;
import factory.ConnectSingleton;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import security.SecureManager;
import tools.savers.BaseManager;

import tools.savers.FileManager;

import ui.UserInterface;
import tools.savers.StorageManagerInterface;






public class App {
    public static enum storageFile{BOOKS, READERS, USERS, HISTORIES};
//    private List<Reader> listReaders = new ArrayList<>();
//    private List<Book> listBooks = new ArrayList<>();
//    private List<History> listHistories = new ArrayList<>();
//    private List<User> listUsers = new ArrayList<>();
    
    //private StorageManagerInterface storageManager = new FileManager();
    private StorageManagerInterface storageManager = new BaseManager();
    
    public static User loggedInUser;
    
    public App(String flag) {
        String info = "Сохраняем данные в базу";
        if("base".equals(flag)){
            this.storageManager = new BaseManager();
            info = "Сохраняем данные в базу";
        }else if("file".equals(flag)){
            this.storageManager = new FileManager();
            info = "Сохраняем данные в файл";
        }
//        System.out.println(info);
//        List<Reader> loadedReaders = storageManager.load(App.storageFile.READERS.toString());
//        if(loadedReaders != null){
//            listReaders = loadedReaders;
//        }
//        List<Book> loadedBooks = storageManager.load(App.storageFile.BOOKS.toString());
//        if(loadedBooks != null){
//            listBooks = loadedBooks;
//        }
//        List<History> loaderHistories = storageManager.load(App.storageFile.HISTORIES.toString());
//        if(loaderHistories != null){
//            listHistories = loaderHistories;
//        }
//        List<User> loaderUser = storageManager.load(App.storageFile.USERS.toString());
//        if(loaderUser != null){
//            listUsers = loaderUser;
//        }
    }
    
    public void run() {
      
            System.out.println("--- Библиотека ---");
            SecureManager secureManager = new SecureManager();
            App.loggedInUser = secureManager.checkInLogin();
            UserInterface userInterface = new UserInterface();
            if(App.loggedInUser == null){
                System.out.println("У вас нет прав доступа");
                return;
            }
            if(SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())){
                //публикуем интерфейс менеджера
                userInterface.printManagerUI();
            }else if(SecureManager.role.READER.toString().equals(App.loggedInUser.getRole())){
                //публикуем интерфейс читателя
                userInterface.printReaderUI();
            }
        
    }

}