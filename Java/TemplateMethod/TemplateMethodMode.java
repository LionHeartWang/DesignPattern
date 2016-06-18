class AbstractCalss {
	public void templateMethod() {
		System.out.println("call the template method.");
		primitiveOperation1();
		primitiveOperation2();
	}
	protected void primitiveOperation1() {
		// Hook Method
	}
	protected void primitiveOperation2() {
		// Hook Method
	}
}

class ConcreteClass extends AbstractCalss {
	protected void primitiveOperation1() {
		System.out.println("do primitive operation 1.");
	}
	protected void primitiveOperation2() {
		System.out.println("do primitive operation 2.");
	}
}

/* Main Entrance */
public class TemplateMethodMode {
	public static void main(String[] args) {
		System.out.println("create a concrete class instance.");
		ConcreteClass concreteClass = new ConcreteClass();
		concreteClass.templateMethod();
	}
}
