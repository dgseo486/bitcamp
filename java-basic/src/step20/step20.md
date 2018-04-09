#어노테이션(Annotation)  
클래스 파일에 남길 수 있는 주석  
형식을 갖춘 주석을 남길 수 있다.  
용도  
1. 소스코드에서 특정 값을 쉽게 추출할 수 있다. => 소스 코드에서 이 주석을 읽어 다른 소스 파일을 생성할 떄 사용한다.  
2. class 파일에 주석을 남길 수 있다. => 실행 시 추출하여 사용할 수 있다.  

#정의  

ex)String value();  

#Annotation 유지 정책  
1.SOURCE : => @Retention(RetentionPolicy.SOURCE)
2.CLASS : => @Retention(RetentionPolicy.CLASS)
3.RUNTIME : .class 파일에도 남아있고 실행 중에 추출할 수 있다. => @Retention(RetentionPolicy.RUNTIME)

