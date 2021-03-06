20180330
========
# Ex3
Stack  
LIFO(Last In First Out) 구조  
Stack의 사용 예 : 웹브라우저 히스토리, breadcrumb trail,   

# Ex4
Queue  
FIFO(First In First Out) 구조  
Queue의 사용 예 : 인터넷 예약 처리, single-thread 기반 node 서버의 요청 처리, 이벤트 처리(발생 순서대로 처리)  

# Ex5
HashSet  
1. 값을 중복 저장하지 않는다.  
Set은 집합을 의미한다.  
집합에서는 중복값을 허용하지 않는다.  
값의 중복 여부는 hashCode()의 리턴 값이 같고, equals()의 검사 결과가 true일 때 같은 값으로 취급한다.  
즉 중복된 값을 저장하고 싶지 않을 때 HashSet을 사용한다.  
2. 값을 순서대로 저장하지 않는다.  
값 객체의 hashCode()의 리턴 값으로 저장 위치를 계산하기 때문에 add() 한 순서대로 저장되지 않는다.  

# Ex6
HashMap  
값을 저장할 때 key로 사용할 객체를 지정한다.  
보통 key 객체로 String 객체를 많이 사용한다.  

HashMap에서 값을 찾을 때 key가 같아야 한다.  
key객체가 다르더라도 hashCode()의 리턴 값이 같고,  equals()의 리턴 값이 true이면 두 개의 key는 같다고 간주한다.  
그러나 우리가 사용한 MyKey 클래스는 hashCode()와 equals()를 오버라이딩 하지 않았기 때문에  
결론  
HashMap의 key 객체로 사용할 클래스는 반드시 hashCode()와 equals()를 오버라이딩하여 같은 값을 갖는 경우 같은 해시값을 리턴하도록 한다.  

HashMap의 단점
1. null을 key로 사용할 수 있다.  
2. value가 null이 될 수 있다.  
3. 동기화를 지원하지 않는다. 멀티스레드가 동시에 사용할 때 문제가 발생할 수 있다.  속도가 빠르다.
  
Hashtable  
1. null을 key로 사용할 수 없다.  
2. value가 null이 될 수 없다.


# iterator pattern
컬렉션에서 값을 꺼내는 기능을 객체화시키는 방법. 즉, 별도의 클래스로 정의하여 사용한다.  
이점 : 컬렉션마다 값을 꺼내는 방법이 다르다. ex)ArrayList -> get(), Stack -> pop(),  Queue -> poll()  
       iterator를 사용하면 같은 방법으로 값을 꺼낼 수 있다.  

