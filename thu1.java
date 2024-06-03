/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J1.S.P0001;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class thu1 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter numbers of array: ");
        int n = inputPositiveInteger();
        int arr[] = randomArr(n);
        System.out.print("Enter element to search: ");
        int toSearch = sc.nextInt();
        System.out.println("The array: " + Arrays.toString(arr));

//        if(linearSearch(toSearch, a) == -1) System.out.println("Element is not found!!!");
//        else System.out.println("Found "+toSearch+" at index "+linearSearch(toSearch, a));

        int[] index =allIndex(toSearch, arr);
        if(index.length ==0){
            System.out.println("Not Found");
        }else {
            System.out.println("Found "+toSearch+" at index: "+Arrays.toString(index));
        }
    }

    //Enter positive number
    public static int inputPositiveInteger() {
        while (true) {
            try {
                int n = sc.nextInt();
                if (n > 0) {
                    return n;
                } // đoạn mã sẽ ném ra một ngoại lệ (Exception).
                else {
                    throw new Exception();
                }
//                int n = Integer.parseInt(sc.nextLine().trim());return n;
            } catch (Exception e) {
                System.err.println("!!!Invalid data");
                System.out.print("Please enter again: ");
                sc.nextLine();
            }
        }
    }

    //Return a array of random positive numbers 
    public static int[] randomArr(int n) {
        int a[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(a.length);
        }
        return a;
    }

    //linear search for find first toSearch
    public static int linearSearch(int toSearch, int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toSearch) {
                return i;
            }
        }
        return -1;
    }

    //Linear search for find all indexes of toSearch
    public static int[] allIndex(int toSeach, int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toSeach) {
                count++;
            }
        }
        int[] allIndex = new int[count];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toSeach) {
                allIndex[j] = i;
                j++;
            }
        }
        return allIndex;
    }
}
