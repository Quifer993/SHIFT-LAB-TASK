package ru.zolotorevskii.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.zolotorevskii.task.entity.LetterEntity;

@Repository
public interface LettersRepository extends JpaRepository<LetterEntity,Integer> {
@Query("""
            select distinct ls from LetterEntity ls
            where ls.end = (select min(ls.end) from LetterEntity ls
            where ls.start = (select min(ls.start) from LetterEntity ls))
            and ls.start = (select min(ls.start) from LetterEntity ls)
            """)
        LetterEntity searchMin();
}
