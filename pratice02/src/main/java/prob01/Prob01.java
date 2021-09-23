package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.print("금액 : ");
		int money = scanner.nextInt();
		
		int a = money/50000; 
		int b = money%50000/10000; 
		int c = money%50000%10000/5000; 
		int d = money%50000%10000%5000/1000; 
		int e = money%50000%10000%5000%1000/500; 
		int f = money%50000%10000%5000%1000%500/100; 
		int g = money%50000%10000%5000%1000%500%100/50; 
		int h = money%50000%10000%5000%1000%500%100%50/10; 
		int i = money%50000%10000%5000%1000%500%100%50%10/5; 
		int j = money%50000%10000%5000%1000%500%100%50%10%5/1; 
		
		System.out.println("50000원 : " + a + "개");
		System.out.println("10000원 : "+ b+ "개");
		System.out.println("5000원 : "+ c+ "개");
		System.out.println("1000원 : " +d+ "개");
		System.out.println("500원 : " + e+ "개");
		System.out.println("100원 : " + f+ "개");
		System.out.println("50원 : " + g+ "개");
		System.out.println("10원 : " + h+ "개");
		System.out.println("5원 : " + i+ "개");
		System.out.println("1원 : " + j+ "개");
		scanner.close();
		
 	}
}