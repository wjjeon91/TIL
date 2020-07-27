package student.ui;

import java.util.ArrayList;
import java.util.Scanner;

import student.dao.StudentDAO;
import student.vo.Student;

public class StudentUI {
	Scanner sc = new Scanner(System.in);
	StudentDAO dao = new StudentDAO();

	public StudentUI() {

		while (true) {
			studentMenu();
			int choice = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (choice) {
			case 1:
				insertSt();
				break;
			case 2:
				selectSt();
				break;
			case 3:
				deleteSt();
				break;
			case 4:
				updateSt();
				break;
			case 5:
				searchStByName();
				break;
			case 0:
				System.out.println("[종료]");
				return;
			default:
				System.out.println("[잘못된 입력]굈");
				break;
			}
		}
	}

	private void searchStByName() {
		System.out.println("[검색]");
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		
		System.out.println("학번굏이름굏국어굏영어굏수학");
		ArrayList<Student> result = dao.searchStudentByName(name);
		if (result.size() == 0)
			System.out.println("*저장된 데이터가 없습니다.굈");
		else {
			for (Student st : result) {
				System.out.println(st);
			}
		}
		System.out.println();
	}

	private void updateSt() {
		System.out.println("[수정]");
		System.out.print("수정할 학번 : ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("[성적 입력]");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("국어 점수 : ");
		int kor = sc.nextInt();
		sc.nextLine();
		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();
		sc.nextLine();
		System.out.print("수학 점수 : ");
		int mat = sc.nextInt();
		sc.nextLine();
		
		Student st = new Student(name, kor, eng, mat);
		st.setId(id);
		int result = dao.updateStudent(st);
		
		if (result == 0) System.out.println("*수정 실패굈");
		else System.out.println("*수정 되었습니다.굈");
	}

	private void deleteSt() {
		System.out.println("[삭제]");
		System.out.print("삭제할 학번 : ");
		int id = sc.nextInt();
		sc.nextLine();

		int result = dao.deleteStudent(id);
		if (result != 0)
			System.out.println("*" + result + "건이 삭제되었습니다.굈");
		else
			System.out.println("해당되는 학번이 없습니다.굈");
	}

	private void selectSt() {
		System.out.println("[전체 학생 정보]");
		System.out.println("학번굏이름굏국어굏영어굏수학");
		ArrayList<Student> result = dao.selectStudent();
		if (result.size() == 0)
			System.out.println("*저장된 데이터가 없습니다.굈");
		else {
			for (Student st : result) {
				System.out.println(st);
			}
		}
		System.out.println();
	}

	private void insertSt() {
		System.out.println("[성적 입력]");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("국어 점수 : ");
		int kor = sc.nextInt();
		sc.nextLine();
		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();
		sc.nextLine();
		System.out.print("수학 점수 : ");
		int mat = sc.nextInt();
		sc.nextLine();

		Student st = new Student(name, kor, eng, mat);
		int result = dao.insertStudent(st);

		if (result == 0)
			System.out.println("*저장 실패굈");
		else
			System.out.println("*저장 성공굈");
	}

	private void studentMenu() {
		System.out.println("[학생 성적 관리]");
		System.out.println("1. 입력");
		System.out.println("2. 전체 출력");
		System.out.println("3. 삭제");
		System.out.println("4. 수정");
		System.out.println("5. 검색");
		System.out.println("0. 종료");
		System.out.print("선택-> ");
	}
}
