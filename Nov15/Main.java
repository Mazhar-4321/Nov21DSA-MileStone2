import java.util.Arrays;

public class Main {
    private int temp_array[];
    private int len;
    static int searchInRotatedArray(int arr[],int f,int l,int k)
    {
        int m;

        while(f<=l)
        {
            m=(f+l)/2;
            if(k>arr[m]){f=m+1;}
            if(k<arr[m]){l=m-1;}
            if(k==arr[m]){return m;}
        }
        return -1;
    }
    static int findStartingPoint(int arr[],int key)
    {
        int ans=-1;
        int f=0,l=arr.length-1,m=0;
        int position=0;
        while(true)
        {
            m=(f+l)/2;
            if(arr[m]>arr[m-1]&&arr[m]<arr[m+1])
            {
                l=m;
            }
            else
            {
                position=m;break;
            }
        }
        int start_range=arr[f];
        int end_range=arr[m];
        if(key>=start_range&&key<=end_range)
        {
            return searchInRotatedArray(arr,f,m,key);
        }
        else
        {
            return searchInRotatedArray(arr,m,arr.length-1,key);
        }

    }

    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }


    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public void sort(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        this.temp_array = nums;
        len = nums.length;
        quickSort(0, len - 1);
    }
    private void quickSort(int low_index, int high_index) {

        int i = low_index;
        int j = high_index;
        // calculate pivot number
        int pivot = temp_array[low_index+(high_index-low_index)/2];
        // Divide into two arrays
        while (i <= j) {
            while (temp_array[i] < pivot) {
                i++;
            }
            while (temp_array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (low_index < j)
            quickSort(low_index, j);
        if (i < high_index)
            quickSort(i, high_index);
    }

    private void exchangeNumbers(int i, int j) {
        int temp = temp_array[i];
        temp_array[i] = temp_array[j];
        temp_array[j] = temp;
    }
    public static void main(String[] args) {
        // Search element in rotated sorted array in O(logn) time complexity
        int arr[]= new int[]{7,8,0,1,2,3,4,5,6};
        System.out.println( findStartingPoint(arr,6));
        // Quick Sort Algorithm
        Main ob = new Main();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println(Arrays.toString(nums));
        ob.sort(nums);
        System.out.println(Arrays.toString(nums));
        // Merger Sort Algorithm
         arr =new int[] {12, 11, 13, 5, 6, 7};


        printArray(arr);

        Main ob1 = new Main();
        ob1.sort(arr, 0, arr.length-1);

       
        printArray(arr);
    }
}
