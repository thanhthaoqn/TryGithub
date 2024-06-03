package J1.S.P0001;

import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        System.out.println("Enter number of array: ");
        int n = checkInput();
        System.out.println("Enter search value: ");
        int x = checkInput();

        int a[] = randomArr(n);
        System.out.print("The aray: ");
        printArray(a);
        linearSearch(a, n, x);

//        int[] index = linearSearchAllIndex(x, a);
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

    // Tìm kiếm tuyến tính 
    public static void linearSearch(int[] a, int n, int x) {
        int cnt = 0;
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                cnt = 1;
                m = i;
                break;
            }
        }
        if (cnt == 1) {
            System.out.println("Found " + x + " at index: " + m);
        } else {
            System.out.println("Not Found.");
        }
    }

    public static int[] linearSearchAllIndex(int x, int a[]) {
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                count++;
            }
        }

        int indexArr[] = new int[count];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                // Chỉ số i được lưu vào indexArr tại vị trí j.
                indexArr[j] = i;
                // Biến j được tăng lên 1 để chuẩn bị cho vị trí tiếp theo trong indexArr.
                j++;
            }
        }
        return indexArr;
    }

    // In mảng 
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
