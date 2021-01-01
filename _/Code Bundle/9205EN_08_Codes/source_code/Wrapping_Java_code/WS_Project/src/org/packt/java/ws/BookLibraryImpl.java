package org.packt.java.ws;


import com.sun.xml.ws.developer.StreamingDataHandler;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.OutputStream;

import java.util.Date;

import java.util.Hashtable;


import javax.activation.DataHandler;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.jws.soap.SOAPBinding;

import javax.xml.bind.annotation.XmlMimeType;

import javax.xml.ws.WebServiceException;

import javax.xml.ws.soap.MTOM;

import org.packt.java.book.BookRecord;
import org.packt.java.book.Member;
import org.packt.java.ws.exception.BookAlreadyBorrowed;



@MTOM
@WebService(name = "BookLibrary", serviceName = "BookLibraryService", portName = "BookLibraryPort")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
//@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.ENCODED)
//@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.ENCODED)
public class BookLibraryImpl implements BookLibrary {
    
    private static Hashtable m_books= new Hashtable();
    private static Hashtable m_members= new Hashtable();
  
  
    public BookLibraryImpl() {
        this.addMember(1, "Jurij", "Laznik", "Podvin pri Polzeli", new Date());
        this.addMember(2, "Ajda", "Laznik", "Podvin pri Polzeli", new Date());
        this.addMember(3, "Urban", "Laznik", "Podvin pri Polzeli", new Date());

        this.addBook(1, "Author 1", "Title 1", 1975);
        this.addBook(2, "Author 2", "Title 2", 2004);
        this.addBook(3, "Author 3", "Title 3", 2009);             
    }


    @WebMethod(exclude = true)
    public int addMember(int id, String name, String surname, String address,
                          Date membershipExpiry) {
        
        Member m= new Member(id, name, surname, address, membershipExpiry);
        m_members.put(id, m);
        
        return id;
    }
    
    public int addBook(int id, String Author, String Title, int Year) {
        
        BookRecord b= new BookRecord(id, Author, Title, Year, null, false);
        m_books.put(id, b);
        
        return id;
    }


    public void giveBackBook( int book_id) throws BookAlreadyBorrowed {
        BookRecord b=  (BookRecord)m_books.get(book_id);
        b.setBorrower(null);
    }

    public Hashtable listBookStat() {
        return m_books;
    }

    @WebMethod(exclude = true)
    public Hashtable listMemberStat() {
        return m_members;
    }

    @Oneway
    @WebMethod
    public void reserveBook(int member_id,
                            int book_id) throws BookAlreadyBorrowed {

        BookRecord b;
        b = (BookRecord)m_books.get(book_id);

        b.setReserved(true);
    }

    public void borrowBook(int member_id,
                           int book_id) throws BookAlreadyBorrowed {
        
        Member m= (Member)m_members.get(member_id);
        BookRecord b=  (BookRecord)m_books.get(book_id);

        if (b.getBorrower() != null) {
            throw new BookAlreadyBorrowed("Book " + b.getTitle() + " was already borrowed.");
        }
        
        b.setBorrower(m);
    }
    
    
    public void uploadBook(String bookName, @XmlMimeType("application/pdf") DataHandler data) {
          try {
            File file = new File("C:\\temp\\books\\" + bookName + ".pdf");
          
            OutputStream output = new BufferedOutputStream(new FileOutputStream(file));
            data.writeTo(output);

            output.close();            
          } catch (Exception e) {
                throw new WebServiceException(e);
          }
    }
    

}
