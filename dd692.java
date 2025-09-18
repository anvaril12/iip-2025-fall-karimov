import java.util.*;
public class dd692 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        	int a = sc.nextInt();
	    	if (a==1 || a==2 || a==4 || a==8 || a==16 || a==32 || a==64 || a==128 || a==256 || a==512 || a==1024 || a==2048 || a==4096 || a==8192){
			System.out.print("YES");
		}
		else{
			System.out.print("NO");
		}	
	}
}