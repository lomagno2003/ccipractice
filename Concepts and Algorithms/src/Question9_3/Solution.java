package Question9_3;

import java.util.Collection;
import java.util.LinkedList;

public class Solution {
	/*
	if the array is sorted, then the first M elements must be magic indexes, because
	the elements are distinct, so, the a[1]=1, the only option to the element 2 is a[2]=2.
	If it isn't 2, then the next elements can't be magic indexes.
	*/

	/*
	If the array is sorted, and the elements are not distinct, then if a found a index 
	in which for A[i]=j, j<i, i can be sure that the following elements don't contain magic indexes.
	Now if the array is sorted, i can do a binary search to find one magic index
	(if i<j, search in the left half, if i>j find in the right half).
	When we find one magic index, the elements before and after could be magic indexes too,
	so we have to iterate through them to get all the magic indexes 
	*/

	public static Collection<Integer> getMagicIndexes(int a[]){
		Collection<Integer> result = new LinkedList<Integer>();
		
		int i=a.length / 2;
		int area = a.length - i;
		
		while(a[i]!=i&&i!=0&&i!=a.length-1){
			System.out.println(a[i] + " == " + i);
			System.out.println("Area: " + area);
			if(a[i]>i){
				/* Go to right */
				area /= 2;
				i = i + area;
			} else if(a[i]<i){
				/* Go to left */
				i = i/2;
			}
		}
		
		/* The array don't contains magic indexes */
		if(a[i]!=i){
			return result;
		}
		
		int mi = i;
		
		while(i<a.length - 1&&a[i]==i){
			result.add(i);
			i++;
		}
		
		i = mi - 1;
		
		while(a[i]==i&&i>0){
			result.add(i);
			i--;
		}
		
		return result;
	}
	
	public static void main(String args[]){
		int a[]={6,6,6,6,6,6,6};
		
		Collection<Integer> magicIndexes = getMagicIndexes(a);
		
		for(Integer mi : magicIndexes){
			System.out.println(mi);
		}
	}
}
