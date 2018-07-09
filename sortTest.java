import java.util.Scanner;

public class sortTest extends SortTools {

	static int[] testSet;
	
	public static void main(String[] args) {

		System.out.println("\n");
		System.out.println("Enter size of test sample: ");
		
		Scanner keyIn = new Scanner(System.in);
		int sampleSize = keyIn.nextInt();

		SortTools toolkit = new SortTools();

		// generate an array to be sorted by
		// each sorting algorithm
		int[] testSet = toolkit.preRun(sampleSize);
		int[] bubbleSet = new int[sampleSize];
		int[] selectionSet = new int[sampleSize];

		// create arrays specific for each sort
		// to avoid changing the original
		// unsorted array
		for (int i = 0; i < sampleSize; i++){

			bubbleSet[i] = testSet[i];
			selectionSet[i] = testSet[i];

		}

		bubble(bubbleSet);

		System.out.print("\n");
		System.out.print("\n");

		selection(selectionSet);

	}

	/***********************************************
	METHOD: bubble(int[] set)
		Use: Alerts the user that the sort is running,
			then creates a bubble sort object to run
			the sort
		Parameters:
			set: an array of unosrted numbers 
	***********************************************/

	public static void bubble(int[] set){
		System.out.println("(RUNNING BUBBLE SORT)\n");
		BubbleSort bubble = new BubbleSort();
		bubble.sort(set);
	}

	/***********************************************
	METHOD: selection(int[] set)
		Use: Alerts the user that the sort is running,
			then creates a selection sort object to 
			run the sort
		Parameters:
			set: an array of unosrted numbers 
	***********************************************/

	public static void selection(int[] set){
		System.out.println("(RUNNING SELECTION SORT)\n");
		SelectionSort selection = new SelectionSort();
		selection.sort(set);
	}


}