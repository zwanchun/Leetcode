/*Compare Version Numbers
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
       String[] vnum1=version1.split("\\.");
       String[] vnum2=version2.split("\\.");
       int i=0;
       for(;i<Math.min(vnum1.length,vnum2.length);i++){
           int v1=0, v2=0;
           for(int j=0;j<vnum1[i].length();j++){
               char c=vnum1[i].charAt(j);
               v1=v1*10+c-'0';
           }
           for(int j=0;j<vnum2[i].length();j++){
               char c=vnum2[i].charAt(j);
               v2=v2*10+c-'0';
           }
           if(v1>v2) return 1;
           else if(v2>v1) return -1;
           else continue;
           
       }
       if(vnum1.length>vnum2.length){
           if(isZero(vnum1,i)) return 0;
           else return 1;
       }
       else if(vnum2.length>vnum1.length){
           if(isZero(vnum2,i)) return 0;
           else return -1;
       }
       else return 0;
    }
    
    private boolean isZero(String[] nums, int i){
        for(int j=i;j<nums.length;j++){
            int n=0;
            for(int k=0;k<nums[j].length();k++){
               char c=nums[j].charAt(k);
               n=n*10+c-'0';
               if(n!=0) return false;
           }
            
        }
        return true;
    }
}
