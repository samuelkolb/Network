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
	private final Type<T> type;

	private final Direction direction;

	private final Node host;

	private Optional<Port<T>> recipient = Optional.empty();
	//endregion

	//region Construction

	public Port(Type<T> type, Direction direction, Node host) {
		this.type = type;
		this.direction = direction;
		this.host = host;
	}

	//endregion

	//region Public methods

	//endregion
}
