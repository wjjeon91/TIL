package book.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.xs.StringList;

import book.dao.BookDAO;
import book.vo.BookVO;

/**
 * ���� ���� ����� �������̽�
 */
public class BookUI {

	// ���� ���� ó�� ����� ����ϴ� Ŭ������ ��ü
	private BookDAO dao = new BookDAO();

	// Ű���� �Է��� ���� ��ü
	private Scanner sc = new Scanner(System.in);

	// �⺻ ������ - �ݺ������� �޴��� ����ϰ� ��ȣ�� �Է¹޴´�.
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
				System.out.println("[�˸�] ���α׷��� �����մϴ�.");
				return;

			default:
				System.out.println("[�˸�] �ٽ� �����ϼ���.�n");
				break;
			}
		}
	}
	
	//���� ���� �˻�
	private void searchB() {
		System.out.println("[�� ��]");
		System.out.print("�˻��� ���� : ");
		String title = sc.nextLine();
		ArrayList<BookVO> result = dao.searchBook(title);
		if (result.size() != 0) {
			System.out.println("��ȣ�t����t���ڂt���ǻ�t���݂t�����");
			System.out.println("====================================================");
			for (BookVO b : result) {
				System.out.println(b);
			}
			System.out.println();
		} else
			System.out.println("[�˸�] �˻� ����� �����ϴ�.�n");
	}

	//���� ���� ����
	private void updateB() {
		System.out.println("[�������� ����]");
		System.out.print("������ ������ȣ : ");
		int bnum = sc.nextInt();
		sc.nextLine();

		BookVO book = dao.getBook(bnum);
		if (book != null) {
			System.out.println("* ���� ����");
			System.out.println("��ȣ : " + book.getBnum());
			System.out.println("���� : " + book.getTitle());
			System.out.println("���� : " + book.getAuthor());
			System.out.println("���ǻ� : " + book.getPublisher());
			System.out.println("���� : " + book.getPrice());
			System.out.println("============================");

			System.out.println("* ������ ����");
			System.out.print("���� : ");
			String title = sc.nextLine();
			System.out.print("���� : ");
			String author = sc.nextLine();
			System.out.print("���ǻ� : ");
			String publisher = sc.nextLine();
			System.out.print("���� : ");
			int price = sc.nextInt();
			sc.nextLine();

			BookVO vo = new BookVO(title, author, publisher, price);
			vo.setBnum(bnum);
			
			int result = dao.updateBook(vo);
			if (result == 0)
				System.out.println("[�˸�] ���� �����߽��ϴ�.�n");
			else
				System.out.println("[�˸�] �����Ǿ����ϴ�.�n");
		} else
			System.out.println("[�˸�] ������ �����Ͱ� �����ϴ�.�n");
	}

	//���� ���� ����
	private void deleteB() {
		System.out.println("[�������� ����]");

		System.out.print("������ ��ȣ : ");
		int bnum = sc.nextInt();
		sc.nextLine();

		int result = dao.deleteBook(bnum);
		if (result == 0)
			System.out.println("[�˸�] ������ �����Ͱ� �����ϴ�.�n");
		else
			System.out.println("[�˸�] �����Ǿ����ϴ�.�n");
	}
	
	//��ü ��� ���
	private void showAll() {
		System.out.println("[��ü ���� ��� ���]");
		
		ArrayList<BookVO> result = dao.listAll();
		if (result.size() != 0) {
			System.out.println("��ȣ�t����t���ڂt���ǻ�t���݂t�����");
			System.out.println("====================================================");
			for (BookVO b : result) {
				System.out.println(b);
			}
			System.out.println();
		} else
			System.out.println("[�˸�] ��ϵ� �����Ͱ� �����ϴ�.�n");
	}
	
	//���� ���� ���
	private void insertB() {
		System.out.println("[�� �������� ���]");

		System.out.print("���� : ");
		String title = sc.nextLine();
		System.out.print("���� : ");
		String author = sc.nextLine();
		System.out.print("���ǻ� : ");
		String publisher = sc.nextLine();
		System.out.print("���� : ");
		int price = sc.nextInt();
		sc.nextLine();

		BookVO vo = new BookVO(title, author, publisher, price);
		
		int result = dao.insertBook(vo);
		if (result == 0)
			System.out.println("[�˸�] ���� �����Ͽ����ϴ�.�n");
		else
			System.out.println("[�˸�] ����Ǿ����ϴ�.�n");
	}

	private void bookMenuPrint() {
		System.out.println("[���� ����]");
		System.out.println("1. �������� ���");
		System.out.println("2. ��ü��� ���");
		System.out.println("3. �������� ����");
		System.out.println("4. �������� ����");
		System.out.println("5. �˻�");
		System.out.println("0. ���α׷� ����");

		System.out.print("* ��ȣ���� : ");
	}
}
