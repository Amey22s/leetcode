class Solution:
    # To begin with, we initialize 3 values which will store our state of result.
    # Start index of max substring, end index of max substring and length of max
    # substring.

    sub_start = 0
    sub_end = 0
    max_sub_len =  0

    def longestPalindrome(self, s: str) -> str:

    # The main idea here is to iterate over each index in the given string 
    # and exapnded outwards from that index in both directions to get as far as possible
    # staying within bounds of the string as well as maintaining the condition for
    # palindrome i.e. char at left and right pointer should be same.

    # We have to check at each iteration, if every condition is satisfied, we compute 
    # current length of substring. If this length is greater than maxLen encountered till
    # now, we update maxLen, subStart and subEnd as this is now our answer to be returned.

    # One more important aspect is that we need to check for odd length palindrome as well
    # as even length palindrome which can be easily done by adjusting left and right ptr
    # accordingly.

        for i in range(len(s)):

            #For odd length palindromes.
            self.setSubstringParams(i,i,s)

            #For even length palindrome

            self.setSubstringParams(i,i+1,s)
            pass


    #Finally we return the longest palindromic substring with the help of subStart and subEnd.

        return s[self.sub_start:self.sub_end+1]


# This is a helper function to get longest palindromic substring with left and right pointers
# pointing to the mid (start) index from where we start to expand outward.

    def setSubstringParams(self, left: int, right: int, s: str):
        global max_sub_len

        while left >= 0 and right < len(s):
            if s[left] == s[right]:
                temp_len = right - left + 1
                if self.max_sub_len < temp_len:
                    self.max_sub_len = temp_len
                    self.sub_start = left
                    self.sub_end = right
                left -= 1
                right += 1
            else:
                break