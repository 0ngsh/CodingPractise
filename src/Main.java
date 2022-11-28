import java.util.List;


public class Main {
	
	public static void main(String[] args)
	{
		CodingPractise codePractise=new CodingPractise();
		//codePractise.personOws();
		//System.out.println(codePractise.reverseInParentheses1("foo(bar(baz))blim"));
		int arr[]={16, 17, 4, 3, 5, 2};
	//codePractise.checkLeader(arr);
      //  int arr[]={1,2};
		//System.out.println(codePractise.findMssingElement(arr, 3));
		//int arr1[]={1,10,13};
		//int arr2[]={10,1,13};
		//System.out.println(new AreSimilar().solution(arr1, arr2));

		/*String[] inp={"eat","tea","tan","ate","nat","bat"};

    List<List<String>> sol=codePractise.GroupAnagram(inp);
   
    for(int i=0;i<sol.size();i++)
    {
        System.out.println("-----");
        for(int j=0;j<sol.get(i).size();j++)
        {
           System.out.println(sol.get(i).get(j));
          
        }
    }*/

	//codePractise.splitter("প্ৰকল্পৰ সবিশেষ | প্ৰকাশকৰ একাষাৰ | কৰ্মদল | সহায়", "\\s*\\|\\s*");
	//System.out.println(codePractise.longestSubstrDistinctChars("geeksforgeeks"));
  int[] inp2={1, 9, 3, 10, 4, 20, 2};
codePractise.findLengthOfLongestConsecutiveSubsequence(inp2);

	

	}
	
	

}
