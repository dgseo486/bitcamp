package step11.ex11;

public class C2 extends C {
    // 다음은 C의 메서드를 오버라이딩 한 게 아니다.
    // C의 m1()은 private이기 때문에 오직 C에서만 사용할 수 있다.
    
    @Override
    private void m1() {}
    
    /*@Override
    protected void m2() {}
    @Override
    void m3() {}
    @Override
    public void m4() {}*/
    
    // 오버라이딩 할 때 원본 보다 접근 범위를 확대할 순 있지만 좁힐 수 없다.
    //@Override void m2() {} // 접근 범위를 protected -> (default)로 좁혔기 때문에 컴파일 오류
    
    @Override public void m2() {} // 접근 범위를 protected -> public 으로 확대했기 때문에 OK
    
    // 슈퍼 클래스의 메서드를 자식 클래스가 재정의할 때 접근 범위를 확대할 순 있지만, 좁힐 수 없다.
}
