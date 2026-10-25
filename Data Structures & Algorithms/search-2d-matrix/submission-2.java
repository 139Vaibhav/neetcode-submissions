class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // first we need to find in which row the target would lie
        // then check in which col it's present
        int n = matrix.length;
        int m = matrix[0].length;
        int lo=0, hi=n-1;
        int posRow = -1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(matrix[mid][0]<=target){
                posRow=mid;
                lo=mid+1;
            }
            else
                hi=mid-1;
        }
        if(posRow==-1) return false;
        lo=0; hi=m-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(matrix[posRow][mid] == target)
                return true;
            else if(matrix[posRow][mid] < target)
                lo=mid+1;
            else
                hi=mid-1;
        }
        return false;
    }
}