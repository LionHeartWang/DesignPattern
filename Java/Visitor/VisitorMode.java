import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Element */
interface Element {
	void accept(Visitor v);
}

class ConcreteElementA implements Element {
	public void accept(Visitor v) {
		v.visitConcreteElementA(this);
	}
	public void operationA() {
		System.out.println("  >> do operation A");
	}
}

class ConcreteElementB implements Element {
	public void accept(Visitor v) {
		v.visitConcreteElementB(this);
	}
	public void operationB() {
		System.out.println("  >> do operation B");
	}
}

/* Visitor */
interface Visitor {
	void visitConcreteElementA(ConcreteElementA e);
	void visitConcreteElementB(ConcreteElementB e);
}

class ConcreteVisitor1 implements Visitor {
	public void visitConcreteElementA(ConcreteElementA e) {
		System.out.println("  >> visit an element A via visitor 1.");
    e.operationA();
	}
	public void visitConcreteElementB(ConcreteElementB e) {
		System.out.println("  >> visit an element B via visitor 1.");
    e.operationB();
	}
}

class ConcreteVisitor2 implements Visitor {
	public void visitConcreteElementA(ConcreteElementA e) {
		System.out.println("  >> visit an element A via visitor 2.");
    e.operationA();
	}
	public void visitConcreteElementB(ConcreteElementB e) {
		System.out.println("  >> visit an element B via visitor 2.");
    e.operationB();
	}
}

/* ObjectStructure */
class ObjectStructure {
	private List<Element> elements = new ArrayList<Element>();
	public void add(Element e) {
		elements.add(e);
	}
	public void visit(Visitor v) {
		System.out.println("4.traverse the elements of ObjectStructure:");
	  for (Element e : elements) {
			e.accept(v);
		}
	}
}

/* Main Entrance */
public class VisitorMode {
	public static void main(String[] arsg) {
		System.out.println("1.build an objectStructure.");
    ObjectStructure objectStructure = new ObjectStructure();
		System.out.println("2.add an element A and an element B into objectStructure.");
		objectStructure.add(new ConcreteElementA());
		objectStructure.add(new ConcreteElementB());
		System.out.println("3.choose a visitor: A/B");
		System.out.print("  your choise: ");
		Scanner sc = new Scanner(System.in);
		Visitor visitor;
		switch(sc.next()) {
			case "A": visitor = new ConcreteVisitor1(); break;
			default: visitor = new ConcreteVisitor2(); break;
		}
		objectStructure.visit(visitor);
	}
}
