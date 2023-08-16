package basic;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆（Max Heap）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 逐步取出堆顶元素，放到数组末尾，并进行堆调整
        for (int i = n - 1; i > 0; i--) {
            // 将堆顶元素（最大值）与当前未排序部分的末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 对交换后的堆进行调整，使其满足最大堆性质
            heapify(arr, i, 0);
        }
    }

    // 调整以某个节点为根的子树，使其满足最大堆性质
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 最大元素的索引
        int left = 2 * i + 1; // 左子节点的索引
        int right = 2 * i + 2; // 右子节点的索引

        // 如果左子节点大于根节点
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点大于当前最大节点
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大节点不是根节点
        if (largest != i) {
            // 交换最大节点和根节点
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // 继续调整交换后的子树
            heapify(arr, n, largest);
        }
    }

    // 测试代码
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        heapSort(arr);
        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}