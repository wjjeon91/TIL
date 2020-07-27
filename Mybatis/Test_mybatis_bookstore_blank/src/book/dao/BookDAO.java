package book.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import book.vo.BookVO;

/**
 * DB관련 처리 클래스
 */
public class BookDAO {
	// SqlSession 객체를 생성하기 위한 객체
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	/**
	 * 도서정보 저장
	 * @param vo 저장할 도서 정보
	 * @return 저장된 레코드 수
	 */
	public int insertBook(BookVO vo) {
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession();
			BookMapper mapper = session.getMapper(BookMapper.class);
			result = mapper.insertBook(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	/**
	 * 전체 도서 목록 읽기
	 * @return 도서 목록
	 */
	public ArrayList<BookVO> listAll() {
		SqlSession session = session = factory.openSession();
		ArrayList<BookVO> result = null;
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			result = mapper.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	/**
	 * 번호로 도서정보 읽기
	 * @param bnum 검색할 번호
	 * @return 도서 정보 
	 */
	public BookVO getBook(int bnum) {
		SqlSession session = session = factory.openSession();
		BookVO result = null;
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			result = mapper.getBook(bnum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	/**
	 * 번호로 삭제하기
	 * @param bnum 삭제할 번호
	 * @return 삭제된 레코드 수
	 */
	public int deleteBook(int bnum) {
		SqlSession session = session = factory.openSession();
		int result = 0;
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			result = mapper.deleteBook(bnum);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
		
	/**
	 * 번호로 도서 정보 수정하기
	 * @param vo 수정할 정보가 담긴 객체
	 * @return 수정된 레코드 수
	 */
	public int updateBook(BookVO vo) {
		SqlSession session = session = factory.openSession();
		int result = 0;
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			result = mapper.updateBook(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	/**
	 * 검색하기
	 * @param text 검색어
	 * @return 검색 결과
	 */
	public ArrayList<BookVO> searchBook(String title) {
		SqlSession session = session = factory.openSession();
		ArrayList<BookVO> result = null;
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			result = mapper.searchBook(title);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}
