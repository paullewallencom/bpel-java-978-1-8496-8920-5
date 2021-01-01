package org.packt.java.ws;

import java.util.Collection;
import java.util.Date;

import java.util.Hashtable;

import java.util.Iterator;

/*import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
*/
import org.packt.java.book.BookRecord;
import org.packt.java.book.Member;
import org.packt.java.ws.exception.BookAlreadyBorrowed;

public class BookLibraryImplTest {
    
    private BookLibrary m_library;
    
    public BookLibraryImplTest() {
    }

    public static void main(String[] args) {
        String[] args2 = { BookLibraryImplTest.class.getName() };
        
        BookLibraryImplTest tst= new BookLibraryImplTest();
        try {
            tst.setUp();
            tst.testLibrary();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
//        org.junit.runner.JUnitCore.main(args2);
    }

//    @Before
    public void setUp() throws Exception {
        m_library= new BookLibraryImpl();
        
        m_library.addMember(1, "Jurij", "Laznik", "Podvin pri Polzeli", new Date());
        m_library.addMember(2, "Ajda", "Laznik", "Podvin pri Polzeli", new Date());
        m_library.addMember(3, "Urban", "Laznik", "Podvin pri Polzeli", new Date());

        m_library.addBook(1, "Author 1", "Title 1", 1975);
        m_library.addBook(2, "Author 2", "Title 2", 2004);
        m_library.addBook(3, "Author 3", "Title 3", 2009);     
    }

//    @After
    public void tearDown() throws Exception {
    }

 //   @Test
    public void testLibrary() throws BookAlreadyBorrowed {
        
        outputContent(m_library.listMemberStat());
        outputContent(m_library.listBookStat());
        m_library.reserveBook(1, 1);
        m_library.borrowBook(1, 2);
        m_library.borrowBook(1, 3);
        outputContent(m_library.listBookStat());
        
        try
        {
        m_library.borrowBook(2, 3);
        } catch (BookAlreadyBorrowed e) {
            System.out.println("Cannot borrow.");
        }
        
        m_library.giveBackBook(3);
        outputContent(m_library.listBookStat());
        
        m_library.borrowBook(2, 3);
        outputContent(m_library.listBookStat());
        
        
        
    }
    
    public void outputContent(Hashtable hash) {
        Collection c = hash.values();
        System.out.println("----------------------START---------------------");   
        Iterator it = c.iterator();
        while(it.hasNext()) {
          Object o= it.next();
            if (o instanceof BookRecord) {
                BookRecord br= (BookRecord)o;      
                System.out.println("Id .........: " + br.getId());
                System.out.println("Author .....: " + br.getAuthor());
                System.out.println("Title ......: " + br.getTitle());
                System.out.println("Year .......: " + br.getYear());
                System.out.println("Reserved ...: " + br.isReserved());
                if (br.getBorrower() != null)
                    System.out.println("Borrower ...: " + br.getBorrower().getId() + "  " + br.getBorrower().getName());
                else
                    System.out.println("Borrower ...: FREE");
            } else {
                Member m= (Member)o;      
                System.out.println("Id .........: " + m.getId());
                System.out.println("Name .......: " + m.getName());
                System.out.println("Surname.....: " + m.getSurname());
                System.out.println("Address.....: " + m.getAddress());
                System.out.println("Expiry .....: " + m.getMembershipExpiry());                
            }
        }
        System.out.println("-------------------END---------------------------");   

        
    }
    
    
}
