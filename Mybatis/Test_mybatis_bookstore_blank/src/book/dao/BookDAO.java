package book.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import book.vo.BookVO;

/**
 * DB���� ó�� Ŭ����
 */
public class BookDAO {
	// SqlSession ��ü�� �����ϱ� ���� ��ü
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	/**
	 * �������� ����
	 * @param vo ������ ���� ����
	 * @return ����� ���ڵ� ��
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
	 * ��ü ���� ��� �б�
	 * @return ���� ���
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
	 * ��ȣ�� �������� �б�
	 * @param bnum �˻��� ��ȣ
	 * @return ���� ���� 
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
	 * ��ȣ�� �����ϱ�
	 * @param bnum ������ ��ȣ
	 * @return ������ ���ڵ� ��
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
	 * ��ȣ�� ���� ���� �����ϱ�
	 * @param vo ������ ������ ��� ��ü
	 * @return ������ ���ڵ� ��
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
	 * �˻��ϱ�
	 * @param text �˻���
	 * @return �˻� ���
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
