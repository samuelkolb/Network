/**
 * Created by samuelkolb on 14/11/14.
 */
public interface Function<T extends Type, I extends Value<T, I>> {

	/**
	 * Applies the given function
	 * @param values    The values to apply the function to
	 * @return  The calculated return value
	 */
	public I apply(I[] values);
}
