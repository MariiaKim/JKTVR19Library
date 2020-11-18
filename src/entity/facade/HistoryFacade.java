/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.facade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author pupil
 */
@Entity
public class HistoryFacade implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private BookFacade book;
    @OneToOne
    private ReaderFacade reader;
    @Temporal(TemporalType.TIMESTAMP)
    private Date takeOnDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    public HistoryFacade() {
    }

    public HistoryFacade(BookFacade book, ReaderFacade reader, Date takeOnDate, Date returnDate) {
        this.book = book;
        this.reader = reader;
        this.takeOnDate = takeOnDate;
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public BookFacade getBook() {
        return book;
    }

    public void setBook(BookFacade book) {
        this.book = book;
    }

    public ReaderFacade getReader() {
        return reader;
    }

    public void setReader(ReaderFacade reader) {
        this.reader = reader;
    }

    public Date getTakeOnDate() {
        return takeOnDate;
    }

    public void setTakeOnDate(Date takeOnDate) {
        this.takeOnDate = takeOnDate;
    }

    @Override
    public String toString() {
        return "History{" 
                + "book=" + book.getName()
                + ", reader=" + reader.getFirstname()+" "+reader.getLastname()
                + ", takeOnDate=" + takeOnDate 
                + ", returnDate=" + returnDate 
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.book);
        hash = 37 * hash + Objects.hashCode(this.reader);
        hash = 37 * hash + Objects.hashCode(this.takeOnDate);
        hash = 37 * hash + Objects.hashCode(this.returnDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HistoryFacade other = (HistoryFacade) obj;
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        if (!Objects.equals(this.takeOnDate, other.takeOnDate)) {
            return false;
        }
        if (!Objects.equals(this.returnDate, other.returnDate)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}