package J1.S.P0001;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("Enter number of array: ");
        int n = checkInput();
        System.out.println("Enter search value: ");
        int x = checkInput();

        int a[] = randomArr(n);
        Arrays.sort(a);
        System.out.print("The aray: ");
        printArray(a);
//        int result = binarySearch(a, x);
//
//        if (result != -1) {
//            System.out.println("Element found at index: " + result);
//        } else {
//            System.out.println("Element not found");
//        }

        int[] index = binarySearchAll(a, x);
        if (index.length == 0) {
            System.err.println("The element " + x + " is not found");
        } else {
            System.out.print("The element " + x + " is found at index: ");
            printArray(index);
        }

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

//    public static int[] binarySearchAll(int[] array, int target) {
//        int left = 0;
//        int right = array.length - 1;
//        int count = 0;
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            for (int i = 0; i < array.length; i++) {
//                if (array[mid] == target) {
//                    count++;
//                }
//                if (array[mid] > target) {
//                    right = mid - 1;
//                } // Nếu phần tử giữa nhỏ hơn phần tử cần tìm, bỏ qua nửa trái
//                else {
//                    left = mid + 1;
//                }
//            }
//
//            // Kiểm tra nếu phần tử giữa là phần tử cần tìm
//            int indexArr[] = new int[count];
//            int j = 0;
//            for (int i = 0; i < array.length; i++) {
//                if (array[mid] == target) {
//                    // Chỉ số i được lưu vào indexArr tại vị trí j.
//                    indexArr[j] = i;
//                    // Biến j được tăng lên 1 để chuẩn bị cho vị trí tiếp theo trong indexArr.
//                    j++;
//                }
//            }
//            return indexArr;
//        }
//        // Nếu không tìm thấy phần tử trong mảng, trả về mảng rỗng
//        return new int[0];
//    }
    public static int[] binarySearchAll(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int count = 0;

        // Đếm số lần xuất hiện của phần tử trong mảng
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                count++;
            }

            if (array[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Khởi tạo mảng lưu trữ chỉ mục
        int[] indexArr = new int[count];
        int j = 0;

        // Tìm tất cả các vị trí của phần tử target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            for (int i = 0; i < array.length; i++) {
                if (array[mid] == target) {
                    // Chỉ số i được lưu vào indexArr tại vị trí j.
                    indexArr[j] = i;
// Biến j được tăng lên 1 để chuẩn bị cho vị trí tiếp theo trong indexArr.
                    j++;
                } else if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return indexArr;
    }

}
