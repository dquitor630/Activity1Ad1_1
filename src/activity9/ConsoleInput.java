package activity9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {
	private final Scanner keyboard;

	public ConsoleInput(Scanner keyboard) {
		this.keyboard = keyboard;
	}

	private void cleanInput() {
		keyboard.nextLine();
	}

	public byte readByte() {
		boolean exit = false;
		byte by = 0;
		do {
			try {
				by = keyboard.nextByte();

				exit = true;
			} catch (InputMismatchException e) {
				cleanInput();
				System.out.println("has introducido el valor mal, vuelve a introducirlo");
				exit = false;
			}
		} while (!exit);
		return by;
	}

	public byte readByteLessThan(byte upperBound) {
		byte by = 0;
		boolean exit = false;
		boolean exitTry = false;
		do {
			by = readByte();
			if (by < upperBound) {
				exit = true;
			} else {
				System.out.println("el valor es mayor");
				exit = false;

			}
		} while (!exit);
		return by;

	}

	public byte readByteLessorEqualThan(byte upperBound) {
		byte by = 0;
		boolean exit = false;
		do {
			by = readByte();
			if (by <= upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor, es mas alto que el requerido");
				exit = false;
			}
		} while (!exit);
		return by;

	}

	public byte readByteGreaterThan(byte lowerBound) {
		byte by = 0;
		boolean exit = false;
		do {
			by = readByte();
			if (by > lowerBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor, es menor al requerido");
				exit = false;
			}
		} while (!exit);
		return by;

	}

	public byte readByteGreaterOrEqualThan(byte lowerBound) {
		byte by = 0;
		boolean exit = false;
		do {
			by = readByte();
			if (by >= lowerBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return by;
	}

	public byte readByteInRange(byte lowerBound, byte upperBound) {
		byte by = 0;
		boolean exit = false;
		do {
			by = readByte();
			if (by >= lowerBound && by <= upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return by;

	}

	public long readLong() {
		long lon = 0;
		boolean exitTry = false;
		do {
			try {
				lon = keyboard.nextLong();
				exitTry = true;
			} catch (InputMismatchException e) {
				cleanInput();
				System.out.println("has introducido el valor mal, vuelve a introducirlo");
				exitTry = false;
			}
		} while (!exitTry);
		return lon;
	}

	public long readLongLessThan(long upperBound) {
		long lon = 0;
		boolean exit = false;
		do {
			lon = readLong();
			if (lon < upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return lon;

	}

	public long readLongLessorEqualThan(long upperBound) {
		long lon = 0;
		boolean exit = false;
		do {
			lon = readLong();
			if (lon <= upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return lon;

	}

	public long readLongGreaterThan(long lowerBound) {
		long lon = 0;
		boolean exit = false;
		do {
			lon = readLong();
			if (lon > lowerBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return lon;

	}

	public long readLongGreaterOrEqualThan(long lowerBound) {
		long lon = 0;
		boolean exit = false;
		do {
			lon = readLong();
			if (lon >= lowerBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return lon;
	}

	public long readLongInRange(long lowerBound, long upperBound) {
		long lon = 0;
		boolean exit = false;
		do {
			lon = readLong();
			if (lon >= lowerBound && lon <= upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return lon;

	}

	public int readInt() {
		int in = 0;
		boolean exitTry = false;
		do {
			try {
				in = keyboard.nextInt();

				exitTry = true;
			} catch (InputMismatchException e) {
				cleanInput();
				System.out.println("has introducido el valor mal, vuelve a introducirlo");
				exitTry = false;
			}
		} while (!exitTry);
		return in;
	}

	public int readIntLessThan(int upperBound) {
		int in = 0;
		boolean exit = false;
		do {
			in = readInt();
			if (in < upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return in;

	}

	public int readIntLessorEqualThan(int upperBound) {
		int in = 0;
		boolean exit = false;
		do {
			in = readInt();
			if (in <= upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return in;

	}

	public int readIntGreaterThan(int lowerBound) {
		int in = 0;
		boolean exit = false;
		do {
			in = readInt();
			if (in > lowerBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return in;

	}

	public int readIntGreaterOrEqualThan(int lowerBound) {
		int in = 0;
		boolean exit = false;
		do {
			in = readInt();
			if (in >= lowerBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return in;
	}

	public int readIntInRange(int lowerBound, int upperBound) {
		int in = 0;
		boolean exit = false;
		do {
			in = readInt();
			if (in >= lowerBound && in <= upperBound) {
				cleanInput();
				exit = true;
			} else {
				cleanInput();
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return in;

	}

	public short readShort() {
		short sho = 0;
		boolean exitTry = false;
		do {
			try {
				sho = keyboard.nextShort();
				exitTry = true;
			} catch (InputMismatchException e) {
				cleanInput();
				System.out.println("has introducido el valor mal, vuelve a introducirlo");
				exitTry = false;
			}
		} while (!exitTry);
		return sho;
	}

	public short readShortLessThan(short upperBound) {
		short sho = 0;
		boolean exit = false;
		do {
			sho = readShort();
			if (sho < upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return sho;

	}

	public short readShortLessorEqualThan(short upperBound) {
		short sho = 0;
		boolean exit = false;
		do {
			sho = readShort();
			if (sho <= upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return sho;

	}

	public short readShortGreaterThan(short lowerBound) {
		short sho = 0;
		boolean exit = false;
		do {
			sho = readShort();
			if (sho > lowerBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return sho;

	}

	public short readShortGreaterOrEqualThan(short lowerBound) {
		short sho = 0;
		boolean exit = false;
		do {
			sho = readShort();
			if (sho >= lowerBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return sho;
	}

	public short readShortInRange(short lowerBound, short upperBound) {
		short sho = 0;
		boolean exit = false;
		do {
			sho = readShort();
			if (sho >= lowerBound && sho <= upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return sho;

	}

	public float readFloat() {
		float flo = 0.0f;
		boolean exitTry = false;
		do {
			try {
				flo = keyboard.nextFloat();
				exitTry = true;
			} catch (InputMismatchException e) {
				cleanInput();
				System.out.println("has introducido el valor mal, vuelve a introducirlo");
				exitTry = false;
			}
		} while (!exitTry);
		return flo;
	}
	public double readDouble() {
		double dob = 0.0;
		boolean exitTry = false;
		do {
			try {
				dob = keyboard.nextDouble();
				exitTry = true;
			} catch (InputMismatchException e) {
				cleanInput();
				System.out.println("has introducido el valor mal, vuelve a introducirlo");
				exitTry = false;
			}
		} while (!exitTry);
		return dob;
	}
	public float readFloatLessThan(float upperBound) {
		float flo = 0.0f;
		boolean exit = false;
		do {
			flo = readFloat();
			if (flo < upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return flo;

	}

	public float readFloatLessorEqualThan(float upperBound) {
		float flo = 0.0f;
		boolean exit = false;
		do {
			flo = readFloat();
			if (flo <= upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return flo;

	}

	public float readFloatGreaterThan(float lowerBound) {
		float flo = 0.0f;
		boolean exit = false;
		do {
			flo = readFloat();
			if (flo > lowerBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return flo;

	}

	public float readFloatGreaterOrEqualThan(float lowerBound) {
		float flo = 0.0f;
		boolean exit = false;
		do {
			flo = readFloat();
			if (flo >= lowerBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return flo;
	}

	public float readFloatInRange(float lowerBound, float upperBound) {
		float flo = 0.0f;
		boolean exit = false;
		do {
			flo = readFloat();
			if (flo >= lowerBound && flo <= upperBound) {
				exit = true;
			} else {
				System.out.println("vuelve a introducir el valor");
				exit = false;
			}
		} while (!exit);
		return flo;

	}

	public char readChar() {
		String str;
		char ch = ' ';
		boolean exit = false;
		do {
			str = keyboard.next();
			cleanInput();
			if (str.length() > 1 || str.length() < 1) {
				System.out.println("el valor es mas largo que un caracter, vuelve a introducir el valor");

			} else {
				ch = str.charAt(0);
				exit = true;
			}
		} while (!exit);
		return ch;
	}

	public char readChar(String validCharacters) {
		String str;
		char ch = ' ';
		boolean exit = false;
		int lenghtOfValid = validCharacters.length();
		int i;
		do {
			str = keyboard.next();
			cleanInput();

			if (str.length() > 1 || str.length() < 1) {
				System.out.println("el valor es mas largo que un caracter, vuelve a introducir el valor");

			} else {
				ch = str.charAt(0);
				for (i = 0; i <= lenghtOfValid - 1; i++) {
					if (ch == validCharacters.charAt(i)) {
						exit = true;
					}
				}
				if (!exit) {
					System.out.println("el valor no coincide con el necesario, vuelve a introducir el valor");
				}
			}
		} while (!exit);
		return ch;
	}

	public char readVowel() {
		String str;
		char ch = ' ';
		boolean exit = false;
		do {
			str = keyboard.next();
			cleanInput();
			if (str.length() > 1 || str.length() < 1 || str.matches("[^aeiouAEIOU]")) {
				System.out.println(
						"el valor es mas largo que un caracter o no es una vocal, vuelve a introducir el valor");

			} else {
				exit = true;
				ch = str.charAt(0);
			}
		} while (!exit);
		return ch;
	}

	public char readDigit() {
		String str;
		char ch = ' ';
		boolean exit = false;
		do {
			str = keyboard.next();
			cleanInput();
			if (str.length() > 1 || str.length() < 1 || str.matches("\\D")) {
				System.out.println(
						"el valor es mas largo que un caracter o no es una vocal, vuelve a introducir el valor");

			} else {
				exit = true;
				ch = str.charAt(0);
			}
		} while (!exit);
		return ch;
	}

	public char readLowerCase() {
		String str;
		char ch = ' ';
		boolean exit = false;
		do {
			str = keyboard.next();
			cleanInput();
			if (str.length() > 1 || str.length() < 1 || str.matches("[a-z]")) {
				System.out.println(
						"el valor es mas largo que un caracter o no es minuscula, vuelve a introducir el valor");

			} else {
				exit = true;
				ch = str.charAt(0);
			}
		} while (!exit);
		return ch;
	}

	public char readUpperCase() {
		String str;
		char ch = ' ';
		boolean exit = false;
		do {
			str = keyboard.next();
			cleanInput();
			if (str.length() > 1 || str.length() < 1 || str.matches("[A-Z]")) {
				System.out.println(
						"el valor es mas largo que un caracter o no es may�scula, vuelve a introducir el valor");

			} else {
				exit = true;
				ch = str.charAt(0);
			}
		} while (!exit);
		return ch;
	}

	public String readString() {
		String str;
		str = keyboard.next();
		cleanInput();
		return str;
	}

	public boolean readBooleanUsingChar(char affirmativeValue) {
		boolean affirmative = false;
		String str;
		char ch = ' ';
		boolean exit = false;
		do {
			str = keyboard.next();
			cleanInput();
			if (str.length() > 1 || str.length() < 1) {
				System.out.println("el valor es mas largo que un caracter, vuelve a introducir el valor");
			} else {
				exit = true;
				ch = str.charAt(0);
			}
		} while (!exit);

		if (ch == affirmativeValue) {
			affirmative = true;
		}

		return affirmative;
	}

	public boolean readBooleanUsingChar() {
		boolean affirmative = false;
		String str;
		char ch = ' ';
		boolean exit = false;
		do {
			str = keyboard.next();
			cleanInput();
			if (str.length() > 1 || str.length() < 1) {
				System.out.println("el valor es mas largo que un caracter, vuelve a introducir el valor");
			} else {
				exit = true;
			}
		} while (!exit);
		str = Character.toString(str.charAt(0));
		if (str.matches("[sS]")) {
			affirmative = true;
		}

		return affirmative;
	}

	public boolean readBooleanUsingChar(char affirmativeValue, char negativeValue) {
		boolean affirmative = false;
		String str;
		affirmativeValue = Character.toLowerCase(affirmativeValue);
		negativeValue = Character.toLowerCase(negativeValue);
		char ch = ' ';
		boolean exit = false;
		do {
			str = keyboard.next();
			cleanInput();
			if (str.length() > 1 || str.length() < 1) {
				System.out.println("el valor es mas largo que un caracter, vuelve a introducir el valor");
			} else {
				ch = str.charAt(0);
				ch = Character.toLowerCase(ch);
				if (ch == affirmativeValue || ch == negativeValue) {
					exit = true;

				} else {
					System.out.println("el valor introducido no es v�lido");
				}

			}
		} while (!exit);

		if (ch == affirmativeValue) {
			affirmative = true;
		}
		return affirmative;
	}

	public boolean readBooleanUsingInt(int affirmativeValue) {
		boolean affirmative = false;
		int in = 0;
		in = readInt();
		cleanInput();
		if (in == affirmativeValue) {
			affirmative = true;
		}
		return affirmative;
	}

	public boolean readBooleanUsingInt() {
		boolean affirmative = false;
		int in = 0;
		in = readInt();
		cleanInput();
		if (in == 1) {
			affirmative = true;
		}
		return affirmative;
	}

	public boolean readBooleanUsingInt(int affirmativeValue, int negativeValue) {
		boolean affirmative = false;
		int in = 0;
		boolean exit = false;
		do {
			in = readInt();
			cleanInput();
			if (in == affirmativeValue || in == negativeValue) {
				exit = true;
			} else {
				System.out.println("introduce un valor v�lido");
			}
		} while (!exit);

		if (in == affirmativeValue) {
			affirmative = true;
		}
		return affirmative;
	}

}
