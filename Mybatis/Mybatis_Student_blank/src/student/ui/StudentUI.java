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
				System.out.println("[����]");
				return;
			default:
				System.out.println("[�߸��� �Է�]�n");
				break;
			}
		}
	}

	private void searchStByName() {
		System.out.println("[�˻�]");
		System.out.print("�˻��� �̸� : ");
		String name = sc.nextLine();
		
		System.out.println("�й��t�̸��t����t����t����");
		ArrayList<Student> result = dao.searchStudentByName(name);
		if (result.size() == 0)
			System.out.println("*����� �����Ͱ� �����ϴ�.�n");
		else {
			for (Student st : result) {
				System.out.println(st);
			}
		}
		System.out.println();
	}

	private void updateSt() {
		System.out.println("[����]");
		System.out.print("������ �й� : ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("[���� �Է�]");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("���� ���� : ");
		int kor = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ���� : ");
		int eng = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ���� : ");
		int mat = sc.nextInt();
		sc.nextLine();
		
		Student st = new Student(name, kor, eng, mat);
		st.setId(id);
		int result = dao.updateStudent(st);
		
		if (result == 0) System.out.println("*���� ���Ђn");
		else System.out.println("*���� �Ǿ����ϴ�.�n");
	}

	private void deleteSt() {
		System.out.println("[����]");
		System.out.print("������ �й� : ");
		int id = sc.nextInt();
		sc.nextLine();

		int result = dao.deleteStudent(id);
		if (result != 0)
			System.out.println("*" + result + "���� �����Ǿ����ϴ�.�n");
		else
			System.out.println("�ش�Ǵ� �й��� �����ϴ�.�n");
	}

	private void selectSt() {
		System.out.println("[��ü �л� ����]");
		System.out.println("�й��t�̸��t����t����t����");
		ArrayList<Student> result = dao.selectStudent();
		if (result.size() == 0)
			System.out.println("*����� �����Ͱ� �����ϴ�.�n");
		else {
			for (Student st : result) {
				System.out.println(st);
			}
		}
		System.out.println();
	}

	private void insertSt() {
		System.out.println("[���� �Է�]");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("���� ���� : ");
		int kor = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ���� : ");
		int eng = sc.nextInt();
		sc.nextLine();
		System.out.print("���� ���� : ");
		int mat = sc.nextInt();
		sc.nextLine();

		Student st = new Student(name, kor, eng, mat);
		int result = dao.insertStudent(st);

		if (result == 0)
			System.out.println("*���� ���Ђn");
		else
			System.out.println("*���� �����n");
	}

	private void studentMenu() {
		System.out.println("[�л� ���� ����]");
		System.out.println("1. �Է�");
		System.out.println("2. ��ü ���");
		System.out.println("3. ����");
		System.out.println("4. ����");
		System.out.println("5. �˻�");
		System.out.println("0. ����");
		System.out.print("����-> ");
	}
}
