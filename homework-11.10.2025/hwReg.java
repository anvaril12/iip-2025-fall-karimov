import java.util.*;
public class hwReg {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String pattern = "^((\\d{4}-(0[13578]|1[02])-(0[1-9]|[12]\\d|3[01]))|(\\d{4}-(0[469]|11)-(0[1-9]|[12]\\d|30))|(\\d{4}-02-(0[1-9]|1\\d|2[0-8]))|(([0-9]{2}([02468][048]|[13579][26])|([02468][048]|[13579][26])00)-02-29))T([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d\\.\\d{1,9}Z$";
		while (true) {
			String toTest = sc.nextLine();
			boolean matches = toTest.matches(pattern);
			System.out.println(matches ? "Yes" : "No");
		}
	}
}