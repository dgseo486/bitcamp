// 비트 이동 연산자 : 응용2
package step04;

class Exam04_5 {
    public static void main(String[] args){
        // 비트 연산자 사용전
        // 8개의 데이터를 저장하기 위해 32바이트를 사용
        boolean c, cpp, java, js, python, php, html, css;
        c = true;
        cpp = false;
        java = true;
        js = false;
        python = true;
        php = false;
        html = true;
        css = false;

        // 배열을 사용한 경우
        // 8개의 데이터를 저장하기 위해 8바이트를 사용
        boolean[] lang = new boolean[8];
        lang[0] = true;
        lang[1] = false;
        lang[2] = true;
        lang[3] = false;
        lang[4] = true;
        lang[5] = false;
        lang[6] = true;
        lang[7] = false;

        // 비트 연산자 사용 후
        // 4바이트 변수 한 개만 있으면 최대 32개의 데이터를 저장할 수 있다.
        int lang2 = 0;
        lang2 |= 0x80; // c = true
        System.out.println(Integer.toBinaryString(lang2));
        //lang2 |= 0x00; // c++ = false
        lang2 |= 0x20; // java = true
        System.out.println(Integer.toBinaryString(lang2));
        //lang2 |= 0x00; // js = false
        lang2 |= 0x08; // python = true
        System.out.println(Integer.toBinaryString(lang2));
        //lang2 |= 0x00; // php = false
        lang2 |= 0x02; // html = true
        System.out.println(Integer.toBinaryString(lang2));
        //lang2 |= 0x00; // css = false
    }
}
