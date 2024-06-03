/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J1.S.P0001;

/**
 *
 * @author thanh
 */

import java.util.Scanner;

/**
 *
 * @author thaycacac
 */
public class Bill {

     // đọc dữ liệu từ đầu vào tiêu chuẩn (bàn phím)
    private static Scanner in = new Scanner(System.in); 
    
    private static int checkInputInt(){
        //  tạo một vòng lặp vô hạn để liên tục yêu cầu người 
        //  dùng nhập vào cho đến khi nhận được một số nguyên hợp lệ.
        while(true){
            try{
                //  chuyển đổi chuỗi này thành một số nguyên
                int result = Integer.parseInt(in.nextLine()); 
                return result; 
            } catch (NumberFormatException e){
                // Khối catch bắt ngoại lệ này và in ra thông báo lỗi yêu cầu người dùng nhập lại giá trị 
                System.out.println("Please enter a number:");
            }
        }
    }

    //Get array bills that user input
    private static int[] inputBills() {
        System.out.print("Input number of bill: ");
        int size = checkInputInt();
        int[] bills = new int[size];
        //allow user input bills
        for (int i = 0; i < bills.length; i++) {
            System.out.print("Input value of bill " + (i + 1) + ": ");
            bills[i] = checkInputInt();
        }
        return bills;
    }

    //Get amount that user input
    private static int inputWallet() {
        System.out.print("Input value of wallet: ");
        int wallet = checkInputInt();
        return wallet;
    }

    //Calculate the total amount of the bills
    private static int calcTotal(int[] bills) {
        int total = 0;
        for (int i = 0; i < bills.length; i++) {
            total += bills[i];
        }
        return total;
    }

    //Check whether the amount in the wallet is enough to pay. 
    private static boolean payMoney(int total, int wallet) {
        if (total > wallet) {
            return false;
        } else {
            return true;
        }
    }

    //Print total of bill and result
    private static void printTotalAndResult(int[] bills, int wallet) {
        int total = calcTotal(bills);
        System.out.println("This is total of bill: " + total);
        if (payMoney(total, wallet)) {
            System.err.println("You can buy it");
        } else {
            System.err.println("You can't buy it.");
        }
    }

    public static void main(String[] args) {
        //allow user input input bill
        int[] bills = inputBills();
        //allow user in put amount of wallet
        int wallet = inputWallet();
        //print total of bill and result
        printTotalAndResult(bills, wallet);
    }
}
