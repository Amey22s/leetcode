class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()
        

    def addWord(self, word: str) -> None:

        cur = self.root

        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        
        cur.isEnd = True
        

    def search(self, word: str) -> bool:

        node = self.root

        def dfs(j, word, cur) -> bool:

            for i in range(j,len(word)):

                if word[i] == '.':
                    for temp in cur.children:

                        if dfs(i+1,word,cur.children[temp]):
                            return True
                    return False
                else:
                    if word[i] not in cur.children:
                        return False
                    cur = cur.children[word[i]]
            
            return cur.isEnd
        
        return dfs(0,word,node)
        
        

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)