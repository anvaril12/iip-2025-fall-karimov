import java.util.*;
public class a5 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0){
            sumTwoNumber(n);
        } else {
            sumThreeNumber(n);
        }
    }
    public static boolean prostoe(int n){
        if (n <= 1){
            return false;
        }
        for (int i = 2; i * i <= n;i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void sumTwoNumber(int n){
        for (int a = 2; a <= n / 2; a++) { 
            if (prostoe(a)){
                int b = n - a;
                if (prostoe(b)) {
                    System.out.println(n + "=" + a + "+" + b);
                    return;
                }
            }
        }
    }
    public static void sumThreeNumber(int n) {
        for (int a = 2; a < n; a++) {
            if (prostoe(a)) {
                int sum = n - a;
                for (int b = a; b <= sum / 2;b++){
                    if (prostoe(b)) {
                        int c = sum - b;
                        if (prostoe(c)) {
                            System.out.println(n + "=" + a + "+" + b + "+" + c);
                            return;
                        }
                    }
                }
            }
        }
    } 
}