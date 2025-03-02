class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while(matrix[x][y] != target){
            if(matrix[x][y] > target) y--;
            else x++;
            if(x >= m || y < 0) return false;
        }
        return true;
    }
}