import java.util.HashMap;
import java.util.Map;

/**
 * Created by samuelkolb on 13/11/14.
 *
 * @author Samuel Kolb
 */
public abstract class Node {

	//region Variables

	private final Map<String, Port<?>> ports = new HashMap<String, Port<?>>();

	<T extends Type> void addPort(String name, Direction direction, T type) {
		Port<T> port = new Port<>(name, type, direction, this);
		ports.put(port.getName(), port);
	}

	<T extends Type> void addPort(Enum<?> name, Direction direction, T type) {
		addPort(name.name(), direction, type);
	}

	//endregion

	//region Construction

	public Node() {
	}

	//endregion

	//region Public methods

	public void connect(Node other, String otherPortName, String portName) {
		Port<?> otherPort = other.getPort(otherPortName);
		Port<?> port = getPort(portName);
		port.setRecipient(otherPort);
		otherPort.setRecipient(port);
	}

	public void connect(Node other, Enum<?> otherPortName, Enum<?> portName) {
		connect(other, otherPortName.name(), portName.name());
	}

	public Port<?> getPort(String name) {
		return ports.get(name);
	}

	public Port<?> getPort(Enum<?> name) {
		return getPort(name.name());
	}

	public <T extends Type> Port<T> getPort(String name, T type) {
		Port<?> port = getPort(name);
		if(port.getType().equals(type))
			return (Port<T>) port;
		throw new IllegalArgumentException();
	}

	public <T extends Type> Port<T> getPort(Enum<?> name, T type) {
		return getPort(name.name(), type);
	}

	public Value<?, ?> getValue(String name) {
		if(getPort(name).getDirection() == Direction.IN)
			throw new IllegalArgumentException("The given port does not support pulling");
		return getPortValue(name);
	}

	public Value<?, ?> getValue(Enum<?> name) {
		return getValue(name.name());
	}

	protected <T extends Type> Value<T, ?> pull(String name, T type) {
		Port<T> port = getPort(name, type);
		return port.pullForeign();
	}

	protected <T extends Type> Value<T, ?> pull(Enum<?> name, T type) {
		return pull(name.name(), type);
	}

	protected Value<?, ?> pull(String name) {
		return getPort(name).pullForeign();
	}

	protected Value<?, ?> pull(Enum<?> name) {
		return pull(name.name());
	}

	protected abstract Value<?, ?> getPortValue(String name);
	//endregion
}
