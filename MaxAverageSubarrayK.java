package patterns.slidingwindow;

/**
 *   ex : [1, 4, 2, 10, 23, 3, 1, 0, 20] , K = 4
 *   @author Mohamed Ramadan
 *   @since  26/05/2024
*/
public class MaxAverageSubarrayK {
    public static double maxAverageSubarrayK(int[] arr , int  k){
        int n = arr.length;
        if(n < k || k == 0 || n == 0){
            return -1;
        }

        int maxSum = 0 , currentSum = 0;
        int l = 0;
        for(int i = 0 ; i < k ; ++i){
            maxSum += arr[i];
        }
        currentSum = maxSum;

        for(int i = k ; i < n ; ++i){
            currentSum -= arr[l++];
            currentSum += arr[i];
            maxSum = Math.max(currentSum , maxSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        System.out.println(maxAverageSubarrayK(arr , k));
    }
}
