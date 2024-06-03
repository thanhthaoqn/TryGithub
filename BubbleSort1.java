/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J1.S.P0001;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class BubbleSort1 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter numbers of array: ");
        int n = checkInput();
        int arr[] = randomArr(n);

        System.out.println("Mảng trước khi sắp xếp:");
        printArray(arr);

        bubbleSort(arr, n);

        System.out.println("Mảng trước khi sắp xếp:");
        printArray(arr);

    }

    //Enter positive number
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

    //Return a array of random positive numbers 
    public static int[] randomArr(int n) {
        int a[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            // Random từ 0 đến n-1 
            a[i] = rand.nextInt(a.length);
        }
        return a;
    }

    static void bubbleSort(int[] arr, int n) {
        // Đến lần duyệt thứ n - 1, phần tử nhỏ thứ hai sẽ được đặt vào vị trí đúng (vì phần tử nhỏ nhất sẽ tự động nằm đúng vị trí mà không cần hoán đổi trong lần duyệt cuối cùng).
        for (int i = 0; i < n-1 ; i++) {
            System.out.println("");
            System.out.println("Loop i = " + i + ": ");
            //  Do sau mỗi lần duyệt phần tử cuối cùng sẽ được sắp xếp đúng vị trí nên không cần duyệt hết tất cả ptu 
            for (int j = 0; j < n - i - 1; j++) {
                System.out.println("Loop j = " + j + ": ");
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi arr[j] và arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //  In ra các bước sắp xếp
                    printArray(arr);
                } else {
                    printArray(arr);
                }
            }
        }
    }

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
