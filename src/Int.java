/**
 * Created by samuelkolb on 14/11/14.
 */
public class Int extends Value<NumberType, Int> {

	private final int integer;

	public int getInteger() {
		return integer;
	}

	public Int(int integer) {
		this.integer = integer;
		addFunction("+", this::sum);
		addFunction("-", this::minus);
	}

	@Override
	public NumberType getType() {
		return NumberType.TYPE;
	}

	public Int minus(Int[] array) {
		if(array.length == 0 || array.length > 2)
			throw new IllegalArgumentException();
		if(array.length == 2)
			return new Int(array[0].getInteger() - array[1].getInteger());
		return new Int(0 - array[0].getInteger());
	}

	public Int sum(Int[] array) {
		if(array.length == 0)
			throw new IllegalArgumentException();
		long sum = 0;
		for(Int i : array)
			sum += i.getInteger();
		return new Int((int)sum);
	}

	@Override
	public String toString() {
		return Integer.toString(getInteger());
	}
}
