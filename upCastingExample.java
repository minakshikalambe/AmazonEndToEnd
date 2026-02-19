package batch60;
class SuperClass1{
	void method1() {
		System.out.println("method1");
	}
	
}

class SubClass extends SuperClass1{
	void method2() {
		System.out.println("method1");
	}
}
public class upCastingExample {
public static void main(String[] args) {
	SuperClass1 obj = new SubClass();
	obj.method1();
}
}
