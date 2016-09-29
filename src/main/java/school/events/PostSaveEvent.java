package school.events;

import org.neo4j.ogm.session.event.Event;
import org.springframework.context.ApplicationEvent;

public class PostSaveEvent extends ApplicationEvent {

	public PostSaveEvent(Event event) {
		super(event);
	}
}
