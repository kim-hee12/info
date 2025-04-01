package ch38.Domain.Service;

import ch38.Domain.Dao.BookDaoimpl;
import ch38.Domain.Dto.BookDto;
import ch38.Domain.Dao.BookDao;

public class BookServiceimpl {
	
	//
	private BookDaoimpl bookDao;
	
	// 싱글톤 패턴
	private static BookServiceimpl instance;
	private BookServiceimpl() throws Exception{
		bookDao = BookDaoimpl.getInstance();
	}
	public static BookServiceimpl getInstance() throws Exception{
		if(instance==null)
			instance = new BookServiceimpl();
		return instance;
	}
	
	// TX 처리 + 비즈니스 유효성 검사
	public boolean bookRegistration (BookDto bookDto) throws Exception{
		return bookDao.insert(bookDto)>0;
	}
}
