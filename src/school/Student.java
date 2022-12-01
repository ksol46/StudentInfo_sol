package school;

import java.util.ArrayList;
//지금 이 프로그램은 상속이 없다. 상속은 a kind of 이기 때문에
//스쿨 안에 있는 것들은 서로 다른것이기 때문에 interface는 쓰지만 상속이나 추상클래스는 없음
//결합도를 적게 하기 위해 private를 쓰고, 필요하면 밑에 메소드를 만들어서 사용한다.
public class Student {

	//필드
	private int studentId; //학번
	private String studentName; //이름
	private Subject majorSubject; //필수과목
	//addSubjectScore() 메소드가 호출되면 이 리스트에 추가가 된다.
	private ArrayList<Score> scoreList = new ArrayList<Score>(); //학생이 수강한 과목의 점수 리스트를 저장하는 곳
	
	//생성자
		public Student(int studentId, String studentName, Subject majorSubject) {
			this.studentId = studentId;
			this.studentName = studentName;
			this.majorSubject = majorSubject;
			
	}
		
	public void addSubjectScore(Score score) {
		scoreList.add(score);
	}
	
	//getter, setter 메소드를 만들어준다.

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Subject getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(Subject majorSubject) {
		this.majorSubject = majorSubject;
	}

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
	
	
		
		
		
		
		
		
		
		
		
}
