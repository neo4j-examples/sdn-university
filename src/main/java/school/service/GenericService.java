package school.service;

import org.springframework.data.neo4j.repository.GraphRepository;

import school.domain.Entity;

public abstract class GenericService<T> implements Service<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;

    @Override
    public Iterable<T> findAll() {
        return getRepository().findAll(DEPTH_LIST);
    }

    @Override
    public T find(Long id) {
        return getRepository().findOne(id, DEPTH_ENTITY);
    }

    @Override
    public void delete(Long id) {
        getRepository().delete(id);
    }

    @Override
    public T createOrUpdate(T entity) {

        Entity e = (Entity) entity;

        getRepository().save(entity, DEPTH_ENTITY);

        // NOTE: This is populated for entities but null for ones annotated with @RelationshipEntity, such as TeacherAndStudentRelationship
        Long id = e.getId();

        // return find(id); // NOTE: This blows up for entities with @RelationshipEntity, since they are not being persisted / their id is null
        return entity;
    }

    public abstract GraphRepository<T> getRepository();
}
