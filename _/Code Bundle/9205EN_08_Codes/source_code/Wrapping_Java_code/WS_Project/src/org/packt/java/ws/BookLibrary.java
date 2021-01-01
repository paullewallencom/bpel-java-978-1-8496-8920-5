package org.packt.java.ws;

import java.util.Date;
import java.util.Hashtable;

import javax.activation.DataHandler;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlMimeType;

import org.packt.java.ws.exception.BookAlreadyBorrowed;

@WebService
public interface BookLibrary {

    public int addMember(int id, String name, String surname, String address,
                  Date membershipExpiry);
    
    @WebMethod public int addBook(int id, String Author, String Title, int Year);
    
    @WebMethod public void borrowBook(int member_id, int book_id) throws BookAlreadyBorrowed;
    @WebMethod public void giveBackBook(int book_id) throws BookAlreadyBorrowed;
    @WebMethod public void reserveBook(int member_id, int book_id) throws BookAlreadyBorrowed;
    
    public Hashtable listMemberStat();
    public Hashtable listBookStat();
    
    @WebMethod public void uploadBook(String bookName, DataHandler data);
   

}
