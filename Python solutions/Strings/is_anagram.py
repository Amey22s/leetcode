class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #  First we check lengths of 2 strings, if not equal it cannot be
        # anagram so return false.

        if len(s) != len(t):
            return False

        # Now we initialize a charMap to store freq of each character in 
        # given strings.

        charMap = [0] * 26

        # Main idea is to iterate over all indices of string one at a time.

        # At each index, convert each character from both strings to an index
        # by subtracting 'a' to scale it to one of the 26 index in charMap.

        # Then for each char index in s string, we increment value by 1
        # at that index in charMap whereas we decrement value by 1 at the same
        # index in charMap.

        for i in range(len(s)):
            sIdx = ord(s[i]) - ord('a')
            tIdx = ord(t[i]) - ord('a')

            charMap[sIdx] += 1
            charMap[tIdx] -= 1

        # Now just check if values at all index is 0. If not return false.
        # Finally return true if we reach this far as we have check all false conditions.

        return True if charMap == [0] * 26 else False
