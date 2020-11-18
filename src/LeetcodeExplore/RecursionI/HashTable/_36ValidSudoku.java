package LeetcodeExplore.RecursionI.HashTable;
//https://leetcode.com/problems/valid-sudoku/

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.*;

public class _36ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {

        Map<String, List<Character>> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                String key = String.valueOf(i / 3) + String.valueOf(j / 3);
                String keyrow = "row" + String.valueOf(i);
                String keycol = "col" + String.valueOf(j);
                if (board[i][j] != '.') {
                    if (map.containsKey(key)) {
                        List<Character> list = map.get(key);
                        if (list.contains(board[i][j])) {
                            return false;
                        } else {
                            list.add(board[i][j]);
                        }
                    } else {
                        map.put(key, new ArrayList<Character>());
                        map.get(key).add(board[i][j]);

                    }
                    if (map.containsKey(keyrow)) {
                        List<Character> list = map.get(keyrow);
                        if (list.contains(board[i][j])) {
                            return false;
                        } else {
                            list.add(board[i][j]);
                        }
                    } else {
                        map.put(keyrow, new ArrayList<Character>());
                        map.get(keyrow).add(board[i][j]);

                    }
                    if (map.containsKey(keycol)) {
                        List<Character> list = map.get(keycol);
                        if (list.contains(board[i][j])) {
                            return false;
                        } else {
                            list.add(board[i][j]);
                        }
                    } else {
                        map.put(keycol, new ArrayList<Character>());
                        map.get(keycol).add(board[i][j]);

                    }
                }
            }
        }
        return true;
    }


    public boolean isValidSudoku2(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }
}
