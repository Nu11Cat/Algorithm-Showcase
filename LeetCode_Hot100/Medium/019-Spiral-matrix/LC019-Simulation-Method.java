class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length,n=matrix[0].length;
        if(matrix==null || m ==0 || n==0) return list;
        int l=0,r=n-1;
        int t=0,b=m-1;
        while(list.size()<m*n){
            for(int y = l;y <= r;y++){ list.add(matrix[t][y]); }
            for(int x = t+1;x <= b;x++){ list.add(matrix[x][r]); }
            if(l < r && t < b){
                for(int y = r-1;y >= l+1;y--){ list.add(matrix[b][y]); }
            for(int x = b;x> t;x--){ list.add(matrix[x][l]); }
            }
            l++;r--;t++;b--;
        }
        return list;
    }
}