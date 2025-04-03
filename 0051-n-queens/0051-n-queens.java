class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //creating an empty chess board
        List<String> board = new ArrayList<>();
        for(int i = 0; i<n; i++){
            StringBuilder row = new StringBuilder();
            for(int j = 0; j<n; j++){
                row.append('.');
            }
            board.add(row.toString());
        }
        sol(board, 0);
        return res;
    }
    public void sol(List<String> board, int row){
        //Goal state
        if(row == board.size()){
            res.add(new ArrayList<>(board));
            return;
        }

        //Exploration state
        for(int i= 0; i<board.size(); i++){
            if(isvalid(board, row, i)){
                //Action state
                StringBuilder r = new StringBuilder(board.get(row));
                r.setCharAt(i, 'Q');

                board.set(row, r.toString());

                //recursion for the next row
                sol(board, row + 1);

                //Backtracking
                r.setCharAt(i, '.');
                board.set(row, r.toString());

            }
        }
    }
        private boolean isvalid(List<String> board, int row, int col) {
        // straight up
        for (int i = row; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        
        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        
        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
