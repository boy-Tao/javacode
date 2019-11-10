import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        //Arrays.sort(arr);
        System.out.println(toString(arr));
        //System.out.println(max(arr));
        //System.out.println(min(arr));
        //System.out.println(avg(arr));
        //System.out.println(toString(fun(arr)));
        //System.out.println(toString(fun2(arr)));
        System.out.println(found2(arr,8,0,arr.length-1));
        //System.out.println(found1(arr,8));
        System.out.println(toString(oddAfterEve(arr)));
    }

    public static void printf(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static int[] newArr(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i] * 2;
        }
        return ret;
    }

    /*public static String toString(int[] array) {
        String arr = "[";
        for (int i = 0; i < array.length; i++) {
            arr = arr + array[i];
            if (i < array.length - 1) {
                arr = arr + ",";
            }
        }
        arr = arr + "]";
        return arr;
    }*/

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return  min;
    }

    public static double avg(int[] arr) {
        double avg = 1;
        double sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        avg = sum / arr.length;
        return avg;
    }

    //逆置
    public static int[] fun(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while(i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

    //二分查找
    public static int found1(int[] arr,int key) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            //int mid = (left + right)>>>1;
            if(arr[mid] == key) {
                return mid;
            }
            else if (arr[mid] < key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //二分查找递归
    public static int found2(int[] arr,int key,int left,int right) {
        int mid = (left + right) >>> 1;
        //int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (arr[mid] == key) {
            return mid;
        }
        else if (arr[mid] < key) {
            return found2(arr,key,mid+1,right);
        }
        else {
            return found2(arr,key,left,mid-1);
        }
    }

    //冒泡排序
    public static int[] fun2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

     //冒泡优化
    public static int[] fun3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    //数组奇数放偶数之前；
    public static int[] oddAfterEve (int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while(i<j) {
            while(arr[i] % 2 != 0  ) {  //不是偶数 继续找
                i++;
            }
            while(arr[j] % 2 != 1 && i < j) {  //不是奇数 继续找
                j--;
            }
            if(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }
}


