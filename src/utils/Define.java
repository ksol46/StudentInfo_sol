package utils;

//실무에서 이렇게 상수들을 따로 분리해준다.
//사용, 수정, 관리에 용이하다.
//프로그램에서 전반적으로 사용하는 상수들
//상수 : 바뀌지 않는 값.
public class Define {										//밑에 선언한 값들이 왜 상수이냐!!!!!! final을 붙였기 때문에!!!!!!!
	//과목코드
	public static final int KOREA = 1001; //->국어
	public static final int MATH = 2001; //->수학
	
	//학점 산출 방식 : 타입으로 정할 것이고, 상수는 뭐라고 쓰던 상관없지만 각각 달라야 한다.
	public static final int AB_TYPE = 0; //A,B .. 일반과목 산출 방식
	public static final int SAB_TYPE = 1; //S,A,B .. 필수과목 산출 방식
	
	
	
	
	
}
