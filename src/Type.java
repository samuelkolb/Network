/**
 * Created by samuelkolb on 13/11/14.
 *
 * @author Samuel Kolb
 */
public abstract class Type<T> {

	//region Variables

	//endregion

	//region Construction

	//endregion

	//region Public methods
	public abstract Value<T> createValue(T content);
	//endregion
}
