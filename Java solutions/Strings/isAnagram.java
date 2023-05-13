class Solution {
    public boolean isAnagram(String s, String t) {

        // First we check lengths of 2 strings, if not equal it cannot be
        // anagram so return false.

        if(s.length() != t.length())
            return false;

        // Now we initialize a charMap to store freq of each character in 
        // given strings.

        int[] charMap = new int[26];

        // Main idea is to iterate over all indices of string one at a time.

        // At each index, convert each character from both strings to an index
        // by subtracting 'a' to scale it to one of the 26 index in charMap.

        // Then for each char index in s string, we increment value by 1
        // at that index in charMap whereas we decrement value by 1 at the same
        // index in charMap.

        for(int i = 0; i < s.length(); i++)
        {
            int sIdx = s.charAt(i) - 'a';
            int tIdx = t.charAt(i) - 'a';

            charMap[sIdx]++;
            charMap[tIdx]--;
        }

        // Now just check if values at all index is 0. If not return false.

        for(int i = 0; i < 26; i++)
        {
            if(charMap[i] != 0)
                return false;
        }

        // Finally return true if we reach this far as we have check all false conditions.
        return true;
        
    }
}