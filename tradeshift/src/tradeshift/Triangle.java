package tradeshift;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

enum Types {
	EQUILATERAL, ISOSCELES, SCALENE;
}

public class Triangle {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Please specify the input file!");
			System.exit(1);
		}

		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(args[0]);
			br = new BufferedReader(fr);

			String line = br.readLine();
			if ((br.lines().count() != 0) || (line == null)) {
				System.out.println("File format is wrong!");
				System.exit(1);
			}

			String[] dimensions = line.split(" ");

			if (dimensions.length != 3) {
				System.out.println("File format is wrong!");
				System.exit(1);
			}

			int a, b, c;
			try {
				a = Integer.parseInt(dimensions[0]);
				b = Integer.parseInt(dimensions[1]);
				c = Integer.parseInt(dimensions[2]);

				if (!(a > 0 && b > 0 && c > 0)) {
					System.out.println("Wrong dimensions!");
					System.exit(1);
				}

				if (!((b + c) > a && (a + c) > b && (a + b) > c)) {
					System.out.println("Wrong dimensions!");
					System.exit(1);
				}

				if (a == b && b == c) {
					System.out.println(Types.EQUILATERAL);
					System.exit(0);
				}

				if (a == b || b == c || a == c) {
					System.out.println(Types.ISOSCELES);
					System.exit(0);
				}

				System.out.println(Types.SCALENE);
			} catch (NumberFormatException e) {
				System.out.println("File format is wrong!");
				System.exit(1);
			}
		} catch (IOException e) {
			System.out.println("Error while reading file!");
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}

				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				System.out.println("Error while reading file!");
				e.printStackTrace();
			}
		}
	}
}