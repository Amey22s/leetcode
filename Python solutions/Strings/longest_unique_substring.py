class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #  We initialize a set to keep a record of all the characters present in
        #  our current maxsubstring.

        charSet = set()

        #  We are using two pointer approach here. So initialize left pointer to 0.
        #  Also intialize the result as maxSubstring to 0.

        left = 0
        maxSubstring = 0

        # We will use a for loop to move our second pointer(right) one step at a time.
        for right in range(len(s)):

            #  Create a temp char variable to store current character pointed by right pointer.
            charRight = s[right]

            #  If the character in present in the current substring set, we won't be able to add
            #  it immediately. So we first move left pointer forward till the current char
            #  is not removed from substring and then add the curret character.

            #  If the current character is not present in the set, we simply add it to the set
            #  and calculate current substring length. If current substring length is greater 
            #  maxSubstring we update it.

            while charRight in charSet:
                charSet.remove(s[left])
                left += 1
            
            charSet.add(charRight)

            maxSubstring = max(maxSubstring,right-left+1)


        # Finally we return maxSubstring.

        return maxSubstring;