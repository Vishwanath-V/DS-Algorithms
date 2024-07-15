public class SubArrayMaxSum {
    public static void main(String[] args) {
        int[] ip = new int[] {10,15,35,78,45,23,67,15,90};
        System.out.println(maxSum(ip,4));
        System.out.println(optimizedMaxSum(ip,4));
    }

    // Time Complexity O(m*n) with multiple scan of the same array elements
    static int maxSum(int[] ip, int size) {
        int maxSum = Integer.MIN_VALUE;
        int ind = -1;
        for(int i=0; i<ip.length-size+1; i++) {
            int currentSum = 0;
            for(int j=0;j<size;j++) {
                currentSum = currentSum+ip[i+j];
            }
            maxSum = Math.max(maxSum,currentSum);
            ind = maxSum==currentSum ? i : ind;
        }
        System.out.println("MaxSubArray index starts at position:"+ind);
        return maxSum;
    }

    // Time Complexity O(n) with 1 for loop scan of the entire array
    static int optimizedMaxSum(int[] ip, int size) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int ind = -1;

        // find sum of first k elments
        for(int i=0;i<size;i++)
            windowSum += ip[i];

        for(int i=1;i<ip.length-size;i++) {
            windowSum = windowSum - ip[i-1] + ip[i+size-1];
            maxSum = Math.max(maxSum,windowSum);
            ind = maxSum==windowSum ? i : ind;
        }
        System.out.println("MaxSubArray index starts at position:"+ind);
        return maxSum;
    }
}
