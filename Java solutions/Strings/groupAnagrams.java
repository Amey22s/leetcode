import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // First we initialize a result list of list of strings.
        // We also create a init list and add the first element to it and add this
        // list to our result to begin with.

        List<List<String>> res = new ArrayList<>();
        List<String> init = new ArrayList<>();
        init.add(strs[0]);
        res.add(init);

        // The main idea here is we compare current element in given array of strings
        // with first element of each list in our result list of lists.

        // We check if these two strings are anagrams, if yes we have found a list in which
        // the current element belongs. So we add it to that list.

        // If we don't find an anagram match for our current string anywhere in our result,
        // we create a new list and add the current element to this new list and add this new
        // list to our result.

        for(int i = 1; i < strs.length; i++)
        {
            boolean anagramFound = false; 
            for(int j = 0; j < res.size(); j++)
            {
                if(isAnagram(strs[i],res.get(j).get(0)))
                {
                    res.get(j).add(strs[i]);
                    anagramFound = true;
                    break;
                }
            }

            if(!anagramFound)
            {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                res.add(temp);
            }

        }

        // Finally we return our list of list of strings using res.

        return res;

}

// This is a helper function to check if 2 strings are anagrams or not.

private boolean isAnagram(String s, String t)
{
    if(s.length() != t.length())
        return false;

    int[] charMap = new int[26];

    for(int i = 0; i < s.length(); i++)
    {
        charMap[s.charAt(i) - 'a']++;
        charMap[t.charAt(i) - 'a']--;
    }

    for(int i : charMap)
    {
        if(i != 0)
            return false;
    }

    return true;
}
}