class Solution:
    def longestValidParentheses(self, s: str) -> int:
        longest_valid_parenthesis, st = 0, []
        st.append(-1)
        for i in range(len(s)):
            if s[i] == '(':
                st.append(i)
            else:
                st.pop(len(st) - 1)
                if len(st):
                    longest_valid_parenthesis = max(longest_valid_parenthesis, i - st[-1])
                else:
                    st.append(i)
        return longest_valid_parenthesis
