import java.util.HashMap;

public class a36_isValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = (int) c;
                    int boxex_index = (i / 3) * 3 + j / 3;

                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    cols[j].put(num, cols[j].getOrDefault(num, 0) + 1);
                    boxes[boxex_index].put(num, boxes[boxex_index].getOrDefault(num, 0) + 1);

                    if (rows[i].get(num) > 1 || cols[j].get(num) > 1 || boxes[boxex_index].get(num) > 1)
                        return false;

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        a36_isValidSudoku a36 = new a36_isValidSudoku();
        char[][] board =   {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean is = a36.isValidSudoku(board);
        System.out.println(is);
    }
}

