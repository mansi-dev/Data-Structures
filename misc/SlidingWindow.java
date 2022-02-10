public class SlidingWindow {

    public static int findMaxSum(int[] arr, int k){
        int  maxSum = Integer.MIN_VALUE;
        int currMaxSum = 0;
        for(int i=0;i<arr.length;i++){
            currMaxSum += arr[i];
            if(i>=k-1){
                maxSum = Math.max(maxSum, currMaxSum);
                currMaxSum -= arr[i-(k-1)];
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int sum = findMaxSum(new int[]{4,2,1,7,8,1,2,8,1,0}, 3);
        System.out.println(sum);
    }
}
