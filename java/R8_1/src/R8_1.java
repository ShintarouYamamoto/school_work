import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
public class R8_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintStream pr = null;
		String a = "";
		while (true) {
			try {
				pr = new PrintStream(new File("test.txt"));
				System.out.print("文字列を入力してください ");
				String b = sc.nextLine();
				a = a + b;
				System.out.print("continue? ");
				String c = sc.nextLine();
				if (!c.matches("^[yY]")) {
					pr.println(a);
					pr.close();
					break;
					}
				}
			catch (Exception ex){
				sc.nextLine();
				System.out.println("? " + ex.toString());
				}
			}
		sc.close();
		}
	}
