package leetcode;

class ShortestDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = wordsDict.length;
        int w1 = -1;
        int w2 = -1;
        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                w1 = i;
            }else if(wordsDict[i].equals(word2)){
                w2 = i;
            }
            if(w1 != -1 && w2 != -1){
                min = Math.min(min,Math.abs(w2 - w1));
            }
        }
        return min;
    }
}