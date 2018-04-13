#자바 입출력  

##파일 입출력  
Streaming API : 데이터의 입출력을 다루는 도구  
###byte stream  


###character stream  
JVM은 기본적으로 OS가 사용하는 문자코드표에 따라서 변환하여 출력한다. ex) windows -> MS949, UNIX -> UTF-8  
JVM은 UTF-16을 사용해서 문자를 처리하고 다른 운영체제에서 읽을 수 있도록 UTF-8로 처리한다.  

>java -Dfile.encoding=UTF-8 -cp bin/main step22.ex2.Exam01_1

이클립스는 실행할 때 -Dfile.encoding=UTF-8 옵션을 기본적으로 사용한다.  
###FileInputStream의 read()와 FileReader의 read()와 차이점  
FileInputStream의 read()는 무조건 1바이트를 읽는다.  
FileReader의 read()는 1 ~ 4 바이트까지 어떤 문자인가에 따라 읽는 바이트 수가 다르다.  
UTF8일 경우 UTF16으로 변환하면서 한글은 3바이트를 읽어 2바이트
binary 파일을 읽고 쓸 경우 : FileInputStream, FileOutputStream(예: pdf, docs, exl)  
txt 파일을 읽고 쓸 경우 : FileReader, FileWriter(예: txt, cvs)  
##serialVersionUID  

##serializable 문법과 transient  
transient 문법을 사용하여 데이터가 일시적으로 존재하도록 하여 데이터 왜곡을 방지한다. 그리고 인스턴스의 값을 사용자가 직접 계산하도록 한다.  
