package step22.ex9;

public class Member2 implements java.io.Serializable {
    String name;
    int age;
    boolean gender; //true 여자, false 남자
    
    String tel;

    @Override
    public String toString() {
        return "Member2 [name=" + name + ", age=" + age + ", gender=" + gender + ", tel=" + tel + "]";
    }
    
}
