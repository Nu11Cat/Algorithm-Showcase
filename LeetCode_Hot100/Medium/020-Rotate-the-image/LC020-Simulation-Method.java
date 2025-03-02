class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l=0,r=n-1,t=0,b=n-1;
        while(l<r && t<b){
            for(int i= 0 ;i<r-l ; i++){
                int temp = matrix[t][l+i];
                matrix[t][l+i]=matrix[b-i][l];
                matrix[b-i][l]=matrix[b][r-i];
                matrix[b][r-i]=matrix[t+i][r];
                matrix[t+i][r]=temp;
            }
            l++;r--;t++;b--;
        }
    }
}