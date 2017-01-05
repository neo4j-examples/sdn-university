/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
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
