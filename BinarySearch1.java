package J1.S.P0001;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch1 {

    public static void main(String[] args) {
        System.out.println("Enter number of array: ");
        int n = checkInput();
        System.out.println("Enter search value: ");
        int x = checkInput();

        int a[] = randomArr(n);
        Arrays.sort(a);
        System.out.print("The aray: ");
        printArray(a);
        int result = binarySearch(a, x);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
         printAllOccurrences(a, x);

//        int[] index = binarySearchAll(a, x);
//        if (index.length == 0) {
//            System.err.println("The element " + x + " is not found");
//        } else {
//            System.out.print("The element " + x + " is found at index: ");
//            printArray(index);
//        }


    }

    public static Scanner sc = new Scanner(System.in);

    // Check đầu vào 
    public static int checkInput() {
        while (true) {
            try {
                int n = sc.nextInt();
                if (n > 0) {
                    return n;
                } // đoạn mã sẽ ném ra một ngoại lệ (Exception).
                else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("!!!Invalid data");
                System.out.print("Please enter again: ");
                // được gọi để bỏ qua phần nhập liệu không hợp lệ và chuẩn bị cho lần nhập tiếp theo.
                sc.nextLine();
            }
        }
    }

    // Khai mảng random 
    public static int[] randomArr(int n) {
        int a[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(a.length);
        }
        return a;
    }

    // In mảng 
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Phương thức tìm kiếm nhị phân
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Kiểm tra nếu phần tử giữa là phần tử cần tìm
            if (array[mid] == target) {
                return mid;

            }

            // Nếu phần tử giữa lớn hơn phần tử cần tìm, bỏ qua nửa phải
            if (array[mid] > target) {
                right = mid - 1;
            } // Nếu phần tử giữa nhỏ hơn phần tử cần tìm, bỏ qua nửa trái
            else {
                left = mid + 1;
            }
        }

        // Trả về -1 nếu phần tử không được tìm thấy
        return -1;
    }
    
    static void printAllOccurrences(int[] arr, int x) {
        int index = binarySearch(arr, x);
        if (index == -1) {
            System.out.println("Phần tử không có trong mảng");
            return;
        }
        
        System.out.println("Phần tử được tìm thấy tại vị trí: " + index);

        // In ra các vị trí khác của phần tử
        for (int i = index - 1; i >= 0 && arr[i] == x; i--) {
            System.out.println("Phần tử được tìm thấy tại vị trí: " + i);
        }

        for (int i = index + 1; i < arr.length && arr[i] == x; i++) {
            System.out.println("Phần tử được tìm thấy tại vị trí: " + i);
        }
    }

}