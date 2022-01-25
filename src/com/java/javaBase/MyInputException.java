package com.java.javaBase;

import java.util.Scanner;

public class MyInputException extends RuntimeException{

    public MyInputException(){

    }
    public MyInputException(String message){
        super(message);
    }

    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            int[] nums = new int[3];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }

        }catch (ArrayStoreException e){

            System.out.println(e);

        }
    }
}
