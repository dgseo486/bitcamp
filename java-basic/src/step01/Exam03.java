//주석
package step01;

public class Exam03 {
    public static void main(String[] args) {
        System.out.println("src/step01/Exam03");
    }


    /*
        애노테이션(annotation)
        컴파일러나 JVM에게 특별한 명령을 전달할 때 사용한다.
    */
    @Override
    public String toString(){
        return "Exam03";
    }
}

// 한 줄 주석

 /*
  여러 줄 주석
*/

/**
 javadoc 주석; 소스를 추출하여 HTML 문서 작성에 사용
 메서드, 변수에 대한 설명 
 */