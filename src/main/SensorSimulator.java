package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SensorSimulator {

	public static void main(String[] args) {
		Random rand = new Random();
		List<Integer> nineNumbers = generateNineNumbers(rand);
		Collections.sort(nineNumbers);
		System.out.println("The list is:");
		for(int i=0; i<nineNumbers.size() - 1; i++) {
			System.out.print(nineNumbers.get(i) + ",");
		}
		System.out.print(nineNumbers.get(nineNumbers.size()-1) + "\n");
		System.out.println("\nThe Median is: " + getMedian(nineNumbers) + "\n");
		System.out.println("The standard deviation is: " + getStandardDev(nineNumbers));
		System.out.println("\nThe outliers (more than one std dev from the median) are:");
		List<Integer> outliers = getOutliers(nineNumbers);
		if (outliers.size() >= 1) {
			for(int i=0; i<outliers.size() - 1; i++) {
				System.out.print(outliers.get(i) + ",");
			}
			System.out.print(outliers.get(outliers.size()-1) + "\n");
		} else {
			System.out.println("No outliers in this set!");
		}
	}
	
	//Get median of integer list
	public static float getMedian(List<Integer> numbers) {
		int midpoint = 0;
		float median = 0;
		//Sort the list
		Collections.sort(numbers);
		//If the list has an even amount of items
		if (numbers.size() % 2 == 0) {
			//Find midpoint of list and set median equal to the average of the middle 2 numbers
			midpoint = (numbers.size())/2;
			median = (numbers.get(midpoint) + numbers.get(midpoint - 1))/2;
		} else {
			//If list has odd number of items, simply find the midpoint and choose that value
			midpoint = (numbers.size())/2;
			median = numbers.get((int) (midpoint + 0.5));
		}
		return median;
		
	}
	
	//Returns standard deviation of integer list
	public static float getStandardDev(List<Integer> list) {
		//Get mean of list
		float sum = 0;
		for (int i=0; i<list.size(); i++) {
			sum += list.get(i);
		}	
		
		float mean = sum/list.size();
		
		//Calculate (each list item minus mean) squared
		List<Float> devList = new ArrayList<Float>();
		for (int i=0; i<list.size(); i++) {
			float n = list.get(i);
			float value = (n - mean)*(n - mean);
			devList.add(value);
		}
		
		//Get mean of list
		int sumDev = 0;
		for (int i=0; i<devList.size(); i++) {
			sumDev += devList.get(i);
		}	
		float meanDev = sumDev/devList.size();
		
		//Sqrt result
		float stdDev = (float) Math.sqrt(meanDev);
		
		return stdDev;
	}
	
	//Find outliers from number list
	public static List<Integer> getOutliers(List<Integer> list) {
		List<Integer> outlierList = new ArrayList<Integer>();
		float med = getMedian(list);
		float stdDev = getStandardDev(list);
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) < med - stdDev || list.get(i) > med + stdDev) {
				outlierList.add(list.get(i));
			}
		}
		return outlierList;
	}
	
	
	//Generate a list of 9 random numbers
	public static List<Integer> generateNineNumbers(Random rand) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<9; i++) {
			int  n = rand.nextInt(160) + 20;
			list.add(i, n);
		}
		return list;
	}
}
