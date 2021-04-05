package matrix;

import java.util.*;

public class MaxAreaOfIsland {

    /**
     * Mysolution
     * 执行用时：
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 8.30%
     * 的用户
     * 内存消耗：
     * 39 MB
     * , 在所有 Java 提交中击败了
     * 79.69%
     * 的用户
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {

        int maxIslands = 0;

        int foundIslands = 0;
        Map<Integer, List<List<Integer>>> islandsCoordinatesMap = new HashMap<>();

        List<Integer> islands = new ArrayList<>();

        int rows = grid.length;

        if(rows <1) return 0;
        int cols = grid[0].length;

        for(int i= 0; i<rows; i++) {
            for(int j= 0; j<cols; j++) {

                if(grid[i][j] >0) {
                    //check whetehr is belong to new island
                    boolean upConnected = false, leftConnected = false;

                    if(i>0 && grid[i-1][j] >0) {
                        upConnected = true;
                    }

                    if(j>0 && grid[i][j-1] >0) {
                        leftConnected = true;
                    }

                    if(upConnected && !leftConnected) {
                        // return upIslandNum
                        grid[i][j] = grid[i-1][j];
                        this.addIslandMember(islandsCoordinatesMap, grid[i][j], i, j);
//            return grid[i-1][j];
                    } else if(!upConnected &&leftConnected) {
                        grid[i][j] = grid[i][j-1];
                        this.addIslandMember(islandsCoordinatesMap, grid[i][j], i, j);
                    } else if(!upConnected && !leftConnected) {

                        grid[i][j] = ++foundIslands;
                        this.addIslandMember(islandsCoordinatesMap, grid[i][j], i, j);
                    } else {
                        // merge island
                        int islandNum = Math.min(grid[i-1][j], grid[i][j-1]);
                        grid[i][j] = islandNum;
                        this.addIslandMember(islandsCoordinatesMap, grid[i][j], i, j);

                        if(grid[i-1][j] != islandNum) {
                            this.resetIslandFlag(grid,islandsCoordinatesMap,grid[i-1][j], islandNum );
                        } else if(grid[i][j-1] != islandNum) {
                            this.resetIslandFlag(grid, islandsCoordinatesMap,grid[i][j-1], islandNum );
                        }
                    }

                    if(islandsCoordinatesMap.get(grid[i][j]).size() > maxIslands) {
                        maxIslands = islandsCoordinatesMap.get(grid[i][j]).size();
                    }

                }



            }
        }

        return maxIslands;
    }

    /**
     * official solution one
     * @param grid
     * @return
     */
    public int maxAreaOfIsland1(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = cur_i + di[index], next_j = cur_j + dj[index];
            ans += dfs(grid, next_i, next_j);
        }
        return ans;
    }



    private void addIslandMember(Map<Integer, List<List<Integer>>> islandsCoordinatesMap, int islandNum, int i, int j) {
        if(islandsCoordinatesMap.containsKey(islandNum)) {
            islandsCoordinatesMap.get(islandNum).add(Arrays.asList(i, j));
        } else {
            List<List<Integer>> entry = new ArrayList<>();
            entry.add(Arrays.asList(i,j));
            islandsCoordinatesMap.put(islandNum, entry);
        }
    }

    private void resetIslandFlag(int[][] grid, Map<Integer, List<List<Integer>>> islandsCoordinatesMap, int islandNum, int newIslandNum) {
        List<List<Integer>> isLandMembers = islandsCoordinatesMap.get(islandNum);

        for(List<Integer> member : isLandMembers) {
            grid[member.get(0)][ member.get(1)] = newIslandNum;
            islandsCoordinatesMap.get(newIslandNum).add(Arrays.asList(member.get(0), member.get(1)));

        }
        islandsCoordinatesMap.remove(islandNum);

    }


    public static void main(String[] args) {

        MaxAreaOfIsland runClass = new MaxAreaOfIsland();

        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int result = runClass.maxAreaOfIsland(grid);
        System.out.println(String.format("result is: %d", result));

    }
}
