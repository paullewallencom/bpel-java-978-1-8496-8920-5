package org.packt.java.book;

public class BookRecord {
    
    private int id=0;
    private String Author= "";
    private String Title= "";
    private int Year= 0;
    private Member borrower= null;
    private boolean reserved= false;


    public BookRecord(int id, String Author, String Title, int Year,
                      Member borrower, boolean reserved) {
        super();
        this.id = id;
        this.Author = Author;
        this.Title = Title;
        this.Year = Year;
        this.borrower = borrower;
        this.reserved = reserved;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getAuthor() {
        return Author;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getTitle() {
        return Title;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getYear() {
        return Year;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean isReserved() {
        return reserved;
    }
}
