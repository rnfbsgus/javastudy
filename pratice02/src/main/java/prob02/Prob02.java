package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		int[] intArray = new int[ 5 ];
		double sum = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("5개의 숫자를 입력하세요.");
		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = scanner.nextInt() ;
			sum = sum + intArray[i];
		}
		
		/* 배열에 저장된 정수 값 더하기 */
		double p = sum/intArray.length;
		/* 출력 */
		System.out.println(p);
		/* 자원정리 */
		scanner.close();
	}
}
