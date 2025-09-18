import java.util.*;
public class dd754 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int m1 = sc.nextInt();
		int m2 = sc.nextInt();
		int m3 = sc.nextInt();
		int anvar1 = Math.max(m1 , m2);
		int anvar2 = Math.max(anvar1, m3);
		int anvar3 = Math.min(m1, m2);
		int anvar4 = Math.min(anvar3, m3);
		if ((anvar2 > 727) || (anvar4 < 94)) {
			System.out.print("Error");
		}
		else {
			System.out.print(anvar2);
		}
	}
}	