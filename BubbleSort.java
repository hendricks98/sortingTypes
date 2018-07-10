import java.text.DecimalFormat;
import java.io.IOException;

public class BubbleSort extends SortTools {

	private static long totalCount;

	public static void sort(int[] testSet){

		SortTools bubbleKit = new SortTools();

		totalCount = 0;
		double bubbleStart = bubbleKit.startTime();
		bubbleSort(testSet);
		double bubbleStop = bubbleKit.stopTime();

		bubbleKit.postRun(bubbleStart, bubbleStop, testSet, totalCount);

		try{
			bubbleKit.postRunOut(bubbleStart, bubbleStop, testSet, totalCount);
		} catch (IOException e){
			System.out.println("IOException!");
		}

	}

	/***********************************************
	METHOD: bubbleSort(int[] numbers)
		Use: Bubble sort algorithm, sorts an array
			of integers, swapping smaller numbers
			one by one as it iterates thru array
		Parameters:
			numbers: array with random integers
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
