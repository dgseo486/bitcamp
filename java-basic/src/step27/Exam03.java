// 람다 - 아규먼트로 람다 표현식 바로 사용하기
package step27;

import step27.Exam01.Player;

public class Exam03 {
    
    static interface Player {
        void play();
    }

    static void testPlayer(Player player) {
        player.play();
    }
    
    public static void main(String[] args) {
        
        testPlayer(new Player() {
            @Override
            public void play() {
                System.out.println("실행");
            }
        });
        
        testPlayer(() -> System.out.println("실행"));
    }

}
