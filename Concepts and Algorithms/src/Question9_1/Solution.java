package Question9_1;

public class Solution {
	public static int n = 7;
	public static int waysFromStep[] = new int[n - 3];

	public static int possibleWays(int i) {
		if (i == n)
			return 0;
		if (i == n - 1)
			return 1;
		if (i == n - 2)
			return 2;
		if (i == n - 3)
			return 4;

		if (waysFromStep[i] == 0) {
			waysFromStep[i] = possibleWays(i + 1) * possibleWays(i + 2)
					* possibleWays(i + 3);
		}

		return waysFromStep[i];
	}

	public static void main(String[] args) {
		for(int i=0;i<waysFromStep.length;i++){
			waysFromStep[i]=0;
		}
		System.out.println(possibleWays(0));
	}

}
