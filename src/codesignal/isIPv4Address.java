/*
 * An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a computer network that uses the Internet Protocol for communication. There are two versions of the Internet protocol, and thus two versions of addresses. One of them is the IPv4 address.

Given a string, find out if it satisfies the IPv4 address naming rules.

Example

    For inputString = "172.16.254.1", the output should be
    solution(inputString) = true;

    For inputString = "172.316.254.1", the output should be
    solution(inputString) = false.

    316 is not in range [0, 255].

    For inputString = ".254.255.0", the output should be
    solution(inputString) = false.

    There is no first number.

 * 
 * 
 * 
 * 
 */
package codesignal;
public class isIPv4Address
{
    boolean solution(String inputString) {

        String arr[]=inputString.split("\\.");
        System.out.println("len: "+arr.length);
        if(arr.length!=4){
            return false;
        }
        boolean out=false;
        for(int i=0;i<4;i++)
        { 
            if(arr[i].matches("[0-9]+")&&!arr[i].matches("0[0-9]+")&&arr[i].length()<=3&&Integer.parseInt(arr[i])>=0 && Integer.parseInt(arr[i])<=255)
            {
                System.out.println("True: "+arr[i]);
                out=true;
            }
            else{
                 System.out.println("False: "+arr[i]);
                out=false;
                break;
            }
        
            
        }
        return out;
        
        }
}