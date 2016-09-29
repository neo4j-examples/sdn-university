package school.events;

import org.neo4j.ogm.session.event.Event;
import org.springframework.context.ApplicationEvent;

public class PreSaveEvent extends ApplicationEvent {

	public PreSaveEvent(Event event) {
		super(event);
	}
}
