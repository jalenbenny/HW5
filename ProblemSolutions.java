/******************************************************************
 *
 *   BEN FLOWERS / COMP 272/400C 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE
        // Create a HashSet from the first array for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : list1) {
            set.add(num);
        }

        // Check if every element in list2 exists in the set
        for (int num : list2) {
            if (!set.contains(num)) {
                return false;
            }
        }

        return true;
    }



    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE
        // Create a min-heap of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Process first k elements
        for (int i = 0; i < Math.min(k, array.length); i++) {
            minHeap.offer(array[i]);
        }

        // For remaining elements, keep only k largest
        for (int i = k; i < array.length; i++) {
            if (array[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(array[i]);
            }
        }

        // The top of the heap is the kth largest element
        return minHeap.peek();
    }




    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {


        // Combine both arrays into a single sorted array
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all elements from both arrays to the min-heap
        for (int num : array1) {
            minHeap.offer(num);
        }
        for (int num : array2) {
            minHeap.offer(num);
        }

        // Create result array and populate from min-heap
        int[] result = new int[minHeap.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
