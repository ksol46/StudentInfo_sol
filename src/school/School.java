package school;

import java.util.ArrayList;

public class School {
	//클래스 내부에 school 객체를 생성해 준다.
	private static School instance = new School(); //->초기값이 이미 있기 때문에!!!
									//null; 이어도 상관없음!
	
	private static String SCHOOL_NAME = "Good School"; //학교 이름
	
	//학교에 등록한 학생들이 저장되어 있는 곳.
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	//학교에서 개설한 과목들이 저장되어 있는 곳.
	private ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	
	//싱글톤은 생성자가 private -> 외부에서 여러개의 객체를 생성하면 안됨.
	private School() {
	
	}
	
	//싱글톤 메소드 구현 : school객체를 리턴해준다.
	public static School getInstance() {
		if (instance == null)
			instance = new School();
		return instance;
	}
	/*
	  위 필드에 private static School instance = new School();라고 선언했음,
	  instance가 null일 때 new School(); 새로운 School 객체를 만든다.
	  null이 아닐 때는 생성한 instance를 리턴값으로 받는다.
	*/
		
	
	//학생을 입학 시키는 메소드
	public void addStudent(Student student) {
		studentList.add(student);
	}

	//학생 리스트 출력하는 메소드
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
	
}
