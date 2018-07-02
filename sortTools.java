import java.lang.Math;
import java.text.DecimalFormat;

public class sortTools {
	public static double start;
	public static double finish;
	public static double time;
	public static DecimalFormat twoDec;
	public static DecimalFormat fourDec;

	/***********************************************
	METHOD: printArray(int[])
		Use: Prints each element of an integer array
		Parameters: Takes in integer array
	***********************************************/

	public static void printArray(int[] list) {

		for (int i = 0; i < list.length; i++) {

			System.out.print(list[i] + " ");

		}

		System.out.println("");
	}

	/***********************************************
	METHOD: fillArray()
		Use: Creates a sample test array and fills
			with random numbers, in a random order
		Parameters: None
	***********************************************/

	public static int[] fillArray() {

		int[] numbers;
		numbers = new int[100];

		// fill array with random numbers between 1-1000
		for (int i = 0; i < numbers.length; i++){

			numbers[i] = (int) (Math.random() * 100 ) + 1;
		}

		return numbers;
	}

	public static int[] preRun() {

		System.out.println("Generating unsorted array: ");

		int[] testNums = fillArray();
		printArray(testNums);
		System.out.println("");

		System.out.println("Running sort algorithm: ");
		start = System.nanoTime() / 1000000000.0;

		return testNums;
	}

	public static void postRun() {
		finish = System.nanoTime() / 1000000000.0;

		double totalTime = (finish - start);

		System.out.println("");

		fourDec = new DecimalFormat(".0000");
		twoDec = new DecimalFormat(".00");
		time = Double.parseDouble(fourDec.format(totalTime));

		System.out.println("Analytics: ");
		System.out.println("Approximate processing time: " + time + " seconds");

	}

}