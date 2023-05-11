class Solution {
    public int search(int[] arr, int target) {

        // Initialize begin and finish to 0 and array length - 1 respectively.

        int beg = 0;
        int fin = arr.length - 1;

        // Now we perform binary search to get the target element.

        while(beg <= fin)
        {
            int mid = beg + (fin - beg) / 2;

            // We check for target to be mid element always and if not then we continue our search
            // by manipulating beg and fin according to the situation.

            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] < arr[fin])
            {
                // Here arr[mid] < arr[fin], which means right half of array is sorted.

                // So we first check if target is in that sorted half, if yes then we move beg to mid + 1.
                // Else if the target is not in this sorted subarray, we need to find it before mid, so
                // end is moved to mid - 1.

                if(target >= arr[mid] && target <= arr[fin])
                {
                    beg = mid + 1;
                }
                else
                {
                    fin = mid - 1;
                }
            }
            else
            {
                // This case is for when left half of array is sorted.

                // So we first check if target is in that sorted half, if yes then we move fin to mid - 1.
                // Else if the target is not in this sorted subarray, we need to find it after mid, so
                // beg is moved to mid + 1.

                if(target <= arr[mid] && target >= arr[beg])
                {
                    fin = mid - 1;
                }
                else
                {
                    beg = mid + 1;
                }
            }
        }

        // Finally if we don't find the element return -1.
        return -1; 
    }
}