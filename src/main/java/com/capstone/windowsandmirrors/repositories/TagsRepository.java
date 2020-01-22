package com.capstone.windowsandmirrors.repositories;

import com.capstone.windowsandmirrors.models.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends CrudRepository<Tag, Long> {
    @Query(
            value = "select * from tags where lower(identifier)=lower(?1)",
            nativeQuery = true
    )
    Tag findTagByIdentifier(String identifier);
}
