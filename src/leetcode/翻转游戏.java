package leetcode;

import java.util.List;
import java.util.ArrayList;

// @solution-sync:begin
class GeneratePossibleNextMoves {
    public List<String> generatePossibleNextMoves(String s) {
        char[] sOfCharArray = s.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < sOfCharArray.length - 1; i++){
            if(sOfCharArray[i] == '+'){
                if(sOfCharArray[i + 1] == '+'){
                    sOfCharArray[i] = '-';
                    sOfCharArray[i + 1] = '-';
                    res.add(String.valueOf(sOfCharArray));
                    sOfCharArray[i] = '+';
                    sOfCharArray[i + 1] = '+';
                }
            }
        }
        return res;
    }
}