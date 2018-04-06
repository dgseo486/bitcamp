#main() 메서드  
JVM이 클래스를 실행할 때 main() 메서드를 호출한다.  
메인 메서드는 반드시 다음과 같은 메서드 시그너쳐(함수 프로토타입)를 가져야 한다.  
public static void main(String[] 변수명)  

#program argument  
JVM을 실핼할 때 프로그래밍에 전달하는 값  
ex) java -cp bin Exam05_2 aaa bbb ccc  
aaa bbb ccc가 program argument 이다.
program argument는 공백을 기준으로 문자열을 잘라서 배열을 만든다.