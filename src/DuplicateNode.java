import java.util.ArrayList;
import java.util.List;

/**
 * Created by samuelkolb on 14/11/14.
 */
public class DuplicateNode<T extends Type> extends Node {

	public enum Ports {
		SOURCE1, SOURCE2, SOURCE3
	}

	public DuplicateNode(T type) {
		for(Ports port : Ports.values())
			addPort(port, Direction.BOTH, type);
	}

	@Override
	protected Value<?, ?> getPortValue(String name) {
		Ports portName = Ports.valueOf(name);
		List<Ports> others = new ArrayList<>();
		for(Ports port : Ports.values())
			if(port != portName)
				others.add(port);
		return pull(others.get(0));
	}
}
