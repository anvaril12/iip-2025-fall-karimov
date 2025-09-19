import java.util.*;
public class dd021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int anvar = Math.max(a , b);
		int anvar2 = Math.max(anvar, c);
		int anvar3 = Math.min(a , b);
		int anvar4 = Math.min(anvar3, c);
		int anvar5 = anvar2 - anvar4;
			System.out.print(anvar5);
	}
}