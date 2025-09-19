import java.util.*;
public class dd061 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();
		int a4 = sc.nextInt();
		int b1 = sc.nextInt();
		int b2 = sc.nextInt();
		int b3 = sc.nextInt();
		int b4 = sc.nextInt();
		int aa = a1 + a2 + a3 + a4;
		int bb = b1 + b2 + b3 + b4;
		if (aa > bb) {
			System.out.print("1");
		}
		else if (aa < bb) {
			System.out.print("2");
		}
		else {
			System.out.print("DRAW");
		}
	}
}