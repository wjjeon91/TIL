package student.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import student.vo.Student;

/**
 * DB관련 처리 클래스
 */
public class StudentDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public int insertStudent(Student st) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			result = mapper.insertStudent(st);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public ArrayList<Student> selectStudent() {
		SqlSession session = factory.openSession();
		ArrayList<Student> result = null;
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			result = mapper.selectStudent();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	public int deleteStudent(int id) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			result = mapper.deleteStudent(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public int updateStudent(Student st) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			result = mapper.updateStudent(st);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	public ArrayList<Student> searchStudentByName(String name) {
		SqlSession session = factory.openSession();
		ArrayList<Student> result = null;
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			result = mapper.searchStudentByName(name);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
}
