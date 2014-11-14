/**
 * Created by samuelkolb on 14/11/14.
 */
public class PlusNode extends Node {

	enum Ports {
		RESULT, IN1, IN2
	}

	public PlusNode() {
		addPort(Ports.RESULT.name(), Port.Direction.BOTH, NumberType.TYPE);
		addPort(Ports.IN1.name(), Port.Direction.BOTH, NumberType.TYPE);
		addPort(Ports.IN2.name(), Port.Direction.BOTH, NumberType.TYPE);
	}

	@Override
	protected Value<?, ?> getPortValue(String name) {
		Ports portName = Ports.valueOf(name);
		switch (portName) {
			case RESULT: {
				Int i1 = (Int) pull(Ports.IN1.name());
				return i1.getFunction("+").apply(new Int[]{i1, (Int) pull(Ports.IN2.name())});
			} case IN1: {
				Int result = (Int) pull(Ports.RESULT.name());
				return result.getFunction("-").apply(new Int[]{result, (Int) pull(Ports.IN2.name())});
			} case IN2: {
				Int result = (Int) pull(Ports.RESULT.name());
				return result.getFunction("-").apply(new Int[]{result, (Int) pull(Ports.IN1.name())});
			}
		}
		throw new IllegalStateException();
	}

	@Override
	public String toString() {
		return "+";
	}
}
