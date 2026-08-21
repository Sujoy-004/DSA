class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int last = s.length() - 1;

        while(start <= last){
            char currStart = s.charAt(start);
            char currLast = s.charAt(last);
            if(!Character.isLetterOrDigit(currStart)){
                start++;
            }else if(!Character.isLetterOrDigit(currLast)){
                last--;
            }else{
                if(Character.toLowerCase(currStart) != Character.toLowerCase(currLast)){
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}