package chaper04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10, 20);
		
//		Class klass = p.getClass();
		
		System.out.println(p.getClass()); // reflection 클래스 정보를 보여준다
		System.out.println(p.hashCode()); // address 기반의 해싱값
										  // address x
										  // reference x 빠른검색
		System.out.println(p.toString()); // 객체 안의 내용을 string으로 바꿔줌 , getClass() + "@" + hashCode()
		System.out.println(p);
		
	}

}
