import java.util.Optional;

/**
 * Created by samuelkolb on 13/11/14.
 *
 * @author Samuel Kolb
 */
public class Port<T> {

	public enum Direction {
		IN, OUT, BOTH
	}

	//region Variables
	private final String name;

	public String getName() {
		return name;
	}

	private final Type<T> type;

	public Type<T> getType() {
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

	//endregion

	//region Construction

	public Port(String name, Type<T> type, Direction direction, Node host) {
		this.name = name;
		this.type = type;
		this.direction = direction;
		this.host = host;
	}

	//endregion

	//region Public methods

	//endregion
}
