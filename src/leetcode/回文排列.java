package leetcode;

class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        char[] sOfCharArray = s.toCharArray();
        int[] res = new int[256];
        for(char c : sOfCharArray){
            res[c]++;
        }
        boolean flag = true;
        for(int num : res){
            if(num % 2 != 0){
                if(flag){
                    flag = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}