import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
public class R8_3 {
	static ArrayList<String> age = new ArrayList<String>();
	static ArrayList<Integer> amt = new ArrayList<Integer>();
	static ArrayList<String> subject = new ArrayList<String>();
	static ArrayList<String> kind = new ArrayList<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("command> ");
				String[] cmd = sc.nextLine().split("[ \t]+");
				if (cmd.length == 0) {
				} 
				else if (cmd[0].equals("exit")) {
					sc.close();
					System.exit(0);
					}
				else if (cmd[0].equals("read")) {
					if (cmd.length < 2) {
						System.out.println("Usage: read <filename>");
						continue;
						}
					read(cmd[1]);
					}
				else if (cmd[0].equals("print")) {
					PrintStream pr = System.out;
					if (cmd.length > 1) {
						pr = new PrintStream(new File(cmd[1]), "UTF-8");
						print(pr);
						pr.close();
						}
					else print(pr);
					}
				else if (cmd[0].equals("sum")) {
					PrintStream pr = System.out;
					if (cmd.length > 1) {
						pr = new PrintStream(new File(cmd[1]), "UTF-8");
						sum(pr); pr.close();
						}
					else sum(pr);
					}
				else {
					System.out.println("Unknown command: " + cmd[0]);
					}
				}
			catch (Exception ex) {
				System.out.println("? " + ex.toString());
				}
			}
		}
	public class IndexOf{
		
	}
	public static void read(String f)throws Exception {
		Scanner sc = new Scanner(new File(f), "UTF-8");
		int lineno = 0;
		System.out.println(f);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
			++lineno; 
			String[] a = line.split("[ \t]+");
			try {
				String d = a[0], i = a[1], k = a[3];
				int m = Integer.parseInt(a[2]);
				age.add(d);
				amt.add(m);
				if(subject.indexOf(i)!=-1){
					System.out.print("ファイルの要素に被りがあります。 ");
				}
				if(subject.indexOf(i)==-1){
					subject.add(i);
				}
				kind.add(k);
				}
			catch (Exception ex) {
				System.out.printf("line %d: splious line: '%s'\n", lineno, line);
				}
			}
		sc.close();
		}
	public static void print(PrintStream pr)throws Exception {
		for (int i = 0; i < age.size(); ++i) {
			pr.printf("%s %s %s %s\n", age.get(i), subject.get(i), amt.get(i), kind.get(i));
			}
		}
	public static void sum(PrintStream pr)throws Exception {
		TreeMap<String, Integer> tbl = new TreeMap<String, Integer>();
		for (int i = 0; i < subject.size(); ++i) {
			int a = amt.get(i);
			int t = 0;
			if (tbl.containsKey("TOTAL")) {
				t += tbl.get("TOTAL");
				}
			tbl.put("TOTAL", t + a);
			String k = kind.get(i);
			t = 0;
			if (tbl.containsKey(k)) {
				t += tbl.get(k);
				}
			tbl.put(k, t + a);
			}
		for (String k : tbl.keySet()) {
			pr.format("%s = %d\n", k, tbl.get(k));
			}
		}
	}