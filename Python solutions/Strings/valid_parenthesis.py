class Solution:
    def isValid(self, s: str) -> bool:
        #  For this problem, we use stack data structure. 
        # So we initialize a stack. 

        st = []

        # Then we initialize a map to get a guide on what parenthesis set are valid.

        pMap = {'}':'{',']':'[',')':'('}

        # Main idea here is to check each character in the given string.
        # If it is a open brace, we just push it to the stack.

        # If it is a closed brace, we first check if stack is already empty.
        # If it is empty, we don't have an open brace for this closed brace,
        # so return false.

        # If stack is not empty, we pop the top most element from stack,
        # and compare it with value corresponding to closed brace key in brace map.
        # If both of them are not same, there is a mismatch so return false. 

        for c in s:
            if c in pMap:
                if len(st) == 0:
                    return False
                x = st.pop()
                if pMap[c] != x:
                    return False
            else:
                st.append(c)

        # Finally, check if stack is empty, if yes return true else return false.

        return True if len(st) == 0 else False