package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int a = scanner.nextInt();
		int sum = 0;
	
		
		if(a%2 == 0) {
			for (int i = 0; i <= a; i+=2) {
				sum = sum + i;
			}
			System.out.println("결과값 : " + sum);
		} 
		else {
			for (int j = 1; j <= a; j+=2) {
				sum = sum + j;
			}
			System.out.println("결과값 : " + sum);
		}
		
		scanner.close();
	}
}
