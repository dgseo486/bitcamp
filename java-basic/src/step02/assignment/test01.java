package step02.assignment;

class test01 {
    public static void main(String[] args){
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);
        
        System.out.print("이름? ");
        String name=keyScan.nextLine();
        System.out.print("국어? ");
        int kor=keyScan.nextInt();
        System.out.print("영어? ");
        int eng=keyScan.nextInt();
        System.out.print("수학? ");
        int math=keyScan.nextInt();
        System.out.println("-----------------");
        int tot=kor+eng+math;
        double avg=(kor+eng+math)/3;
        System.out.println(name+" "+kor+" "+eng+" "+math+" "+tot+" "+avg);
    }
}