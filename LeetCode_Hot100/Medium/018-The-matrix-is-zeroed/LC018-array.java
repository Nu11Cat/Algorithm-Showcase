class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] h = new boolean[matrix.length];
        boolean[] l = new boolean[matrix[0].length];
        for(int i = 0 ; i < matrix.length;i++){
            for(int j = 0 ; j < matrix[0].length;j++){
                if(matrix[i][j]==0) h[i]=l[j]=true;

            }
        }
        for(int i = 0 ; i < matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(h[i]==true || l[j]==true) matrix[i][j]=0;
            }
        }
    }
}