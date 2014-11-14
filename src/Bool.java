/**
 * Created by samuelkolb on 13/11/14.
 */
public class Bool extends Value<BoolType, Bool> {

	private final boolean bool;

	public boolean isTrue() {
		return bool;
	}

	public Bool(boolean bool) {
		this.bool = bool;
	}

	@Override
	public BoolType getType() {
		return BoolType.TYPE;
	}
}
