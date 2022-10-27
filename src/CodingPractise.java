import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;



public class CodingPractise {

	/*
Given a data set with details pertaining to amount that one person owes to the other in the form of CSV.

Sample Input
Friend 1 Friend 2 Amount
M N 20
L M 70
N L 40
N K 100
M,N,10
N,M, 5





Row 1 implies that M owes 20 Rs to N
Row 2 implies that L owes 70 Rs to M
Similar to other rows

Given the above info design a solution to derive the below-mentioned insights:

How much debt does each person owes to all users?
How much money is a person owed?
Who is the person with the most debt?
Who is the person with the most money owed?

	 */
//day 6
public void  personOws()
{
	//K=0 L=1 M=2 N=3
	int[][] ows = new int[4][4];

	//System.out.println(ows[0][3]);

	ows[2][3]=30;  //M N 20 +10 
	ows[1][2]=70;  //L M 70
	ows[3][1]=40;  //N L 40
	ows[3][0]=100; //N K 100
	ows[3][2]=5;  //N,M, 5
   

	int[] allOws= new int[4];  
	int[] alldebt= new int[4];

	

	for(int i=0;i<4;i++)
	{
		for(int j=0;j<4;j++)
		{

			   // 00+01+02+03
			allOws[i]=allOws[i]+ows[i][j];
			alldebt[i]=alldebt[i]+ows[j][i];
		}
      

	}

	for(int i=0;i<4;i++)
	{
		//System.out.println(i+" debt of "+(allOws[i]-alldebt[i]));
		System.out.println(i+" dhar of "+allOws[i]);
	}


}



	/**
	 *  Day 1 19 oct 2022
	 *  Ask Question from Kuntal
	 */
	public void  Day1()
	{
		HashMap<String, Integer> map = new HashMap<>();
        String inp="MCMXCIV";
         //String inp="III";
        // Adding elements to the Map
        // using standard put() method
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int out=map.get(inp.charAt(0)+"");;
       //1000,
        for(int i =1; i< inp.length();i++)
        {
            int v=map.get(inp.charAt(i)+"");
            int prevV=map.get(inp.charAt(i-1)+"");
                if(prevV<v)
                {
                   int t=v-prevV;
                   System.out.println(t +"prevV<v");
                   out=out-prevV;
                   out=out+(v-prevV);
                }
                else
                {
                     System.out.println(v +"prevV>=v");
                    out=out+v;
                }
           
           
           
           
        }
       
        System.out.println(out);
    }
		
	/**
	 * Day 2 20/Oct/2022
	 * Given a array of N strings, find the longest common prefix among all strings present in the array.
	 *  Expected Time Complexity: O(N*max(|arri|)).
		Expected Auxiliary Space: O(max(|arri|)) for result.
	 * @param a
	 * @param n
	 * @return
	 */
	
	public  String longestCommonPrefix(String a[], int n){


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
        int end = Math.min(a[0].length(), a[n-1].length());
       
        System.out.println("minlength: "+end);
 
        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && a[0].charAt(i) == a[n-1].charAt(i) )
            i++;
 
        String pre = a[0].substring(0, i);
        return pre;
       
       
    }
	
	/**
	 * Day 3 21/10/2022
	 * 
	 * Dynamic Programming
	 * @param x
	 * @param y
	 * @param s1
	 * @param s2
	 * 
	 */
	
	public int longestCommonSubsequence(int x, int y, String s1, String s2)
	{
		if (x==0 || y==0)
			return 0;
		if(s1.charAt(x-1) == s2.charAt(y-1))
			return 1+longestCommonSubsequence(x-1,y-1, s1, s2);
		else
			return Math.max(longestCommonSubsequence(x,y-1, s1, s2),longestCommonSubsequence(x-1,y, s1, s2));
		
	}
	
	/**
	 * Day 4,5 24/10/2022
	 * Write a function that reverses characters in (possibly nested) parentheses in the input string.
	 * Input strings will always be well-formed with matching ()s.
	 * Example
	 * For inputString = "(bar)", the output should be solution(inputString) = "rab";
	 * For inputString = "foo(bar)baz", the output should be solution(inputString) = "foorabbaz";
	 * For inputString = "foo(bar)baz(blim)", the output should be solution(inputString) = "foorabbazmilb";
	 * For inputString = "foo(bar(baz))blim", the output should be solution(inputString) = "foobazrabblim". 
	 * Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
	 *  Input/Output                                                                    
    	[execution time limit] 3 seconds (java)                                        
    	[input] string inputString

    	A string consisting of lowercase English letters and the characters ( and ). It is guaranteed that all parentheses in inputString form a regular bracket sequence.

    	Guaranteed constraints:
    	0 ≤ inputString.length ≤ 50.

    	[output] string

    	Return inputString, with all the characters that were in parentheses reversed.
	 */
	
	public  String reverseInParentheses(String inputString)
	{
		System.out.println("Input String:"+inputString);
		boolean brac_found=false;
		Stack<Character> stack = new Stack<Character>();
		String out="";
		for(int i=0;i<inputString.length();i++)
		{
			Character cTemp=inputString.charAt(i);
			if(cTemp==')')
			{
				brac_found=false;
				for(int j=0;j<=stack.size();j++)
				{
					if(stack.peek()=='(')
					{
						
						Character c=stack.pop();
						System.out.println(c+": popped");
						break;
					}
					else
					{
					
						Character c=stack.pop();
						System.out.println(c +": popped");
						//out=out.substring(0,out.length()-1);
						out+=c;
					}
					
				}
			}
			else if(cTemp=='(')
			{
				brac_found=true;
				stack.push(inputString.charAt(i));
			}
			else 
			{
				;
				if(brac_found==false)
				{
					out+=cTemp;
				}
				else
				{
					stack.push(cTemp);
				}
				
				
			}
			
		}
		return out;
		
	}
	
}
