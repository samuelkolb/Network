/**
 * Created by samuelkolb on 14/11/14.
 */
public class FunctionDescriptor<T extends Type> {

	private final T parameterType;

	public T getParameterType() {
		return parameterType;
	}

	private final String name;

	public String getName() {
		return name;
	}

	public FunctionDescriptor(T parameterType, String name) {
		this.parameterType = parameterType;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FunctionDescriptor that = (FunctionDescriptor) o;

		if (!name.equals(that.name)) return false;
		if (!parameterType.equals(that.parameterType)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = parameterType.hashCode();
		result = 31 * result + name.hashCode();
		return result;
	}
}
