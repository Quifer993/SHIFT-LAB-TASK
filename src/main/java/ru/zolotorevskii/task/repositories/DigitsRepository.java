package ru.zolotorevskii.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.zolotorevskii.task.entity.DigitEntity;

@Repository
public interface DigitsRepository extends JpaRepository<DigitEntity,Integer> {
    @Query("""
            select distinct ds from DigitEntity ds
            where ds.end = (select min(ds.end) from DigitEntity ds
            where ds.start = (select min(ds.start) from DigitEntity ds))
            and ds.start = (select min(ds.start) from DigitEntity ds)
            """)
    DigitEntity searchMin();
}
