/**
 * Created by samuelkolb on 13/11/14.
 *
 * @author Samuel Kolb
 */
public class IfNode<C> extends Node {

	//region Variables

	static enum Ports {
		CONDITION, RESULT, IF, ELSE
	}

	private final Type type;

	public Type getType() {
		return type;
	}

	//endregion

	//region Construction

	public IfNode(Type type) {
		this.type = type;
		addPort(Ports.CONDITION, Port.Direction.IN, BoolType.TYPE);
		addPort(Ports.RESULT, Port.Direction.OUT, type);
		addPort(Ports.IF, Port.Direction.IN, type);
		addPort(Ports.ELSE, Port.Direction.IN, type);
	}
	//endregion

	//region Public methods

	@Override
	protected Value<?, ?> getPortValue(String name) {
		Ports p = Ports.valueOf(name);
		switch (p) {
			case RESULT:
				Bool condition = (Bool) pull("Condition", BoolType.TYPE);
				return condition.isTrue() ? pull("If") : pull("Else");
		}
		throw new IllegalStateException();
	}


	//endregion
}
