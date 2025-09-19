import java.util.*;
public class dd008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
		int c = sc.nextInt();
		int b = sc.nextInt();
		int mul = a * c;
		if (mul == b) {
			System.out.print("YES");
		}
		else {
			System.out.print("NO");
		}
	}
}