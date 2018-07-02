import java.lang.Math;
import java.text.DecimalFormat;

public class bubbleSort extends sortTools {
	
	static long totalCount;

	public static void main(String[] args) {

		int[] testSet = preRun();
		printArray(bubbleSort(testSet));
		postRun();

		// sort specific stats
		double swapRatio = Double.parseDouble(twoDec.format(totalCount / time));
		System.out.println("Number of numbers: " + testSet.length);
		System.out.println("Number of swaps: " + totalCount);
		System.out.println("Swaps per second: " + swapRatio );

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