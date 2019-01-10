package com.screening.exercise;

import java.util.Arrays;
import java.util.Random;

public class Exercise3 {

	public static void main(String[] args) {
		randomNumber();
    }
    public static void randomNumber(){
        Random rand = new Random();
        int [] num = new int[500];

        for(int i=0; i<num.length; i++){
            num[i] = rand.nextInt();

            System.out.println("Index "+i+ " number is: "+num[i]);
        }
        for (int i=0; i<num.length; i++){
            for(int j=i+1; j<num.length; j++){
                if(num[j]<num[i]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        int index = Arrays.binarySearch(num, num[0]);
        System.out.println("Smallest Number: " +num[0]);
        System.out.println("Smallest number is located in the array at index of " +index);
    }
}
