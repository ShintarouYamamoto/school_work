
import java.util.Scanner;
public class R12_8 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("アルファベットを入力,終わるには１>>> ");
				String c = sc.nextLine();
				if (c.matches("^[aA]")) {
					System.out.print(". \n");
					System.out.print(" \n");
					System.out.print(" \n");
				}
				if (c.matches("^[bB]")) {
					System.out.print(". \n");
					System.out.print(". \n");
					System.out.print(" \n");
				}
				if (c.matches("^[cC]")) {
					System.out.print(".. \n");
					System.out.print(" \n");
					System.out.print(" \n");
				}
				if (c.matches("^[dD]")) {
					System.out.print(".. \n");
					System.out.print(" .\n");
					System.out.print(" \n");
				}
				if (c.matches("^[eE]")) {
					System.out.print(". \n");
					System.out.print(" .\n");
					System.out.print(" \n");
				}if (c.matches("^[fF]")) {
					System.out.print(".. \n");
					System.out.print(". \n");
					System.out.print(" \n");
				}
				if (c.matches("^[gG]")) {
					System.out.print(".. \n");
					System.out.print(".. \n");
					System.out.print(" \n");
				}if (c.matches("^[hH]")) {
					System.out.print(". \n");
					System.out.print(".. \n");
					System.out.print(" \n");
				}
				if (c.matches("^[iI]")) {
					System.out.print(" .\n");
					System.out.print(". \n");
					System.out.print(" \n");
				}if (c.matches("^[jJ]")) {
					System.out.print(" .\n");
					System.out.print(".. \n");
					System.out.print(" \n");
				}
				if (c.matches("^[kK]")) {
					System.out.print(". \n");
					System.out.print(" \n");
					System.out.print(". \n");
				}if (c.matches("^[lL]")) {
					System.out.print(". \n");
					System.out.print(". \n");
					System.out.print(". \n");
				}
				if (c.matches("^[mM]")) {
					System.out.print(".. \n");
					System.out.print(" \n");
					System.out.print(". \n");
				}if (c.matches("^[nN]")) {
					System.out.print(".. \n");
					System.out.print(" .\n");
					System.out.print(". \n");
				}
				if (c.matches("^[oO]")) {
					System.out.print(". \n");
					System.out.print(" .\n");
					System.out.print(". \n");
				}if (c.matches("^[pP]")) {
					System.out.print(".. \n");
					System.out.print(". \n");
					System.out.print(". \n");
				}
				if (c.matches("^[qQ]")) {
					System.out.print(".. \n");
					System.out.print(".. \n");
					System.out.print(". \n");
				}if (c.matches("^[rR]")) {
					System.out.print(". \n");
					System.out.print(".. \n");
					System.out.print(". \n");
				}
				if (c.matches("^[sS]")) {
					System.out.print(" .\n");
					System.out.print(". \n");
					System.out.print(". \n");
				}if (c.matches("^[tT]")) {
					System.out.print(" .\n");
					System.out.print(".. \n");
					System.out.print(". \n");
				}
				if (c.matches("^[uU]")) {
					System.out.print(". \n");
					System.out.print(" \n");
					System.out.print(".. \n");
				}if (c.matches("^[vV]")) {
					System.out.print(". \n");
					System.out.print(". \n");
					System.out.print(".. \n");
				}
				if (c.matches("^[wW]")) {
					System.out.print(" .\n");
					System.out.print(".. \n");
					System.out.print(" .\n");
				}
				if (c.matches("^[xX]")) {
					System.out.print(".. \n");
					System.out.print(" \n");
					System.out.print(".. \n");
				}
				if (c.matches("^[yY]")) {
					System.out.print(".. \n");
					System.out.print(" .\n");
					System.out.print(".. \n");
				}
				if (c.matches("^[zZ]")) {
					System.out.print(". \n");
					System.out.print(" .\n");
					System.out.print(".. \n");
				}
				if (c.matches("^[1]")) {
					break;
				}

			}catch (Exception ex){
						sc.nextLine();
						System.out.println("? " + ex.toString());
						}
					}
				sc.close();
		}
}
