package ch38.Domain.Dto;

public class BookDto {
	private String bookcode;
	private String bookName;
	private String publisher;
	private String isbn;
	
	public BookDto() {}
	public BookDto(String bookcode, String bookName, String publisher, String isbn) {
		super();
		this.bookcode = bookcode;
		this.bookName = bookName;
		this.publisher = publisher;
		this.isbn = isbn;
	}

	public String getBookcode() {
		return bookcode;
	}

	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "DookDto [bookcode=" + bookcode + ", bookName=" + bookName + ", publisher=" + publisher + ", isbn="
				+ isbn + "]";
	}
	
	
}
