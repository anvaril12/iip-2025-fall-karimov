import java.util.*;
public class dd003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		if (b==5){
			System.out.print(25);
		}
		else{
			System.out.print(((b / 10) * (b / 10 + 1)) + "25");
		}				
	}

}