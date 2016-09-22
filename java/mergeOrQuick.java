/**
 * MERGE SORT HAS STACK OVERFLOW PROBLEMS 
 * Problem: Mergesort or Quicksort
 *
 * In this problem, implement either mergesort or quicksort
 *
 * For your help, we have supplied a million-element array of
 * unsorted numbers that your sorting algorithm should be 
 * able to sort. 
 *
 * REMINDER: ONLY DO EITHER MERGESORT OR QUICKSORT, NOT BOTH
 */

// test is an array of a million unsorted elements
// run your algorithm on test

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class mergeOrQuick {
  public static void main(String args[]) {
    //int i = 1000000;
	  int i = 10;
    List<Double> test = new ArrayList<>(Arrays.asList(1.38, 2.56, 4.3));

    Random rand;
    while (i > 0){
       test.add(Math.floor(Math.random() * 100000));
       i--;
    }

    System.out.println(test);

    MergeSort prob1 = new MergeSort();
    prob1.mergeSort(test);

    QuickSort prob2 = new QuickSort();
    prob2.quickSort(test,0,test.size());

  }
}

class MergeSort {
  public List<Double> mergeSort(List<Double> list){
    
	  return mergeSortRecursion(list, 0, list.size()-1);
  }
  
  public List<Double> mergeSortRecursion(List<Double> list, int startIndex, int endIndex){
	  	// your work here
		//base case 
		  if(startIndex == endIndex){
			  ArrayList<Double> newlist = new ArrayList<Double>();
			  newlist.add(list.get(startIndex));
			  return newlist; 
		  }
		  //cut in half 
		  int half = Math.abs((endIndex-startIndex))/2; 
		  List<Double> left = mergeSortRecursion(list, startIndex, half); 
		  List<Double> right = mergeSortRecursion(list,half+1, endIndex); 
		  return merge(left,right); 
		  
  }
  
  public List<Double> merge(List<Double> list1, List<Double> list2){
	  
	  List<Double> mergedList = new ArrayList<Double>(); 
	  int minSize = Math.min(list1.size(), list2.size());
	  
	  int l1index = 0; 
	  int l2index = 0; 
	  for(int i=0; i< minSize; i++){
		  //list 1 element is smaller 
		  if(list1.get(l1index) <= list2.get(l2index)){
			  mergedList.add(list1.get(l1index)); 
			  l1index++;   
		  }else{
			  mergedList.add(list2.get(l2index)); 
			  l2index++; 
		  }
		  
		  if(l1index == minSize-1){
			  //copy over leftover l2 
			  for(double dub: list2){
				  mergedList.add(dub); 
			  }
		  }else{
			  //copy over l1 
			  for(double dub: list1){
				  mergedList.add(dub); 
			  }
		  }
		  
	  }
	  return mergedList; 
  }
  

  
}

class QuickSort {
  public void quickSort(List<Double> list, int start, int end){ 
	  int pivot = list.size()/2; 
	  double temp = list.get(0);
	  list.set(0,list.get(pivot));
	  list.set(pivot, temp); 
	  
	  double pivotValue = list.get(0); 
	  int pivotRandeIndex = 1;
	  for(int i = start; i< end; i++){
		  if(list.get(i) < pivotValue ){
			swap(list,pivotRandeIndex, i); 
			pivotRandeIndex++;
		  }
	  }
	  
	  //move the pivot back to its correct space 
	  swap(list,pivotRandeIndex-1, 0); 
	  
	  quickSort(list, start, pivotRandeIndex++); 
	  quickSort(list, pivotRandeIndex++, end); 
 	  
  }


	public static void swap(List<Double> list, int index1, int index2){
		double temp = list.get(index1); 
		list.set(index1, list.get(index2)); 
		list.set(index2, temp); 
	}
}




