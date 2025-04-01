package ch38.Controller;

import java.util.HashMap;
import java.util.Map;

import ch38.Domain.Dto.BookDto;
import ch38.Domain.Service.BookServiceimpl;

public class BookController implements SubController {

	private BookServiceimpl bookService;

	public BookController() {
		try {
			bookService = BookServiceimpl.getInstance();
		}catch(Exception e) {
			exceptionHandler(e);
		}
	}

	Map<String, Object> response;

	// C(1)R(2)U(3)D(4)
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		System.out.println("[SC] BookController execute invoke..!");

		// 00
		response = new HashMap();

		Integer serviceNo = (Integer) params.get("serviceNo");
		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 요청입니다.");
			return response;
		}
		switch (serviceNo) {
		case 1: // C - 도서 등록
			System.out.println("[SC] 도서등록 요청 확인");

			// 01 파라미터 받기
			String bookcode = (params.get("bookcode") != null) ? (String) params.get("bookcode") : null;
			String bookName = (params.get("bookName") != null) ? (String) params.get("bookName") : null;
			String publisher = (params.get("publisher") != null) ? (String) params.get("publisher") : null;
			;
			String isbn = (params.get("isbn") != null) ? (String) params.get("isbn") : null;

			BookDto bookDto = new BookDto(bookcode, bookName, publisher, isbn);
			if (isValid(bookDto)) {
				response.put("status", false);
//				response.put("message","유효성 체크 오류발생!");	
				return response;
			}
			// 02 유효성 검증(Data Validation)
			// 03 관련 서비스 실행
			// 04 뷰로 이동(or 내용전달)
			break;
		case 2: // R - 도서 조회
			System.out.println("[SC] 도서조회 요청 확인");
			// 01 파라미터 받기
			// 02 유효성 검증(Data Validation)
			// 03 관련 서비스 실행
			// 04 뷰로 이동(or 내용전달)
			break;
		case 3: // U - 도서 수정
			System.out.println("[SC] 도서수정 요청 확인");
			// 01 파라미터 받기
			// 02 유효성 검증(Data Validation)
			// 03 관련 서비스 실행
			// 04 뷰로 이동(or 내용전달)
			break;
		case 4: // D - 도서삭제
			System.out.println("[SC] 도서삭제 요청 확인");
			// 01 파라미터 받기
			// 02 유효성 검증(Data Validation)
			// 03 관련 서비스 실행
			// 04 뷰로 이동(or 내용전달)
			break;
		default:
			System.out.println("[SC] 잘못된 서비스번호 요청 확인");
			response.put("status", false);
			response.put("message", "잘못된 서비스번호 요청입니다.");
		}

		return response;
	}

	private boolean isValid(BookDto bookDto) {

		if (bookDto.getBookcode() == null || bookDto.getBookcode().length() != 8) {
			response.put("error", "bookcode는 기본 8글자만 허용합니다.");
			System.out.println("[INVALID] bookcode는 기본 8글자만 허용합니다.");
			return false;
		}
		if (bookDto.getBookName() == null || bookDto.getBookName().length() >= 256) {
			response.put("error", "bookname은 255자가 최대입니다..");
			System.out.println("[INVALID] bookname은 255자가 최대입니다.");
			return false;
		}
		return true;
	}

	// 예외처리 함수
	public Map<String, Object> exceptionHandler(Exception e) {

		if (response == null)
			response = new HashMap();

		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("exception", e);
		return response;
	}
}
