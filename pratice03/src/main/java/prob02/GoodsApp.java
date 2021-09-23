package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Good[] good = new Good[COUNT_GOODS];
		
		for (int i = 0; i < COUNT_GOODS; i++) {
				String line = scanner.nextLine();
				
				String[] tokens = line.split(" ");
				String name  = tokens[0];
				int price = Integer.parseInt(tokens[1]);
				int countStock = Integer.parseInt(tokens[2]);
				
				Good g = new Good();
				
				g.setName(name);
				g.setPrice(price);
				g.setCountStock(countStock);
				
				good[i] = g;
				
		}
		
		for(Good g : good) {
			System.out.println(g.getName() + "(가격:" + g.getPrice() + "원)이 " + g.getCountStock() + "개 입고 되었습니다." );
		}
		scanner.close();
	}
}
