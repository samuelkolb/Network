import association.Association;
import association.ListAssociation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by samuelkolb on 13/11/14.
 *
 * @author Samuel Kolb
 */
public class Node {

	//region Variables

	private final Map<String, Port<?>> ports = new HashMap<String, Port<?>>();

	void addPort(String name, Port.Direction direction, Type<T> type) {
		ports.put(port.getName(), port);
	}

	//endregion

	//region Construction

	public Node() {
	}

	//endregion

	//region Public methods
	public <T> Port<T> getPort(String name, Type<T> type) {
		Port<?> port = ports.get(name);
		if(port.getType().equals(type))
			return (Port<T>) port;
		throw new IllegalArgumentException();
	}
	//endregion
}
