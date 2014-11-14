import java.util.HashMap;
import java.util.Map;

/**
 * Created by samuelkolb on 13/11/14.
 *
 * @author Samuel Kolb
 */
public abstract class Value<T extends Type, I extends Value<T, I>> {

	//region Variables
	private final Map<FunctionDescriptor<T>, Function<T, I>> functions = new HashMap<>();

	public void addFunction(String name, Function<T, I> function) {
		functions.put(new FunctionDescriptor<>(getType(), name), function);
	}
	//endregion

	//region Construction
	protected Value() {

	}
	//endregion

	//region Public methods
	public abstract T getType();

	public Function<T, I> getFunction(String name) {
		return functions.get(new FunctionDescriptor<>(getType(), name));
	}

	//endregion
}
