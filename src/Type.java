import vector.Vector;

import java.util.List;
import java.util.Map;

/**
 * Created by samuelkolb on 13/11/14.
 *
 * @author Samuel Kolb
 */
public abstract class Type {

	//region Variables
	private Vector<FunctionDescriptor> functions;

	public Vector<FunctionDescriptor> getSupportedFunctions() {
		return functions;
	}

	public void addFunction(FunctionDescriptor descriptor) {
		functions = functions.grow(descriptor);
	}

	//endregion

	//region Construction

	protected Type() {
		this(new Vector<>());
	}

	protected Type(Vector<FunctionDescriptor> functions) {
		this.functions = functions;
	}

	//endregion

	//region Public methods

	//endregion
}
