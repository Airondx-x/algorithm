public class a37_solveSudoku {

    int n = 3;
    int N = n * n;

//    用数组记录 数字出现的次数  1维是行，2维是列
    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    public boolean couldPlace(int d, int row, int col) {
//    判断d有无出现过，可填否
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
//        填数、计数
        int idx = (row / n) * n + col / n;
        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char) (d + '0');
    }

    public void removeNumber(int d, int row, int col) {
//        回溯
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public void placeNextNumbers(int row, int col) {
//      2、如果最后一格，读数结束
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        } else {
//       2、非最后一格，普通换行继续读
            if (col == N - 1) backtrack(row + 1, 0);
//            或者换列继续读
            else backtrack(row, col + 1);
        }
    }

    public void backtrack(int row, int col) {
//        没有数，需要自己填
        if (board[row][col] == '.') {
//            1-9依次填数
            for (int d = 1; d < 10; d++) {
//                3、判断d是否可填
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
//                    4、到这里的时候，是递归backtrack停止的结果，也就是d取1-9都不行，（但也有可能是正常结束，因为全部数弄完了），就需要回溯了
//                    如果是sudosolved=true已得到结果,则不会回溯，所以rows，cols，boxes的数据都不变，都已存着完整数独的结果，所以后续到line57的递归，每次都进不去
//                    因为数已经填好了，也就是每个数都被用过了，一直空循环跳出递归直到第一个数，结束
                    if (!sudokuSolved)
                        removeNumber(d, row, col);
                }
            }
        }
//        已有数的下一个
        else placeNextNumbers(row, col);
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

//        1、读入已有数字
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }


    public static void main(String[] args) {
        a37_solveSudoku a37 = new a37_solveSudoku();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        a37.solveSudoku(board);

        for (char[] a:board) {
            for (char b:a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }



}
