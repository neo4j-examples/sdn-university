package school.events;

import org.neo4j.ogm.session.event.Event;
import org.springframework.context.ApplicationEvent;

public class PreDeleteEvent extends ApplicationEvent {

	public PreDeleteEvent( Event event) {
		super(event);
	}
}
