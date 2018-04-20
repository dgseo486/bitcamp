package step24.ex5;

public class Account {
    String accountId;
    long balance;
    
    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    
    synchronized public long withdraw(long money) {
        long b = this.balance;
        
        for(int i = 0; i < 100; i++) {Math.asin(45.765);}
        
        b = b - money;
        
        for(int i = 0; i < 100; i++) {Math.asin(45.765);}
        
        if(b < 0) {
            return 0;
        }
        
        for(int i = 0; i < 100; i++) {Math.asin(45.765);}
        
        this.balance = b;
        
        for(int i = 0; i < 100; i++) {Math.asin(45.765);}
        
        return money;
    }
    
    
}
