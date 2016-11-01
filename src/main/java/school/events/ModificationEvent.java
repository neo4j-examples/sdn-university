package school.events;

import org.neo4j.ogm.session.event.Event;

/**
 * Created by markangrish on 02/11/2016.
 */
public class ModificationEvent {

	private Event source;

	public ModificationEvent(Event source) {
		this.source = source;
	}

	public Event getSource() {
		return source;
	}
}
