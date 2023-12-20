package com.amit.javaPractise;

import java.util.ArrayList;
import java.util.List;
/*
Leetcode-63 : Unique Paths II

You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */
public class UniquePathWithObstacleII {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        int[][] arr = {{0,1}};
        System.out.println(uniquePathsWithObstacles(arr));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    cur.add(j, 0);
                } else if (i == 0 && j == 0) {
                    cur.add(j, 1);
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) {
                        up = pre.get(j);
                    }
                    if (j > 0) {
                        left = cur.get(j - 1);
                    }
                    cur.add(j, up + left);
                }
            }
            pre = cur;
        }
        return pre.get(m - 1);
    }
}