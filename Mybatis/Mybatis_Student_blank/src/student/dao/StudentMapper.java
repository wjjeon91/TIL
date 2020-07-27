package student.dao;

import java.util.ArrayList;

import student.vo.Student;

/**
 * Mapper XML�� SQL�� ��� �޼��� ����
 */
public interface StudentMapper {
	
	public int insertStudent(Student st);
	public ArrayList<Student> selectStudent();
	public int deleteStudent(int id);
	public int updateStudent(Student st);
	public ArrayList<Student> searchStudentByName(String name);
	
}
