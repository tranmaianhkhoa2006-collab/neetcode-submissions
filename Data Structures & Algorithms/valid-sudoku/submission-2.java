class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!((Character.isDigit(board[i][j]) && board[i][j] != '0') || board[i][j] == '.'))
                    return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            int[] number = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int index = board[i][j] - '1';
                number[index]++;
            }

            for (int k = 0; k < 9; k++) {
                if (number[k] > 1)
                    return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            int[] number = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;

                int index = board[j][i] - '1';
                number[index]++;
            }

            for (int k = 0; k < 9; k++) {
                if (number[k] > 1)
                    return false;
            }
        }

        int begin = 1;
        int endRow = 3;
        int endCol = 3;

        for (int block = 1; block <= 9; block++) {
            if (block >= 7) {
                
                begin = 7;
                endRow = 9;
                endCol = 3;
            } else if (block >= 4) {
                begin = 4;
                endRow = 6;
                endCol = 3;
            } else
                begin = 1;

            int[] number = new int[9];
            for (int row = begin - 1; row < endRow; row++) {
                for (int col = endCol - 3; col < endCol; col++) {
                    if (board[row][col] == '.')
                        continue;

                    int index = board[row][col] - '1';
                    number[index]++;
                }
            }

            for (int k = 0; k < 9; k++) {
                if (number[k] > 1)
                    return false;
            }

    
            endCol+=3;
        }

        return true;
    }
}
