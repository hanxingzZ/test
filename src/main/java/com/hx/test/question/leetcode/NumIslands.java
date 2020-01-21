package com.hx.test.question.leetcode;

/**
 * 
 * @description: 给定一个由 '1'（陆地）和
 *               '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的
 *               。你可以假设网格的四个边均被水包围。
 * 
 *               示例 1:
 * 
 *               输入: 11110 11010 11000 00000
 * 
 *               输出: 1
 * 
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月19日 下午5:06:09
 * @version 1.0
 */
public class NumIslands {

	private int rows;

	private int cows;

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		rows = grid.length;
		cows = grid[0].length;
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cows; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}

		return count;
	}

	private void dfs(char[][] grid, int r, int c) {
		if (r < 0 || c < 0 || r >= rows || c >= cows || grid[r][c] == '0') {
			return;
		}
		grid[r][c] = '0';
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);
		dfs(grid, r - 1, c);
		dfs(grid, r + 1, c);
	}

	public static void main(String[] args) {
		NumIslands n = new NumIslands();
		char[][] arr = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(n.numIslands(arr));

	}

}
