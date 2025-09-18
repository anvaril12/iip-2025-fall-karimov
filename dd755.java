import java.util.*;
public class dd755 {
	public static void main(String[] agrs){
		Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = a + b;
		int w = a + b - c;
		if (d < c) {
			System.out.print("Impossible");
		}
		else {
			System.out.print(w);
		}
	}
}