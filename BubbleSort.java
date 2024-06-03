/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J1.S.P0001;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class BubbleSort {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhập n 
        int n = 0;
        do {
            System.out.print("Enter number of array: ");
            try {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Enter positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter again.");
                sc.next(); // Xóa bỏ đầu vào không hợp lệ
            }
        } while (n <= 0);

        // Nhập mảng
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            do{
                try {
                    // sẽ sinh ra một số nguyên ngẫu nhiên trong khoảng từ 0 đến n-1.
                    a[i] = random.nextInt(n);
                    if (a[i] <= 0) {
                        System.out.println("Enter positive number.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Enter again.");
                    sc.next(); // Xóa bỏ đầu vào không hợp lệ
                }
            } while(n<=0);   
            
        }

        System.out.println("Mảng trước khi sắp xếp:");
        printArray(a);

        bubbleSort(a, n);

        System.out.println("\nMảng sau khi sắp xếp:");
        printArray(a);
    }

    // Thuật toán nổi bọt 
    static void bubbleSort(int[] arr, int n) {
        // Do sau mỗi lần duyệt phần tử cuối cùng sẽ được sắp xếp đúng vị trí nên không cần duyệt hết tất cả ptu 
        for (int i = 0; i < n - 1; i++) {
//            System.out.println("");
//            System.out.println("Loop i = " + i + ": ");
            for (int j = 0; j < n - i - 1; j++) {
//                System.out.println("Loop j = " + j + ": ");
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi arr[j] và arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // In ra các bước sắp xếp
//                    printArray(arr); 
                }
//                else{
//                    printArray(arr);
//                }
            }
        }
    }

    // In mảng 
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
// 5 1 4 2 8 
// i =0; j = 0; 1 5 4 2 8 
//       j = 1; 1 4 5 2 8 
//       j = 2; 1 4 2 5 8 
//       j = 3; 1 4 2 5 8 

// i = 1; j = 0 ; 1 5 4 2 8 
//        j = 1;  1 4 5 2 8 
//        j = 2;  1 4 2 5 8 
// i = 2; j = 0; 1 4 2 5 8 
//        j = 1; 1 2 4 5 8 

