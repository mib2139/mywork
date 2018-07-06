import java.util.Scanner;

public class Student {
	String studentNum;
	String major;
	int english;
	int korea;
	int math;
	int sum;
	float grade;
	
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getKorea() {
		return korea;
	}
	public void setKorea(int korea) {
		this.korea = korea;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum =  english + korea + math;
	}
	
	public float getGrade() {
		return grade = sum/3;
	}
	
	
	
	@Override
	public String toString() {
		return "Student [getStudentNum()=" + getStudentNum() + ", getMajor()=" + getMajor() + ", getEnglish()="
				+ getEnglish() + ", getKorea()=" + getKorea() + ", getMath()=" + getMath() + ", getSum()=" + getSum()
				+ ", getGrade()=" + getGrade() + "]";
	}
	
	public Student(String studentNum, String major, int english, int korea, int math, int sum, float grade) {
		super();
		this.studentNum = studentNum;
		this.major = major;
		this.english = english;
		this.korea = korea;
		this.math = math;
		this.sum = sum;
		this.grade = grade;
	}
	
	public Student() {
	}
	
}
