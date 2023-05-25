import java.util.*;
class Solution {

    class TrieNode {

        TrieNode[] children;
        boolean isEnd;

        public TrieNode()
        {
            this.children =  new TrieNode[26];
            this.isEnd = false;
        }

        void addWord(String word)
        {
            TrieNode cur = this;
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

}


    boolean[][] visited;
    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();
        visited = new boolean[board.length][board[0].length];

        int ROWS = board.length;
        int COLS = board[0].length;

        for(String word : words)
        {
            root.addWord(word);
        }

        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
                dfs(i,j,root,"",board);
            }
        }

        return new ArrayList<>(res);
        
    }

    private void dfs(int r, int c, TrieNode root, String str, char[][] board)
    {
        if(r < 0 || c < 0 || r == board.length || c == board[0].length)
        {
            return;
        }

        if(visited[r][c] || root.children[board[r][c] - 'a'] == null)
        {
            return;
        }

        visited[r][c] = true;

        str += board[r][c];
        root = root.children[board[r][c] - 'a'];

        if(root.isEnd)
        {
            res.add(str);
            root.isEnd = false;
        }

        dfs(r+1,c,root,str,board);
        dfs(r-1,c,root,str,board);
        dfs(r,c+1,root,str,board);
        dfs(r,c-1,root,str,board);

        visited[r][c] = false;
    }

}