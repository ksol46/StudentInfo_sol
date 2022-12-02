package school.report;

import java.util.ArrayList;

import grade.BasicEvaliation;
import grade.GradeEvaliation;
import grade.MajorEvaliation;
import school.School;
import school.School.*;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GenerateGradeReport {
	//필드
	School school = School.getInstance(); //school 싱글톤 객체 생성 instance가 들어가있음.
	
	public static final String TITLE = "수강생 학점 \t\t\n";
	public static final String HEADER = "이름 | 학번 | 필수과목 | 점수      \n";
	public static final String LINE = "======================================\n";
	private StringBuffer buffer = new StringBuffer();
	
	
	//성적 산출 결과의 헤더, 몸통, 푸터를 만들고 합쳐준다.
	//메소드 생성
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList(); //과목 리스트 불러오기
		for(Subject subject: subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		
		return buffer.toString(); //buffer의 데이터를 String타입으로 바꾼다.
		
}
	
	//헤더를 만들어준다.
	public void makeHeader(Subject subject) {
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);
	}
	
	//바디를 만든다.
	public void makeBody(Subject subject) {
		//해당과목을 수강신청한 학생 리스트를 가져온다.
		ArrayList<Student> studentList = subject.getStudentList();
		for(int i=0; i<studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName()); //학생 이름
			buffer.append(" | ");
			buffer.append(student.getStudentId()); //학번
			buffer.append(" | "); //subject 객체 .(안에) subjectname 메소드를 가져옴.
			buffer.append(student.getMajorSubject().getSubjectName() + "\t"); // 학생 필수과목
			buffer.append(" | ");
			
			//학생별 수강과목의 점수 학점 계산
			getScoreGrade(student, subject.getSubjectId());
			buffer.append("\n");
			buffer.append(LINE);
		}
	}
	
	
	//학생의 수강과목 점수와 학점을 얻는 메소드
		public void getScoreGrade(Student student, int subjectId) {
			
//해당 학생이 수강한 과목의 점수 리스트 (국어,수학)	     //getter setter 만들어놓은곳에서 가져옴
			ArrayList<Score> scoreList = student.getScoreList(); 
		
		//과목코드
		int majorId = student.getMajorSubject().getSubjectId();
		
		GradeEvaliation[] gradeEvaluation = {new BasicEvaliation(), new MajorEvaliation()};
		
		for (int i=0; i<scoreList.size(); i++) {
			Score score = scoreList.get(i); //해당 과목의 점수를 받아온다.
			
			//과목코드가 같은지 확인
			if(score.getSubject().getSubjectId() == subjectId) {
				String grade; //학점
				
				if(score.getSubject().getSubjectId() == majorId)  //필수 과목일 때 학점 선출
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
				 else
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
				
				
				buffer.append(score.getPoint());
				buffer.append(":");
				buffer.append(grade);
				buffer.append(" | ");
				
			}
		}
	}
	
	//푸터를 만들어준다.
	public void makeFooter() {
		buffer.append("\n"); //-> 단순 줄바꿈
		//buffer += "\n" buffer에 \n을 담는다. 추가한다.
	}
	
	
	
	
	
	
}
