/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.controllers;

import entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;




public class BookController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
   
    public void create(Book book){
        tx.begin();
        em.persist(book);
        tx.commit();
    }

    public List<Book> findAll() {
        try {
            return em.createQuery("SELECT b FROM Book b")
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Book find(Long bookId) {
        try {
            return (Book) em.createQuery("SELECT b FROM Book b WHERE b.id = :id")
                    .setParameter("id", bookId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}