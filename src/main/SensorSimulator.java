package main;

import java.util.ArrayList;
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
	}
	
	//Get median of integer list
	public static int getMedian(List<Integer> nineNumbers) {
		Collections.sort(nineNumbers);
		int median = nineNumbers.get(4);
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
