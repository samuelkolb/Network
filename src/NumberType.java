/**
 * Created by samuelkolb on 14/11/14.
 */
public class NumberType extends Type {

	public static NumberType TYPE = createNumberType();

	private static NumberType createNumberType() {
		NumberType type = new NumberType();
		type.addFunction(new FunctionDescriptor<>(type, "+"));
		type.addFunction(new FunctionDescriptor<>(type, "-"));
		return type;
	}

	private NumberType() {}
}
