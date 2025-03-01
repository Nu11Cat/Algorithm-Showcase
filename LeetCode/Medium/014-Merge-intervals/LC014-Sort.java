class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) ->Integer.compare(a[0],b[0]));
        int index = 0;
        int start = intervals[0][0] ,end = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for(int[] arr : intervals){
            int x = arr[0],y=arr[1];
            if(x>start && x<=end && y>end) end=y;
            else if(x>end) {
                result.add(new int[]{start,end});
                start=x;
                end=y;
            }
            else if(y>end) end=y;
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]);
    }
}