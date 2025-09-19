import java.util.*;
public class dd539 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if ((a % 2 == 1) && (a > 1)) { 
			System.out.print(a);
		}
		else {
			System.out.print(a / 2);
		}
	}
}