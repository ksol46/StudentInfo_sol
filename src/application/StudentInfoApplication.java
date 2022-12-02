package application;

import school.*;
import school.report.GenerateGradeReport;
import utils.Define;

public class StudentInfoApplication {
	School goodSchool = School.getInstance(); //학교 생성
	/*School클래스 안에 getInstance()메소드가 School타입의 goodSchool안에 들어갔다.
	  getInstance() -> School클래스 안에 있는 메소드로, 싱글톤으로 instance 객체를 만들었다.
	  그러므로, goodSchool안에는 instance가 들어있음!
	*/
	Subject korean; //국어 과목 -> Subject 타입의 korea을 사용할 것이다.
	Subject math; //수학 과목 -> Subject 타입의 math를 사용할 것이다.
	
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	/*
	 GenerateGradeReport 의 gradeReport에 새로운 GenerateGradeReport 객체를 생성했다.
	 */
	
	
	//메인 시작
	public static void main(String[] args) {
		
		StudentInfoApplication test = new StudentInfoApplication();
		/*
		 StudentInfoApplication 의 test에 새로운 StudentInfoApplication 객체를 생성했다.
		 객체를 생성해야 써먹을 수 있으니까!!!!
		 */
		test.createSubject();
		/*
		 새롭게 생성한 StudentInfoApplication의 객체인 test안에 createSubject() 메소드를 실행시켜라!
		 그 메소드는 메인 밖에 생성해주었다!
		 */
		test.createStudent();
		/*
		 새롭게 생성한 StudentInfoApplication의 객체인 test안에 createStudent() 메소드를 실행시켜라!
		 그 메소드는 메인 밖에 생성해주었다!
		 */
		String report = test.gradeReport.getReport(); //성적 결과 생성
		System.out.println(report); // 전체 리포트 출력
		
	}
	//메인 끝
		
	//과목 생성
	public void createSubject() {
		korean = new Subject("국어", Define.KOREA);//-> Define클래스 안에 과목코드로 int KOREA = 1001; 이라고 선언해놓음.
		/*String subjectName, int subjectId 라는 매개값을 받는 Subject 생성자의 새로운 Subject객체 안에
		 "국어", Define.KOREA를 입력한다. 이유는 위에 매개값을 String,int값으로 받았기 때문에!!!
		 이것을 저장한것이 korean!!!
		 */
		math = new Subject("수학", Define.MATH );//->//-> Define클래스 안에 과목코드로 int MATH = 1002; 이라고 선언해놓음.
		/*String subjectName, int subjectId 라는 매개값을 받는 Subject 생성자의 새로운 Subject객체 안에
		 "수학", Define.MATH를 입력한다. 이유는 위에 매개값을 저렇게 받았기 때문에!!!
		 이것을 저장한것이 math!!!
		 */
		
		//학교에 과목을 넣어준다.
		goodSchool.addSubject(korean);
		/*"국어", Define.KOREA 라는 값이 들어간 korean을 매개값으로 받아
		 goodSchool의 addSubject를 실행시킨다.
		 addSubject는 School 클래스 안에 addSubject(Subject subject)메소드 이다.
		 */
		goodSchool.addSubject(math);
		/*"수학", Define.MATH 라는 값이 들어간 math를 매개값으로 받음.
		  위와 같다.
		 */
	}
	
	public void createStudent(){
		//학생 생성
		Student student1 = new Student(181213, "박지은", korean);
		Student student2 = new Student(181518, "차슬기", math);
		Student student3 = new Student(171230, "이현욱", korean);
		Student student4 = new Student(171255, "임지연", korean);
		Student student5 = new Student(171590, "김재현", math );
		Student student6 = new Student(171593, "김솔", korean );
		/*
		  Student 타입의 student1는 181213, "박지은", korean 값을 넣은 새로운 Student 객체가 생성된다.
		  새 객체안에 값이 저렇게 들어갈 수 있는 이유는!!
		  Student 클래스 안에 생성자로 아래와 같이 만들어놨기 때문에 타입에 맞춰서 적어줄 수 있다!!!
		  Student(int studentId, String studentName, Subject majorSubject)
		  
		  그렇게 5명을 만들어줬다.
		 */
		
		//학생 등록
		goodSchool.addStudent(student1);
		goodSchool.addStudent(student2);
		goodSchool.addStudent(student3);
		goodSchool.addStudent(student4);
		goodSchool.addStudent(student5);
		goodSchool.addStudent(student6);
		/*
		  싱글톤으로 만든 instance가 들어있는 goodSchool 안에 새로 만든 객체였던 student1을 넣어,
		  addStudent 해준다. 이것은 studentList.add(student); 하는 것.
		 */
		
		//국어 과목 수강 신청
		korean.register(student1);
		korean.register(student2);
		korean.register(student3);
		korean.register(student4);
		korean.register(student5);
		korean.register(student6);
		/*
		국어를 student1을 넣어서
		studentList.add(student); 해준다.
		 */
		
		//수학 과목 수강신청
		math.register(student1);
		math.register(student2);
		math.register(student3);
		math.register(student4);
		math.register(student5);
		math.register(student6);
		/*
		 수학을 student1을 넣어서
		 studentList.add(student); 해준다.
		 */
		
		//학생의 과목별 점수 추가
		addScoreForStudent(student1, korean, 95);
		addScoreForStudent(student1, math, 56);
		
		addScoreForStudent(student2, korean, 95);
		addScoreForStudent(student2, math, 95);
		
		addScoreForStudent(student3, korean, 100);
		addScoreForStudent(student3, math, 88);
		
		addScoreForStudent(student4, korean, 89);
		addScoreForStudent(student4, math, 95);
		
		addScoreForStudent(student5, korean, 85);
		addScoreForStudent(student5, math, 56);
		
		addScoreForStudent(student6, korean, 100);
		addScoreForStudent(student6, math, 100);
		
	}
	
	//학점마다 과목별(수학, 국어)점수 추가
	public void addScoreForStudent(Student student, Subject subject, int point) {
		
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
	}
	
	}

