import log.Log;

/**
 * Created by samuelkolb on 14/11/14.
 */
public class Test {

	public static void main(String[] args) {
		ValueNode<NumberType> a = new ValueNode<>(new Int(5));
		ValueNode<NumberType> b = new ValueNode<>(new Int(4));
		ValueNode<NumberType> c = new ValueNode<>(new Int(9));

		PlusNode plusNode = new PlusNode();
		plusNode.connect(a, ValueNode.Ports.VALUE, PlusNode.Ports.IN1);
		plusNode.connect(b, ValueNode.Ports.VALUE, PlusNode.Ports.IN2);
		plusNode.connect(c, ValueNode.Ports.VALUE, PlusNode.Ports.RESULT);

		for(PlusNode.Ports port : PlusNode.Ports.values())
			System.out.println(port.name() + ": " + plusNode.pull(port));
	}
}
