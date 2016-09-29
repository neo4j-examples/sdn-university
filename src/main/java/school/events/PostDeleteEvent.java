package school.events;

import org.neo4j.ogm.session.event.Event;
import org.springframework.context.ApplicationEvent;

public class PostDeleteEvent extends ApplicationEvent {

	public PostDeleteEvent( Event event) {
		super(event);
	}
}
