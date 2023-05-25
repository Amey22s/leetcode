from ast import List
class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False
    
    def addWord(self,word):
        cur = self
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.isEnd = True
    
    def delWord(self,word):

        cur = self
        nodeStack = []

        for c in word:
            if c in cur.children:
                nodeStack.append(cur)
                cur = cur.children[c]
        cur.isEnd = False

        for node, ch in reversed(list(zip(nodeStack,word))):
            if ch not in node.children:
                return
                
            if len(node.children[ch].children) > 0:
                return
            else:
                del node.children[ch]



class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:

        root = TrieNode()
        ROWS, COLS = len(board), len(board[0])
        visited, res  = set(), set()

        for word in words:
            root.addWord(word)

        def dfs(r,c,node,str):

            if r < 0 or c < 0 or r == ROWS or c == COLS:
                return
            
            if (r,c) in visited or board[r][c] not in node.children:
                return

            visited.add((r,c))


            str += board[r][c]
            node = node.children[board[r][c]]

            if node.isEnd:
                res.add(str)
                root.delWord(str)

            dfs(r+1,c,node,str)
            dfs(r-1,c,node,str)
            dfs(r,c+1,node,str)
            dfs(r,c-1,node,str)

            visited.remove((r,c))

        
        for r in range(ROWS):
            for c in range(COLS):
                dfs(r,c,root,"")
        return res