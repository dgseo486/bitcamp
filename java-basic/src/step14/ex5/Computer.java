package step14.ex5;

public interface Computer {
    void compute();
    //void touch(); // 컴파일 오류
    default void touch() {}
    
}
