class Solution:
    def characterReplacement(self, s: str, k: int) -> int:

        # First we initialize a character map to store all uppercase alphabets
        # A = 0 and Z = 25. We also initialize a varialbe to store alphabet 
        # with max frequency.

        charMap = {}
        maxCharFreq = 0

        # Next we initialize a variable to store result and a variable to act as left
        # pointer.

        res = 0
        left = 0

        # The main idea here is that we use a variable sliding window with a condition
        # length of substring till now - max freq of a char in that substring <= k.

        # If the above condition is satisfied, we check current length of substring 
        # against our result so far and update it if needed.

        # If the condition is not met, we shrink our window by moving left pointer
        # and update our charMap accordingly.

        for right in range(len(s)):

            tempLen = right - left + 1

            if s[right] not in charMap:
                charMap[s[right]] = 1
            else:
                charMap[s[right]] += 1

            # MaxCharFreq is updated by comparing max freq till now and freq of newly 
            # added character in substring.

            # Even if max freq of a char has decreased after moving the left pointer,
            # we won't update it because decreasing the maxCharFreq will only cause
            # the below condition to be false and hence our result is not going to get
            # updated in those cases.

            # Here we are overestimating the maxCharFreq and it works because at some 
            # point in our calculations this max freq was valid and gave us the answer
            # we have now. Now if we want a higher result(higher length of substring),
            # it can happen only if max freq remains same or increases. A decrease in maxFreq
            # is not going to help our cause.

            maxCharFreq = max(maxCharFreq, charMap[s[right]])
            if tempLen - maxCharFreq <= k:
                res = max(res,tempLen)
            else:
                charMap[s[left]] -= 1
                left += 1

        # Finally we return the longest repeating character replacement using res. 

        return res