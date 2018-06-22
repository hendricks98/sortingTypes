import java.lang.Math;

public class bubbleSort {
	

	public static void main(String[] args) {


			System.out.println("Generating unsorted array: ");

			int[] testNums = fillArray();
			printArray(testNums);
			System.out.println("");

			System.out.println("Running bubbleSort algorithm: ");

			printArray(bubbleSort(testNums));



	}

	public static void printArray(int[] list) {

		for (int i = 0; i < list.length; i++) {

			System.out.print(list[i] + " ");

		}

		System.out.println("");
	}

	public static int[] fillArray() {
		int[] numbers;
		numbers = new int[50];

		// fill array with random numbers between 1-100
		for (int i = 0; i < numbers.length; i++){

			numbers[i] = (int) (Math.random() * 100 ) + 1;
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

				}

			}

			if (swapCount == 0) {

				sorted = true;

			}

		}
		return numbers;
	}

}