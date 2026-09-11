class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (ch != ')') {
                stack.push(ch);
            } else {
                StringBuilder str = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    str.append(stack.peek());
                    stack.pop();
                }
                if (stack.peek() == '(') {
                    stack.pop();
                }
                for (char ch1: str.toString().toCharArray()) {
                    stack.push(ch1);
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < stack.size(); i++) {
            answer.append(stack.get(i));
        }

        return answer.toString();
    }
}