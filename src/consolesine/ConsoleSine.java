package consolesine;

public class ConsoleSine {

	static double position;

	/**
	 * Prints the sine wave
	 * 
	 * @param width  - The character width of the sine wave
	 * @param height - The character height of the sine wave
	 */
	private static void print(int width, int height) {

		char[][] chars = new char[height][width];

		for (int i = 0; i < width; i++) { //Create Wave
			int pos = (int) (Math.sin(position) * height / 2 + height / 2);
			if (pos == height) {
				pos -= 1;
			}

			chars[pos][i] = '#';
			position += 2 * (Math.PI / width);
		}

		for (int i = 0; i < height; i++) { //Connect Wave
			if (!String.valueOf(chars[i]).contains("#")) {
				int toCheck = -1;
				if (i > 0) {
					toCheck = i - 1;
				} else {
					toCheck = i + 1;
				}
				if (String.valueOf(chars[toCheck]).contains("#")) {
					for (int j = 0; j < chars[toCheck].length; j++) {
						if (chars[toCheck][j] == '#') {
							chars[i][j] = '#';
						}
					}
				}
			}
		}

		StringBuilder toPrint = new StringBuilder();

		for (char[] c : chars) {
			toPrint.append(String.valueOf(c) + "\n");
		}

		System.out.println(toPrint.toString());
	}

	public static void main(String[] args) {

		if (args.length < 2) {
			System.out.println("Insufficient Arguments");
			return;
		}

		try {
			if (args.length >= 3) {
				position = Double.valueOf(args[2]);
			} else {
				position = 0;
			}
			print(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
		} catch (NumberFormatException e) {
			System.out.println("Invalid Argument(s)");
			return;
		}
	}
}
