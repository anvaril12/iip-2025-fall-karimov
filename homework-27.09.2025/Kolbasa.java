import java.util.*;
public class Kolbasa {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String stroka = sc.nextLine();
		String s = sc.nextLine();
		if (stroka.equals("decode")) {
			System.out.println(decode(s));
		} else if (stroka.equals("encode")) {
			System.out.println(encode(s));
		} else {
			System.out.println("Invalid command");
		}
	}
	public static String encode(String text) {
		String glasnie = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
		String lst = "";
		for (int i=0; i<text.length();i++) {
			if (glasnie.contains(text.charAt(i)+"")) {
				lst = lst + text.charAt(i) + "с" + ((text.charAt(i)+"").toLowerCase());
			} else {
				lst = lst + text.charAt(i);
			}
		}
		return lst;
	}
	public static String decode(String text) {
		String result = "";
        String glas = "аеёиоуыэюя";
        int i = 0;
        while (i < text.length()) {
            char currentChar = text.charAt(i);
            boolean currentglas = (glas.indexOf(currentChar) != -1);
            if (currentglas) {
                result += currentChar;
                if (i + 2 < text.length()) {
                    char nextChar = text.charAt(i + 1);
                    char charAfterNext = text.charAt(i + 2);
                    if (nextChar == 'с' && (charAfterNext+"") == (currentChar+"").toLowerCase()) {
                        i += 3;
                        continue;
                    }
                }
                return "Invalid sausage string";
            } else if (currentChar == 'с') {
                return "Invalid sausage string";
            } else {
                result += currentChar;
                i++;
            }
        }
        return result;
    }
}