package prob03;

class CurrencyConverter{
	private static double rate;
	public static double toDollar(double won) {
		return won/rate;
	}
	
	public static double toKRW(double dollar) {
		return dollar * rate;
	}
	
	public static double setRate(double r) {
		return rate = r;
	}
}
public class CurrencyConverterTest {

	public static void main(String[] args) {
		//  환율을 세팅 합니다.
		CurrencyConverter.setRate(1197.0);
		
		double dollar = CurrencyConverter.toDollar( 1000000. );
		System.out.println( "백만원은 " + dollar + "달러 입니다" );
		
		double krw = CurrencyConverter.toKRW( 100. );
		System.out.println( "백달러는 " + krw + "원 입니다" );
	}

}
