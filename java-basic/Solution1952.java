import java.util.Scanner;

class Solution1952{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        System.out.println(T);
        for(int tc=0; tc<T; tc++){
            int[] costs=new int[4];
            for(int i=0; i<4; i++){
                costs[i]=sc.nextInt();
            }
            int[] plan=new int[12];
            for(int i=0; i<12; i++){
                plan[i]=sc.nextInt();
            }

            int min=0;
            
            //1 day
            for(int i=0; i<12; i++){
                int sum=sum+plan[i];
                int result=sum*costs[0];
                temp.add(result);
            }

            //annual use count
            int count=0;
            for(int i=0; i<12; i++){
                if(plan[i]>0){
                    count++;
                }
            }

            //1 month
            int result=costs[1]*count;

            //3 month
            int a=count/3;
            int b=count%3;
            
            
        }
    }
}