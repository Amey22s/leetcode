class Solution:
    def isPalindrome(self, s: str) -> bool:

        #  We are using 2 pointer approach so initialize 
        # left pointer to 0 and right pointer to str length - 1.
        
        left = 0
        right = len(s) - 1

        # Main idea is to start from extreme ends and keep moving inwards till 
        # we don't get valid (alphanumeric) characters at both pointer indexes.

        # We check whether these two valid values are equal, if yes we move both
        # pointers inward by 1. Else we return false. 

        while left < right:

            while (left < right) and (not self.isAlphaNumeric(s[left])):
                left += 1

            while (left < right) and (not self.isAlphaNumeric(s[right])):
                right -= 1

            # We convert both valid character to lowercase as case doesn't matter in this problem.

            leftChar = s[left].lower()
            rightChar = s[right].lower()

            if leftChar != rightChar:
                return False
            else:
                left += 1
                right -= 1

        return True

# A function which checks whether a character is alphanumeric or not.

    def isAlphaNumeric(self, c: str) -> bool:
        return (c >= 'A' and c <= 'Z') or (c >= 'a' and c <= 'z') or (c >= '0' and c <= '9')