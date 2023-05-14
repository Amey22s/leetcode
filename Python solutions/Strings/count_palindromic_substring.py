class Solution:

    # To begin with, we initialize subCount which will store our result.
    
    sub_count = 0

    def countSubstrings(self, s: str) -> int:

        # The main idea here is to iterate over each index in the given string 
        # and exapnded outwards from that index in both directions to get as far as possible
        # staying within bounds of the string as well as maintaining the condition for
        # palindrome i.e. char at left and right pointer should be same.

        # We have to check at each iteration, if every condition is satisfied, we increase 
        # subCount by 1.

        # One more important aspect is that we need to check for odd length palindrome as well
        # as even length palindrome which can be easily done by adjusting left and right ptr
        # accordingly.
        
        for i in range(len(s)):
            # For odd palindromes
            self.updateSubCount(i,i,s)

            # For even palindromes
            self.updateSubCount(i,i+1,s)

        return self.sub_count



# This is a helper function to check for all conditions with left and right pointers
# pointing to the mid (start) index from where we start to expand outward. It also updates
# the class variable subCount which stores the result.

    def updateSubCount(self, left: int, right: int, s: str):
        while left >= 0 and right < len(s):
            if s[left] == s[right]:
                self.sub_count += 1
                left -= 1
                right += 1
            else:
                break