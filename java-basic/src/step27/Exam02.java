// 람다 - 람다 표현식 사용
package step27;

public class Exam02 {
    
    static interface Player {
        void play();
    }

    static void testPlayer(Player player) {
        player.play();
    }
    
    public static void main(String[] args) {
        Player player = () -> System.out.println("실행");
        
        testPlayer(player);
    }

}
