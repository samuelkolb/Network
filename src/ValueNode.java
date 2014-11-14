/**
 * Created by samuelkolb on 14/11/14.
 */
public class ValueNode<T extends Type> extends Node {

	enum Ports {
		VALUE
	}

	private final Value<T, ?> value;

	public ValueNode(Value<T, ?> value) {
		this.value = value;
		addPort(Ports.VALUE.name(), Port.Direction.OUT, value.getType());
	}

	@Override
	protected Value<?, ?> getPortValue(String name) {
		return value;
	}
}
