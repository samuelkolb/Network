/**
 * Created by samuelkolb on 13/11/14.
 *
 * @author Samuel Kolb
 */
public class Value<T> implements Container<T> {

	//region Variables
	private final Type<T> type;

	public Type<T> getType() {
		return type;
	}

	private final T value;

	//endregion

	//region Construction

	public Value(Type<T> type, T value) {
		this.type = type;
		this.value = value;
	}

	//endregion

	//region Public methods

	@Override
	public T get() {
		return this.value;
	}

	//endregion
}
