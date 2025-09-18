import java.util.*;
public class dd106 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        	int k = sc.nextInt();
		int o = 0;
		int r =0;
		for (int i = 0; i < k; i++){
			int m  = sc.nextInt();
			if (m == 1){
				r++;
			}
			else{
				o++;
			}
		}
		System.out.print(Math.min(r, o));				
	}
}