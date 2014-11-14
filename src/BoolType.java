/**
 * Created by samuelkolb on 13/11/14.
 */
public class BoolType extends Type {

	public static BoolType TYPE = createBoolType();

	private static BoolType createBoolType() {
		return new BoolType();
	}

	private BoolType() {}
}
