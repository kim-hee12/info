package Domain;

public class BookDTO {
	private int bookcode;
    private String bookname;
    private String publisher;
    private int isreserve;
    private int CLASSIFICATION_ID;
    private String BOOK_AUTHOR;
    
    public BookDTO() {}

	public BookDTO(int bookcode, int CLASSIFICATION_ID,String BOOK_AUTHOR,String bookname, String publisher, int isreserve 
			) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.publisher = publisher;
		this.isreserve = isreserve;
		this.CLASSIFICATION_ID = CLASSIFICATION_ID;
		this.BOOK_AUTHOR = BOOK_AUTHOR;
	}

	public int getBookcode() {
		return bookcode;
	}

	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getIsreserve() {
		return isreserve;
	}

	public void setIsreserve(int isreserve) {
		this.isreserve = isreserve;
	}

	public int getCLASSIFICATION_ID() {
		return CLASSIFICATION_ID;
	}

	public void setCLASSIFICATION_ID(int CLASSIFICATION_ID) {
		CLASSIFICATION_ID = CLASSIFICATION_ID;
	}

	public String getBOOK_AUTHOR() {
		return BOOK_AUTHOR;
	}

	public void setBOOK_AUTHOR(String BOOK_AUTHOR) {
		BOOK_AUTHOR = BOOK_AUTHOR;
	}

	@Override
	public String toString() {
		return "BookDTO [bookcode=" + bookcode + ", bookname=" + bookname + ", publisher=" + publisher + ", isreserve="
				+ isreserve + ", CLASSIFICATION_ID=" + CLASSIFICATION_ID + ", BOOK_AUTHOR=" + BOOK_AUTHOR + "]";
	}
    
    
    
}	