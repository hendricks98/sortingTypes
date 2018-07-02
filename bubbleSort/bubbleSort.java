import java.lang.Math;
import java.text.DecimalFormat;

public class bubbleSort {
	

	static long totalCount;
	static String fullPrint;

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

	/***********************************************
	METHOD: printArray(int[])
		Use: Prints each element of an integer array
		Parameters: Takes in integer array
	***********************************************/

	public static void printArray(int[] list) {
		
		System.out.print("\nSORTED ARRAY: ");

		// cycle through each element of array
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
		numbers = new int[10];

		// fill array with random numbers
		for (int i = 0; i < numbers.length; i++){

			numbers[i] = (int) (Math.random() * 10 ) + 1;
		}

		return numbers;

	}

	/***********************************************
	METHOD: bubbleSort(int[])
		Use: Bubble sort algorithm, sorts an array 
			of integers, swapping smaller numbers
			one by one as it iterates thru array
		Parameters: Array with random integers
	***********************************************/

	public static int[] bubbleSort(int[] numbers) {

		boolean sorted = false;
		int swapCount = 0;

		while (!sorted) {
			swapCount = 0;
			for (int i = 0; i < numbers.length - 1; i++){
				// swap if smaller number is found
				if (numbers[i] > numbers[i+1]) {
					int swap = numbers[i+1];
					numbers[i+1] = numbers[i];
					numbers[i] = swap;


					swapCount++;
					totalCount++;
				}
			}

			// if no swaps are conducted, exit the loop
			if (swapCount == 0) {
				sorted = true;
			}

		}

		return numbers;

	}

}