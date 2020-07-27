package student.vo;

/**
 * 개인 정보를 저장할 VO 클래스
 */
public class Student {
	private int id;				//학번
	private String name;			//이름
	private int kor;				//국어점수
	private int eng;				//영어점수
	private int mat;				//수학점수
	
	public Student() {}
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	@Override
	public String toString() {
		return id+"굏"+name+"굏"+kor+"굏"+eng+"굏"+mat;
	}
	
}
