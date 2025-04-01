package Service;

import Domain.BookDAO;
import Domain.BookDTO;

public class BookService {
	private BookDAO bookDao;
	
	private static BookService instance;
	
	private BookService() throws Exception{
		bookDao = BookDAO.getInstance();
	}
	public static BookService getInstance() throws Exception{
		if(instance==null)
			instance = new BookService();
		return instance;
	}
	
	public boolean bookRegistration(BookDTO bookDto) throws Exception{
		return bookDao.insert(bookDto)>0;
	}
}
