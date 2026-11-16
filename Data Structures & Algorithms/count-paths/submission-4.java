class Solution {
    public int uniquePaths(int m, int n) {
        int prevRow[] = new int[n];
        Arrays.fill(prevRow,0);

        for(int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 || j==0)
                    temp[j]=1;
                else{
                    temp[j]=temp[j-1]+prevRow[j];
                }
            }
            prevRow=temp;
        }

        return prevRow[n-1];
    }
}
