package leetcode;

import java.util.List;
import java.util.ArrayList;

// @solution-sync:begin
class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        List<Integer> oldRow = new ArrayList<>();
        oldRow.add(1);
        res.add(oldRow);
        if(numRows == 1) return res;
        oldRow = new ArrayList<>();
        oldRow.add(1);
        oldRow.add(1);
        res.add(oldRow);
        if(numRows == 2) return res;
        for(int i = 3; i <= numRows; i++){
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for(int j = 1; j < oldRow.size(); j++){
                newRow.add(oldRow.get(j) + oldRow.get(j - 1));
            }
            newRow.add(1);
            res.add(newRow);
            oldRow = newRow;
        }
        return res;
    }
}