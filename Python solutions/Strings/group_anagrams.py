from ast import List
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        # First we initialize a map to hold all possible combination of character as key
        # and their anagrams as its value in form of a list.

        str_map = {}

        # Main idea here is that we will iterate over all elements in given array.
        # In each iteration, sort the current element and convert it to a tuple of characters.
        # Check if this tuple is already present in our map as a key.

        # If it is present, we simply append current string to the list of string we get from
        # value of that key.

        # If this tuple is not present as a key in our map, we current this new entry and perform
        # the above step.

        for str in strs:
            temp_str = tuple(sorted(str))
            if temp_str not in str_map:
                str_map[temp_str] = []
            str_map[temp_str].append(str)

        # Finally we return list of all the list in the value part of our map.
        return list(str_map.values())