class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode()
        {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {

        TrieNode cur = this.root;

        for(char c : word.toCharArray())
        {
            if(cur.children[c-'a'] == null)
            {
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }

        cur.isEnd = true;
    }
    
    public boolean search(String word) {

        TrieNode node = root;
        return dfs(0, word.toCharArray(), node);
    }

    private boolean dfs(int idx, char[] word, TrieNode cur)
    {
        for(int i = idx; i < word.length; i++)
        {
            if(word[i] == '.')
            {
                for(TrieNode temp: cur.children)
                {
                    if(temp != null && dfs(i+1, word, temp))
                    {
                        return true;
                    }
                }
                return false;
            }
            else
            {
                if(cur.children[word[i]-'a'] == null)
                {
                    return false;
                }
                cur = cur.children[word[i]-'a'];
            }
        }

        return cur.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */