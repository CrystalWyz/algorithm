package leetcode;

class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()==1)return true;
        int n = s.length();
        int[] mapS=new int[128];//记录出现位置
        int[] mapT=new int[128];//记录出现位置
        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
        for (int i = 0; i < n; i++) {
            if(mapS[sChars[i]]!=mapT[tChars[i]])//当前的映射值是否相同
                return false;
            else if(mapS[sChars[i]]==0){//如果没有出现过，加入数据
                mapS[sChars[i]]=i+1;
                mapT[tChars[i]]=i+1;
            }
        }
        return true;
    }
}