package codesignal;
public class AreEquallyStrong
{
    boolean solution(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
    
        int yourMax=yourLeft>=yourRight?yourLeft:yourRight;
        int frinedMax=friendsLeft>=friendsRight?friendsLeft:friendsRight;
        int yourMin=yourLeft<=yourRight?yourLeft:yourRight;
        int frinedMin=friendsLeft<=friendsRight?friendsLeft:friendsRight;
        
    return yourMax==frinedMax && yourMin==frinedMin;
    }
}