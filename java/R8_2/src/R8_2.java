import java.io.File;
import java.util.Scanner;
public class R8_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			sc = new Scanner(new File("test.txt"));
			String a = sc.nextLine();
			System.out.print(a);
			sc.close();
			}
		catch (Exception ex) {
			sc.nextLine();
			System.err.println("?" + ex.toString());
			}
		}
	}



