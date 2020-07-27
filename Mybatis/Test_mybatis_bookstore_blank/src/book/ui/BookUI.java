package book.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.xs.StringList;

import book.dao.BookDAO;
import book.vo.BookVO;

/**
 * 서점 관리 사용자 인터페이스
 */
public class BookUI {

	// 도서 정보 처리 기능을 담당하는 클래스의 객체
	private BookDAO dao = new BookDAO();

	// 키보드 입력을 위한 객체
	private Scanner sc = new Scanner(System.in);

	// 기본 생성자 - 반복적으로 메뉴를 출력하고 번호를 입력받는다.
	public BookUI() {
		while (true) {
			bookMenuPrint();
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				insertB();
				break;
			case 2:
				showAll();
				break;
			case 3:
				deleteB();
				break;
			case 4:
				updateB();
				break;
			case 5:
				searchB();
				break;
			case 0:
				System.out.println("[알림] 프로그램을 종료합니다.");
				return;

			default:
				System.out.println("[알림] 다시 선택하세요.굈");
				break;
			}
		}
	}
	
	//도서 정보 검색
	private void searchB() {
		System.out.println("[검 색]");
		System.out.print("검색할 제목 : ");
		String title = sc.nextLine();
		ArrayList<BookVO> result = dao.searchBook(title);
		if (result.size() != 0) {
			System.out.println("번호굏제목굏저자굏출판사굏가격굏등록일");
			System.out.println("====================================================");
			for (BookVO b : result) {
				System.out.println(b);
			}
			System.out.println();
		} else
			System.out.println("[알림] 검색 결과가 없습니다.굈");
	}

	//도서 정보 수정
	private void updateB() {
		System.out.println("[도서정보 수정]");
		System.out.print("수정할 도서번호 : ");
		int bnum = sc.nextInt();
		sc.nextLine();

		BookVO book = dao.getBook(bnum);
		if (book != null) {
			System.out.println("* 기존 정보");
			System.out.println("번호 : " + book.getBnum());
			System.out.println("제목 : " + book.getTitle());
			System.out.println("저자 : " + book.getAuthor());
			System.out.println("출판사 : " + book.getPublisher());
			System.out.println("가격 : " + book.getPrice());
			System.out.println("============================");

			System.out.println("* 수정할 정보");
			System.out.print("제목 : ");
			String title = sc.nextLine();
			System.out.print("저자 : ");
			String author = sc.nextLine();
			System.out.print("출판사 : ");
			String publisher = sc.nextLine();
			System.out.print("가격 : ");
			int price = sc.nextInt();
			sc.nextLine();

			BookVO vo = new BookVO(title, author, publisher, price);
			vo.setBnum(bnum);
			
			int result = dao.updateBook(vo);
			if (result == 0)
				System.out.println("[알림] 수정 실패했습니다.굈");
			else
				System.out.println("[알림] 수정되었습니다.굈");
		} else
			System.out.println("[알림] 수정할 데이터가 없습니다.굈");
	}

	//도서 정보 삭제
	private void deleteB() {
		System.out.println("[도서정보 삭제]");

		System.out.print("삭제할 번호 : ");
		int bnum = sc.nextInt();
		sc.nextLine();

		int result = dao.deleteBook(bnum);
		if (result == 0)
			System.out.println("[알림] 삭제할 데이터가 없습니다.굈");
		else
			System.out.println("[알림] 삭제되었습니다.굈");
	}
	
	//전체 목록 출력
	private void showAll() {
		System.out.println("[전체 도서 목록 출력]");
		
		ArrayList<BookVO> result = dao.listAll();
		if (result.size() != 0) {
			System.out.println("번호굏제목굏저자굏출판사굏가격굏등록일");
			System.out.println("====================================================");
			for (BookVO b : result) {
				System.out.println(b);
			}
			System.out.println();
		} else
			System.out.println("[알림] 등록된 데이터가 없습니다.굈");
	}
	
	//도서 정보 등록
	private void insertB() {
		System.out.println("[새 도서정보 등록]");

		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("저자 : ");
		String author = sc.nextLine();
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();

		BookVO vo = new BookVO(title, author, publisher, price);
		
		int result = dao.insertBook(vo);
		if (result == 0)
			System.out.println("[알림] 저장 실패하였습니다.굈");
		else
			System.out.println("[알림] 저장되었습니다.굈");
	}

	private void bookMenuPrint() {
		System.out.println("[서점 관리]");
		System.out.println("1. 도서정보 등록");
		System.out.println("2. 전체목록 출력");
		System.out.println("3. 도서정보 삭제");
		System.out.println("4. 도서정보 수정");
		System.out.println("5. 검색");
		System.out.println("0. 프로그램 종료");

		System.out.print("* 번호선택 : ");
	}
}
