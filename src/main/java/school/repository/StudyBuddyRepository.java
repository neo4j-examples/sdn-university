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
package school.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;
import school.domain.StudyBuddy;

import java.util.Map;

public interface StudyBuddyRepository extends CrudRepository<StudyBuddy, Long> {

	@Query("MATCH(s:StudyBuddy)<-[:BUDDY]-(p:Student) RETURN p, count(s) AS buddies ORDER BY buddies DESC")
	Iterable<Map<String, Object>> getStudyBuddiesByPopularity();
}
