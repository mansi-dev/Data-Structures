public class MinWindowSize {
    public static int smallestSubArr(int[] arr, int targetSum){
        int windowStart = 0;
        int currSum =0;
        int size = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            currSum += arr[i];
            while(currSum>=targetSum){
                size = Math.min(size, i - windowStart+1);
                currSum -= arr[windowStart];
                windowStart++;
            }
        }
        return size;
    }
    public static void main(String[] args) {
        int size = smallestSubArr(new int[]{4,2,1,7,8,1,2,8,1,0}, 8);
        System.out.println(size);
    }
}
