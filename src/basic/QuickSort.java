package basic;

public class QuickSort {
    public void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // 将数组分区，并获取基准元素的最终位置

            // 递归对基准元素的左右两部分进行排序
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准元素
        int i = low - 1; // i用于指向小于基准元素的区域的边界

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j); // 将当前元素交换到小于基准元素的区域
            }
        }

        swap(arr, i + 1, high); // 将基准元素交换到正确的位置
        return i + 1; // 返回基准元素的最终位置
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}