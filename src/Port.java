import java.util.Optional;

/**
 * Created by samuelkolb on 13/11/14.
 *
 * @author Samuel Kolb
 */
public class Port<T extends Type> {

	//region Variables
	private final String name;

	public String getName() {
		return name;
	}

	private final T type;

	public T getType() {
		return type;
	}

	private final Direction direction;

	public Direction getDirection() {
		return direction;
	}

	private final Node host;

	public Node getHost() {
		return host;
	}

	private Optional<Port<T>> recipient = Optional.empty();

	public Optional<Port<T>> getRecipient() {
		return recipient;
	}

	public void setRecipient(Port<?> recipient) {
		if(recipient.getDirection() == Direction.BOTH || recipient.getDirection() != getDirection()) {
			if(getType().equals(recipient.getType()))
				this.recipient = Optional.of((Port<T>) recipient);
			else {
				String msg = String.format("Port types %s and %s do not correspond", getType(), recipient.getType());
				throw new IllegalArgumentException(msg);
			}
		} else {
			String msg = String.format("Cannot connect directions %s and %s", getDirection(), recipient.getDirection());
			throw new IllegalArgumentException(msg);
		}
	}

	//endregion

	//region Construction

	public Port(String name, T type, Direction direction, Node host) {
		this.name = name;
		this.type = type;
		this.direction = direction;
		this.host = host;
	}

	//endregion

	//region Public methods

	public Value<T, ?> pullForeign() {
		if(recipient.isPresent())
			return recipient.get().pullHost();
		String message = String.format("Port %s of node %s is not connected to any other node", getName(), getHost());
		throw new IllegalStateException("Unconnected port: " + message);
	}

	public Value<T, ?> pullHost() {
		Value<?, ?> value = getHost().getValue(getName());
		if(getType().equals(value.getType()))
			return (Value<T, ?>) value;
		throw new IllegalStateException("Node returning faulty typed value");
	}

	//endregion
}
