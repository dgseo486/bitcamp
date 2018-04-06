// 메서드 : main() 메서드 - 프로그램 아규먼트
package step06;

class Exam05_2 {
    public static void main(String[] args){
        for(String value : args) {
            System.out.printf("[%s]\n", value);
        }
    }
}