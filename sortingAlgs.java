/**
 * @author Faelan S.
 * 
 * This illustrates a whole bunch of sorting methods using randomly generated
 * numbers to show how each step of a sorting algorithm works.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class sortingAlgs 
{
	/**
	 * Main method that takes user input and selects a sorting method
	 * appropriately.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		boolean isDone = false;
				
		do
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter which sorting method you'd like to see: \n"
					+ "  i = insertion sort\n  s = selection sort \n" + 
					"  b = bubble sort\n  r = radix sort \n" + "  'stop' to quit"); 
			String input = in.nextLine();
		
			if(input.equals("s"))
				selectionSort();
			else if(input.equals("i"))
				insertionSort();
			else if(input.equals("b"))
				bubbleSort();
			else if(input.equals("r"))
				radixSort();
			else if(input.equals("stop"))
			{
				isDone = true;
			}
			System.out.println();
		} while(!isDone);
	}
	
	private static void radixSort() 
	{
		//TODO: not currently implemented
		//It is a stable sort based on each index of a multi-digit numer though
	}

	/**
	 * Bubble Sort: 
	 * Each pass, moves the highest number to the top by switching
	 * any number that's larger than the number after it with said number.
	 */
	private static void bubbleSort() 
	{
		Random r = new Random();
		int toSort[] = new int[10];
		for(int i = 0; i < 10; i++)
		{
			int toAdd = r.nextInt(20) + 1;
			toSort[i] = toAdd;
		}
	
		System.out.println("Unsorted array: ");
		printArr(toSort);
	
		for(int i = 0; i < toSort.length; i++)
		{
			for(int j = 0; j < toSort.length - 1; j++)
			{
				if(toSort[j] > toSort[j + 1])
				{
					int toSave = toSort[j];
					toSort[j] = toSort[j + 1];
					toSort[j + 1] = toSave;
				}
			}
			
			System.out.println("Array after pass " + (i + 1) + ": ");
			printArr(toSort);
		}
	}

	/**
	 * Insertion Sort:
	 * For each pass, picks the spot where the currently selected (ith) number
	 * should go, moves each element in the sorted sub-array up one until
	 * place i, and then inserts the element in its sorted position.
	 */
	private static void insertionSort() 
	{
		Random r = new Random();
		int toSort[] = new int[10];
		for(int i = 0; i < 10; i++)
		{
			int toAdd = r.nextInt(20) + 1;
			toSort[i] = toAdd;
		}
	
		System.out.println("Unsorted array: ");
		printArr(toSort);
	
		for(int i = 1; i < toSort.length; i++)
		{
			int addAt = 0;
			
			for(int j = 0; j <= i; j++)
			{
				if(toSort[i] > toSort[j])
					addAt++;
			}
			
			int toSave = toSort[i];
			for(int j = i; (j > addAt) && (j > 0); j--)
				toSort[j] = toSort[j - 1];
			toSort[addAt] = toSave;
			
			System.out.println("Array after pass " + (i) + ": ");
			printArr(toSort);
		}
	}

	/**
	 * Helper method that prints an array.
	 * 
	 * @param toPrint The array to print.
	 */
	private static void printArr(int[] toPrint)
	{
		for(int i = 0; i < toPrint.length; i++)
			System.out.print(toPrint[i] + " ");
		System.out.println();
	}
	
	/**
	 * Helper method that prints an ArrayList.
	 * 
	 * @param toPrint The ArrayList to print.
	 */
	private static void printArray(ArrayList<Integer> toPrint)
	{
		for(Integer elem : toPrint)
			System.out.print(elem + " ");
		System.out.println();
	}

	/**
	 * Selection Sort:
	 * Each pass, selects the next-smallest element in the unsorted section
	 * of the array and swaps it with the first element in the unsorted section.
	 */
	private static void selectionSort() 
	{
		Random r = new Random();
		ArrayList<Integer> toSort = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
		{
			int toAdd = r.nextInt(20) + 1;
			toSort.add(toAdd);
		}
		
		System.out.println("Unsorted array: ");
		printArray(toSort);
		
		for(int i = 0; i < toSort.size() - 1; i++)
		{
			int lowestIndex = i;
			for(int j = i; j < toSort.size(); j++)
			{
				if(toSort.get(j) < toSort.get(lowestIndex))
					lowestIndex = j;
			}
			
			int toSave = toSort.get(lowestIndex);
			toSort.remove(lowestIndex);
			toSort.add(lowestIndex, toSort.get(i));
			toSort.remove(i);
			toSort.add(i, toSave);
			
			System.out.println("Array after pass " + (i + 1) + ": ");
			printArray(toSort);
		}
	}
}