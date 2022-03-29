package leetcode;

import java.util.LinkedList;

class IsValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if ((chars.length & 1) == 1){
            return false;
        }
        
        LinkedList<Character> stack = new LinkedList<>();
        int size = 0;
        for (char c : chars) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    size++;
                    break;

                case ')':
                    if (size == 0 || stack.pop() != '(') {
                        return false;
                    }
                    size--;
                    break;
                case ']':
                    if (size == 0 || stack.pop() != '[') {
                        return false;
                    }
                    size--;
                    break;
                case '}':
                    if (size == 0 || stack.pop() != '{') {
                        return false;
                    }
                    size--;
                    break;
            }
        }
        return stack.size() <= 0;
    }

}