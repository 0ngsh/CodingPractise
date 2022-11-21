import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

public class CodingPractise {


	/*
	 * Given a string S, find length of the longest substring with all distinct characters. 

	Example 1:

	Input:
	S = "geeksforgeeks"
	Output: 7
	Explanation: "eksforg" is the longest 
	substring with all distinct characters.

	 * 
	 * 
	 */

	public int longestSubstrDistinctChars(String S){
		HashSet<Character> set=new HashSet(); 
		int start=0;
		int end=0;
		for(int i=0;i<S.length();i++)
		{
			//geeksforgeeks
			
			if(!set.add(S.charAt(i)))
			{
				start=i;
				
				System.out.println("I am here: "+ i );
			}
			else
			{
				end=i;
			}
			
				
			
		}
		System.out.println("Start: "+start+" End: "+end);
		return end-start;

	}


/*
 * 
 * 
 * Splitter
 * 
 */

   public void splitter(String input,String spliter)
   {
	final List<String> items = Arrays.asList(input.split(spliter));
	for (final String item : items) {
		System.out.println(item);
	}
   }



	/*
	 * Day 11
	 * Given an array of strings strs, group the anagrams together. You can return
	 * the answer in any order.
	 * 
	 * An Anagram is a word or phrase formed by rearranging the letters of a
	 * different word or phrase, typically using all the original letters exactly
	 * once.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
	 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	 * 
	 * Example 2:
	 * 
	 * Input: strs = [""]
	 * Output: [[""]]
	 * 
	 * Example 3:
	 * 
	 * Input: strs = ["a"]
	 * Output: [["a"]]
	 * 
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= strs.length <= 104
	 * 0 <= strs[i].length <= 100
	 * strs[i] consists of lowercase English letters.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public List<List<String>> GroupAnagram(String[] strs) {
		List<List<String>> out = new ArrayList<>();
		List<String> ignoreWord = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			if (ignoreWord.contains(strs[i])) {
				continue;
			}
			List<String> o1 = new ArrayList<>();
			o1.add(strs[i]);
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String string = new String(temp);
			for (int j = i + 1; j < strs.length; j++) {
				char[] temp1 = strs[j].toCharArray();
				Arrays.sort(temp1);
				String string1 = new String(temp1);
				if (string.equals(string1)) {
					o1.add(strs[j]);
					ignoreWord.add(strs[j]);
				}
			}
			out.add(o1);
		}
		return out;
	}

	/**
	 * Day 10
	 * 
	 * Write a program to print all the LEADERS in the array.
	 * An element is leader if it is greater than all the elements to its right
	 * side.
	 * And the rightmost element is always a leader.
	 * For example in the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
	 * 
	 * 
	 * 
	 */

	public void checkLeader(int arr[]) {

		int leader = 0;
		for (int i = arr.length - 1; i >= 0; i--) {

			if (leader <= arr[i]) {
				leader = arr[i];
				System.out.println(leader);
			}
		}

	}

	/**
	 * Day 9
	 * 
	 * Given a string without spaces, the task is to remove duplicates from it.
	 * 
	 * Note: The original order of characters must be kept the same.
	 * 
	 * Example 1:
	 * 
	 * Input: S = "zvvo"
	 * Output: "zvo"
	 * Explanation: Only keep the first
	 * occurrence
	 * Example 2:
	 * 
	 * Input: S = "gfg"
	 * Output: gf
	 * Explanation: Only keep the first
	 * occurrence
	 * 
	 * 
	 *
	 */

	public String removeDuplicate(String s) {
		String o = "";
		LinkedHashSet<Character> hm = new LinkedHashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (hm.add(s.charAt(i))) {
				o += s.charAt(i);
			}
		}
		return o;
	}

	/**
	 * Day 8 after 4 days gap
	 * Given an array of N integers, and a number sum, the task is to find the
	 * number of pairs of integers in the array whose sum is equal to sum.
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = {1, 5, 7, -1}, sum = 6
	 * 
	 * Output: 2
	 * Explanation: Pairs with sum 6 are (1, 5) and (7, -1).
	 * 
	 * Input: arr[] = {1, 5, 7, -1, 5}, sum = 6
	 * Output: 3
	 * Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).
	 * 
	 * Input: arr[] = {1, 1, 1, 1}, sum = 2
	 * Output: 6
	 * Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1,
	 * 1)
	 * , (1, 1).
	 * 
	 * Input: arr[] = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}, sum = 11
	 * Output: 9
	 * Explanation: Pairs with sum 11 are (10, 1), (10, 1), (10, 1), (12, -1), (10,
	 * 1), (10, 1), (10, 1), (7, 4), (6, 5).
	 * 
	 */

	public int findPairWithSum(int arr[], int sum) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		// Store counts of all elements in map hm
		int n = arr.length;
		int twice_count = 0;
		for (int i = 0; i < n; i++) {

			// initializing value to 0, if key not found
			if (!hm.containsKey(arr[i]))
				hm.put(arr[i], 0);

			hm.put(arr[i], hm.get(arr[i]) + 1);
		}

		for (int i = 0; i < n; i++) {
			if (hm.get(sum - arr[i]) != null) {
				twice_count += hm.get(sum - arr[i]);
				System.out.println(arr[i] + " , " + (sum - arr[i]));
			}

			// if (arr[i], arr[i]) pair satisfies the
			// condition, then we need to ensure that the
			// count is decreased by one such that the
			// (arr[i], arr[i]) pair is not considered
			if (sum - arr[i] == arr[i])
				twice_count--;
		}

		// return the half of twice_count
		return twice_count / 2;
	}

	/**
	 * Day 7
	 * Given an array of size N-1 such that it only contains distinct integers in
	 * the range of 1 to N. Find the missing element.
	 * Input:
	 * N = 5
	 * A[] = {1,2,3,5}
	 * Output:4
	 * 
	 * Input:
	 * N = 10
	 * A[] = {6,1,2,8,3,4,7,10,5}
	 * 1,2,3,4,5,6,7,8,10
	 * Output:9
	 * 
	 * N =2
	 * A[] = {1}
	 * Output:2
	 * 
	 * 
	 */

	public int findMssingElement(int arr[], int n) {

		int out = n;
		Arrays.sort(arr);
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != (i + 1)) {
				out = i + 1;
				break;

			}

		}
		return out;
	}

	/*
	 * Given a data set with details pertaining to amount that one person owes to
	 * the other in the form of CSV.
	 * 
	 * Sample Input
	 * Friend 1 Friend 2 Amount
	 * M N 20
	 * L M 70
	 * N L 40
	 * N K 100
	 * M,N,10
	 * N,M, 5
	 * 
	 * 
	 * Row 1 implies that M owes 20 Rs to N
	 * Row 2 implies that L owes 70 Rs to M
	 * Similar to other rows
	 * 
	 * Given the above info design a solution to derive the below-mentioned
	 * insights:
	 * 
	 * How much debt does each person owes to all users? dhar to each people
	 * How much money is a person owed?
	 * Who is the person with the most debt?
	 * Who is the person with the most money owed?
	 * 
	 */
	// day 6

	public void personOws() {

		String[] inp = { "M,N,20", "L,M,70", "N,L,40", "N,K,100", "M,N,10", "N,M,5" };
		// K=0 L=1 M=2 N=3
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "K");
		map.put(1, "L");
		map.put(2, "M");
		map.put(3, "N");
		// Starting of inserting data into 2D array
		int[][] ows = new int[4][4];
		for (int i = 0; i < inp.length; i++) {
			String[] tempArr = inp[i].split(",", 3);
			int t1 = 0;
			int t2 = 0;

			for (Entry<Integer, String> entry : map.entrySet()) {
				if (entry.getValue().equals(tempArr[0])) {
					t1 = entry.getKey();
				}
				if (entry.getValue().equals(tempArr[1])) {
					t2 = entry.getKey();
				}
			}
			ows[t1][t2] = ows[t1][t2] + Integer.parseInt(tempArr[2]);

		}
		// Ending of inserting data into 2D array

		int[] allOws = new int[4];
		int[] allDebt = new int[4];
		int maxDebt = 0;
		int maxOws = 0;
		int maxDebtIndex = 0;
		int maxOwsIndex = 0;
		for (int i = 0; i < 4; i++) {
			System.out.println("____________");
			System.out.println(map.get(i) + " Report");
			System.out.println("____________");
			for (int j = 0; j < 4; j++) {
				// 00+01+02+03
				if (i != j) {
					allDebt[i] = allDebt[i] + ows[i][j];
					System.out.println(map.get(i) + " ows to " + map.get(j) + ":" + ows[i][j]);
					allOws[i] = allOws[i] + ows[j][i];
				}

			}
			System.out.println("");
			System.out.println(map.get(i) + " toatl ows to all=" + allDebt[i]);

			if (allDebt[i] >= maxDebt) {
				maxDebt = allDebt[i];
				maxDebtIndex = i;

			}
			int moneyOwed = (allOws[i] - allDebt[i]);
			System.out.println(map.get(i) + " toatl owed=" + allOws[i]);
			System.out.println(map.get(i) + " " + moneyOwed + " owed");

			if (moneyOwed >= maxOws) {
				maxOws = moneyOwed;
				maxOwsIndex = i;
			}
		}
		System.out.println("__________  Q3 and Q4__________________");
		System.out.println(map.get(maxDebtIndex) + " is the person with the most debt of Rs." + maxDebt);
		System.out.println(map.get(maxOwsIndex) + " is the person with the most money(Rs. " + maxOws + ") owed");
	}

	/**
	 * Day 1 19 oct 2022
	 * Ask Question from Kuntal
	 */
	public void Day1() {
		HashMap<String, Integer> map = new HashMap<>();
		String inp = "MCMXCIV";
		// String inp="III";
		// Adding elements to the Map
		// using standard put() method
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		int out = map.get(inp.charAt(0) + "");
		;
		// 1000,
		for (int i = 1; i < inp.length(); i++) {
			int v = map.get(inp.charAt(i) + "");
			int prevV = map.get(inp.charAt(i - 1) + "");
			if (prevV < v) {
				int t = v - prevV;
				System.out.println(t + "prevV<v");
				out = out - prevV;
				out = out + (v - prevV);
			} else {
				System.out.println(v + "prevV>=v");
				out = out + v;
			}

		}

		System.out.println(out);
	}

	/**
	 * Day 2 20/Oct/2022
	 * Given a array of N strings, find the longest common prefix among all strings
	 * present in the array.
	 * Expected Time Complexity: O(N*max(|arri|)).
	 * Expected Auxiliary Space: O(max(|arri|)) for result.
	 * 
	 * @param a
	 * @param n
	 * @return
	 */

	public String longestCommonPrefix(String a[], int n) {

		/* if size is 0, return empty string */
		if (n == 0)
			return "";

		if (n == 1)
			return a[0];

		/* sort the array of strings */
		Arrays.sort(a);

		for (String sortString : a) {
			System.out.print(sortString + " ");
		}

		/* find the minimum length from first and last string */
		int end = Math.min(a[0].length(), a[n - 1].length());

		System.out.println("minlength: " + end);

		/*
		 * find the common prefix between the first and
		 * last string
		 */
		int i = 0;
		while (i < end && a[0].charAt(i) == a[n - 1].charAt(i))
			i++;

		String pre = a[0].substring(0, i);
		return pre;

	}

	/**
	 * Day 3 21/10/2022
	 * 
	 * Dynamic Programming
	 * 
	 * @param x
	 * @param y
	 * @param s1
	 * @param s2
	 * 
	 */

	public int longestCommonSubsequence(int x, int y, String s1, String s2) {
		if (x == 0 || y == 0)
			return 0;
		if (s1.charAt(x - 1) == s2.charAt(y - 1))
			return 1 + longestCommonSubsequence(x - 1, y - 1, s1, s2);
		else
			return Math.max(longestCommonSubsequence(x, y - 1, s1, s2), longestCommonSubsequence(x - 1, y, s1, s2));

	}

	/**
	 * Day 4,5 ,7 24/10/2022
	 * Write a function that reverses characters in (possibly nested) parentheses in
	 * the input string.
	 * Input strings will always be well-formed with matching ()s.
	 * Example
	 * For inputString = "(bar)", the output should be solution(inputString) =
	 * "rab";
	 * For inputString = "foo(bar)baz", the output should be solution(inputString) =
	 * "foorabbaz";
	 * For inputString = "foo(bar)baz(blim)", the output should be
	 * solution(inputString) = "foorabbazmilb";
	 * For inputString = "foo(bar(baz))blim", the output should be
	 * solution(inputString) = "foobazrabblim".
	 * Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then
	 * "foobazrabblim".
	 * Input/Output
	 * [execution time limit] 3 seconds (java)
	 * [input] string inputString
	 * 
	 * A string consisting of lowercase English letters and the characters ( and ).
	 * It is guaranteed that all parentheses in inputString form a regular bracket
	 * sequence.
	 * 
	 * Guaranteed constraints:
	 * 0 ≤ inputString.length ≤ 50.
	 * 
	 * [output] string
	 * 
	 * Return inputString, with all the characters that were in parentheses
	 * reversed.
	 */

	String reverseInParentheses1(String s) {
		StringBuilder str = new StringBuilder();
		int start = 0;
		int end = s.length() - 1;
		str.setLength(0);

		// recursion used to find the most nested parentheses
		if (s.contains("(")) {
			start = s.lastIndexOf("(");
			end = s.indexOf(")", start);
			str.append(s, start + 1, end);
			return reverseInParentheses1(s.substring(0, start) + str.reverse().toString() + s.substring(end + 1));
		}
		return s;
	}

	public String reverseInParentheses(String inputString) {
		System.out.println("Input String:" + inputString);
		boolean brac_found = false;
		Stack<Character> stack = new Stack<Character>();
		String out = "";
		for (int i = 0; i < inputString.length(); i++) {
			Character cTemp = inputString.charAt(i);
			if (cTemp == ')') {
				brac_found = false;
				for (int j = 0; j <= stack.size(); j++) {
					if (stack.peek() == '(') {

						Character c = stack.pop();
						System.out.println(c + ": popped");
						break;
					} else {

						Character c = stack.pop();
						System.out.println(c + ": popped");
						// out=out.substring(0,out.length()-1);
						out += c;
					}

				}
			} else if (cTemp == '(') {
				brac_found = true;
				stack.push(inputString.charAt(i));
			} else {
				;
				if (brac_found == false) {
					out += cTemp;
				} else {
					stack.push(cTemp);
				}

			}

		}
		return out;

	}

}
