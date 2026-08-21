class Solution {
    public int countDigits(int num) {
        int count = 0;
        int number = num;
        while(number > 0){
            if(num % (number % 10) == 0){
                count++;
            }
            number /= 10;
        }

        return count;
    }
}