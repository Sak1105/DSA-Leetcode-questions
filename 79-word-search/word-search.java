class Solution {
    private boolean isExists(char[] words, int i,int j,int idx,char[][] board){
        
        if( i<0 || idx>=words.length || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=words[idx] ){
            return false;
        }
        if(idx==words.length-1){
            return true;
        }
        char ch=board[i][j];
        board[i][j]='*';
        boolean res=isExists(words,i,j+1,idx+1,board)||
    isExists(words,i,j-1,idx+1,board)||
        isExists(words,i-1,j,idx+1,board)||
        isExists(words,i+1,j,idx+1,board);
        board[i][j]=ch;
        return res;
        

    }
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==words[0] && isExists(words,i,j,0,board)){
                    return true;
                }
            }
        }
        return false;
        
    }
}