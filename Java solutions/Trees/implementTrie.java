import java.util.*;
class Trie {

    // We first create a class called TrieNode which represents each node in our Trie.
    // Any instance of this class will have 2 attributes: a map(dict) of character as
    // key and its TrieNode object as its value and a boolean isEnd which indicates
    // end of a word.

    class TrieNode {

        Map<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode()
        {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    TrieNode root;

    // In our initialization of Trie instance, we create a TrieNode object.

    public Trie() {
        this.root = new TrieNode();
    }

    // To implement insert, we start from our root node and for each character
    // in the given word check if that character is present in our current nodes
    // children.

    // If it is there, we move on to that node. If not present, we create a new 
    // trienode and add it to the children of current node. Then we go to that 
    // node and continue with next character in our word.

    // Once all characters are traversed i.e. we have reached the last node for this
    // word, we assign its isEnd to true to indicate this is an end of a word.
    
    public void insert(String word) {

        TrieNode cur = this.root;

        for(char c : word.toCharArray())
        {
            if(!cur.children.containsKey(c))
            {
                cur.children.put(c,new TrieNode());
            }

            cur = cur.children.get(c);
        }

        cur.isEnd = true;
        
    }

        
    // The basic way in which we traverse our Trie DS is similar in all 3 function
    // We keep on searching current character in children of current node and move to 
    // it if present. If it is not present, we know we do not have the required word
    // in our trie so we return false.

    // We also return false if the characters in the word to be searched are finished 
    // but we have not reached the end of a word present in our trie.
    
    public boolean search(String word) {

        TrieNode cur = this.root;

        for(char c : word.toCharArray())
        {
            if(!cur.children.containsKey(c))
            {
                return false;
            }

            cur = cur.children.get(c);
        }

        return cur.isEnd;
        
    }

    // This function is quite similar to search as we are just searching a prefix
    // and not the word itself. So if we have iterated over all characters in the prefix
    // word, we simply return True as there is not need to check if it is the end of 
    // a word or not. We simply check if the sequence of characters in prefix is present 
    // in our trie DS by traversing one node at a time.
        
    public boolean startsWith(String prefix) {

        TrieNode cur = this.root;

        for(char c: prefix.toCharArray())
        {
            if(!cur.children.containsKey(c))
            {
                return false;
            }

            cur = cur.children.get(c);
        }

        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */