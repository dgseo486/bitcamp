import java.util.Scanner;

class Solution1952{ //수영장

    static int[] costs=new int[4];
    static int[] plan=new int[13];
    static int min=0;

    public static void dfs(int month, int cost){
        if(month>12){
            if(min>cost){
                min=cost;
                return;
            }
        }
        if(month<=12){
            dfs(month+1, cost+costs[0]*plan[month]);
            dfs(month+1, cost+costs[1]);
            dfs(month+3, cost+costs[2]);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=0; tc<T; tc++){
            for(int i=0; i<4; i++){
                costs[i]=sc.nextInt();
            }
            for(int i=1; i<=12; i++){
                plan[i]=sc.nextInt();
            }
            min=costs[3];
            dfs(1, 0);
            System.out.println("#"+(tc+1)+" "+min);
        }
    }
}