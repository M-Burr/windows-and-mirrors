package com.capstone.windowsandmirrors.repositories;

import com.capstone.windowsandmirrors.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends CrudRepository<Tag, Long> {
    Tag findTagByIdentifier(String identifier);
}
