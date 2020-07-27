package book.vo;

import com.sun.org.apache.xerces.internal.xs.StringList;

/**
 * ���� ������ �����ϴ� VO Ŭ����
 */
public class BookVO {
	private int bnum;				//��ǰ ��ȣ
	private String title;			//����
	private String author;			//����
	private String publisher;		//���ǻ�
	private int price;				//����
	private String inputdate;		//���� �����
	
	
	public BookVO() {}
	public BookVO(String title, String author, String publisher, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate.substring(2, 4)+"/"+inputdate.substring(5, 7)+"/"+inputdate.substring(8, 10);
	}
	
	@Override
	public String toString() {
		return bnum+"�t"+title+"�t"+author+"�t"+publisher+"�t"+price+"�t"+inputdate;
	}
	
}
