package patterns.slidingwindow;

/**
 * O(N + K) --> O(N)
 * ex : [1, 4, 2, 10, 23, 3, 1, 0, 20] , K = 4
 * @author Mohamed Ramadan
 * @since 26/05/2024
 */


public class MaxSumSubarrayK {
//    public static int maxSumSubarrayK(int[] arr, int k) {
//        int n = arr.length;
//
//        if(n < k){
//            return -1;
//        }
//
//        int maxSum = 0 , currentMax = 0;
//        for(int i = 0 ; i < k ; ++i){
//            maxSum += arr[i];
//        }
//        currentMax = maxSum;
//        int l = 0;
//        for(int i = k ; i < n ; ++i){
//            currentMax -= arr[i - k];
//            currentMax += arr[i];
//            maxSum = Math.max(currentMax , maxSum);
//        }
//
//        return  maxSum;
//    }

    public static int maxSumSubarrayK(int[] arr , int k){
        int n = arr.length;
        // corner cases
        if(arr.length == 0 || k == 0 || (n < k)) return -1;

        // calculate first window
        int maxSum = 0 , currentSum = 0;
        for(int i = 0 ; i < k ; ++i) maxSum += arr[i];  // O(K)

        currentSum = maxSum;
        // keep track of first element in old window
        int left = 0;
        // calculate each window subarray
        for(int r = k ; r < n ; ++r){       // O(N)
            currentSum = currentSum - arr[left];
            currentSum = currentSum + arr[r];
            ++left;
            maxSum = Math.max(maxSum , currentSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        System.out.println(maxSumSubarrayK(arr , k));
    }
}
