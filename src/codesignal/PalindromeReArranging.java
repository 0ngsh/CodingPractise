import java.util.Arrays;

/**
 * Given a string, find out if its characters can be rearranged to form a palindrome.

Example

For inputString = "aabb", the output should be
solution(inputString) = true.

We can rearrange "aabb" to make "abba", which is a palindrome.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string inputString

    A string consisting of lowercase English letters.

    Guaranteed constraints:
    1 ≤ inputString.length ≤ 50.

    [output] boolean

    true if the characters of the inputString can be rearranged to form a palindrome, false otherwise.

 */
package codesignal;
 public class PalindromeReArranging
 {

    public boolean solution(String inputString) {
        int count[]=new int[256];
        Arrays.fill(count, 0);
        for(int i=0;i<inputString.length();i++)
        {
            count[(int)inputString.charAt(i)]++;
        }
        int oddCount=0;
        for(int i=0;i<256;i++)
        {
            if(count[i]%2!=0)
            {
                oddCount++;
            }
            if(oddCount>1)
            {
                return false;
            }
        }
        
        
        
        return true;
        




    }
 }