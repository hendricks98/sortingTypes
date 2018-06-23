import java.lang.Math;
import java.text.DecimalFormat;

public class bubbleSort {
	
	static long totalCount;
	static double start;
	static double finish;

	public static void main(String[] args) {


		System.out.println("Generating unsorted array: ");

		int[] testNums = fillArray();
		printArray(testNums);
		System.out.println("");

		System.out.println("Running bubbleSort algorithm: ");

		start = System.nanoTime() / 1000000000.0;
		printArray(bubbleSort(testNums));
		finish = System.nanoTime() / 1000000000.0;
		double totalTime = (finish - start);

		System.out.println("");

		DecimalFormat fourDec = new DecimalFormat(".0000");
		DecimalFormat twoDec = new DecimalFormat(".00");
		double time = Double.parseDouble(fourDec.format(totalTime));
		double swapRatio = Double.parseDouble(twoDec.format(totalCount / time));

		System.out.println("Analytics: ");
		System.out.println("Number of numbers: " + testNums.length);
		System.out.println("Number of swaps: " + totalCount);
		System.out.println("Approximate processing time: " + time + " seconds");
		System.out.println("Swaps per second: " + swapRatio );


	}

	public static void printArray(int[] list) {

		for (int i = 0; i < list.length; i++) {

			System.out.print(list[i] + " ");

		}

		System.out.println("");
	}

	public static int[] fillArray() {
		int[] numbers;
		numbers = new int[100];

		// fill array with random numbers between 1-100
		for (int i = 0; i < numbers.length; i++){

			numbers[i] = (int) (Math.random() * 1000 ) + 1;
		}

		return numbers;
	}

	public static int[] bubbleSort(int[] numbers) {

		boolean sorted = false;
		int swapCount = 0;

		while (!sorted) {

			swapCount = 0;

			for (int i = 0; i < numbers.length - 1; i++){

				if (numbers[i] > numbers[i+1]) {

					int swap = numbers[i+1];
					numbers[i+1] = numbers[i];
					numbers[i] = swap;
					//printArray(numbers);
					swapCount++;
					totalCount++;

				}

			}

			if (swapCount == 0) {

				sorted = true;

			}

		}
		return numbers;
	}

}