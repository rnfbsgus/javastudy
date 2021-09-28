package chaper04;

public class MyClass {
	private static MyClass instance = null;
	
	private MyClass() {
		
	}
	
	//Singleton + Factory Method
	public static MyClass getInstance() {
		if(instance == null) {
			instance = new MyClass();
	}
		
		return instance;
	}
	public static void main(String[] args) {
		
	}

}
