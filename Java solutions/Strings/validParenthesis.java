import java.util.*;;
class Solution {
    public boolean isValid(String s) {

        // For this problem, we use stack data structure. 
        // So we initialize a stack. 

        Stack<Character> st = new Stack<>();

        // Then we initialize a map to get a guide on what parenthesis set are valid.

        Map<Character,Character> pMap = new HashMap<>();
        pMap.put('}','{');
        pMap.put(']','[');
        pMap.put(')','(');

        // Main idea here is to check each character in the given string.
        // If it is a open brace, we just push it to the stack.

        // If it is a closed brace, we first check if stack is already empty.
        // If it is empty, we don't have an open brace for this closed brace,
        // so return false.
        
        // If stack is not empty, we pop the top most element from stack,
        // and compare it with value corresponding to closed brace key in brace map.
        // If both of them are not same, there is a mismatch so return false. 

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if(pMap.containsKey(c))
            {
                if(st.isEmpty())
                    return false;

                char x = st.pop();
                if(pMap.get(c) != x)
                {
                    return false;
                }
            }
            else
            {
                st.add(c);
            }
        }

        // Finally, check if stack is empty, if yes return true else return false.

        return st.isEmpty();
        
    }
}