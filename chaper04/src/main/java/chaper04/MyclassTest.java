package chaper04;

public class MyclassTest {

	public static void main(String[] args) {
	// MyClass myclass0 = new MyClass();
		
		MyClass myClass1 = MyClass.getInstance();
		MyClass myClass2 = MyClass.getInstance();
		
		System.out.println(myClass1 == myClass2);

	}

}
