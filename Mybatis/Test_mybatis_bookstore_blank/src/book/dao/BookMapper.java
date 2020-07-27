package book.dao;

import java.util.ArrayList;

import book.vo.BookVO;

/**
 * Mapper XML�� ���εǴ� �������̽�
 */
public interface BookMapper {
	
	public int insertBook(BookVO vo);
	public ArrayList<BookVO> listAll();
	public BookVO getBook(int bnum);
	public int deleteBook(int bnum);
	public int updateBook(BookVO vo);
	public ArrayList<BookVO> searchBook(String title);
	
}
