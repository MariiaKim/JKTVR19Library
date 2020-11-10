/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.savers;

/**
 *
 * @author pupil
 */
import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jktvr19library.App;



public class BaseManager implements StorageManagerInterface{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaProject9PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

    @Override
    public void save(List arrayList, String fileName) {
       
        tx.begin();
          for (int i = 0; i < arrayList.size(); i++) {
            if(Book.class.equals(arrayList.get(i).getClass())){
               List<Book> listBooks = (List<Book>) arrayList;
               if(listBooks.get(i).getId() == null){//создали и добавили именно тот что создали
                   em.persist(listBooks.get(i));
               }
            }
            if(Reader.class.equals(arrayList.get(i).getClass())){
               List<Reader> listReaders = (List<Reader>) arrayList;
               if(listReaders.get(i).getId() == null){//создали и добавили именно тот что создали
                   em.persist(listReaders.get(i));
                }
            }
        
            if(User.class.equals(arrayList.get(i).getClass())){
               List<User> listUsers = (List<User>) arrayList;
               if(listUsers.get(i).getId() == null){//создали и добавили именно тот что создали
                   em.persist(listUsers.get(i));
                }
            }
                if(History.class.equals(arrayList.get(i).getClass())){
               List<History> listHistories = (List<History>) arrayList;
               if(listHistories.get(i).getId() == null){
                   em.persist(listHistories.get(i));
               }else{
                   em.merge(listHistories.get(i));//всегда будет перезаписывать
                }
             }
          }
        tx.commit();
    }
    public void save (List arrayList){
        this.save(arrayList,null);
    }
    @Override
    public List load(String fileName) {
        if(App.storageFile.BOOKS.toString().equals(fileName)){
            List<Book> ListBooks = em.createQuery("SELECT b FROM Book b")
                    .getResultList();
            return ListBooks;
        }
        if(App.storageFile.READERS.toString().equals(fileName)){
            List<Reader> ListReaders = em.createQuery("SELECT r FROM Reader r")
                    .getResultList();
            return ListReaders;
        }
        if(App.storageFile.USERS.toString().equals(fileName)){
            List<User> ListUsers = em.createQuery("SELECT u FROM User u")
                    .getResultList();
            return ListUsers;
        }
        if(App.storageFile.HISTORIES.toString().equals(fileName)){
            List<History> ListHistories = em.createQuery("SELECT h FROM History h")
                    .getResultList();
            return ListHistories;
        }
        return null;
    }
    
}
