package pl.gov.govtech.pegasus.items.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.gov.govtech.pegasus.items.model.Department;
import pl.gov.govtech.pegasus.items.model.DepartmentId;
import pl.gov.govtech.pegasus.items.model.Item;
import pl.gov.govtech.pegasus.items.model.ItemType;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, DepartmentId> {

    Optional<Item> findByDepartmentId(DepartmentId departmentId);

    @Query("select it " +
            "from Item it " +
            "where it.itemType = :itemType " +
            "and it.departmentId.department = :department " +
            "and it.departmentId.id = (" +
            "   select max(it2.departmentId.id) " +
            "   from Item it2 " +
            "   where it2.itemType = :itemType " +
            "   and it2.departmentId.department = :department " +
            "   and not exists (" +
            "       select o.id " +
            "       from Order o " +
            "       where o.item = it2 " +
            "       and ((o.startDay = :startDay or o.startDay < :startDay and o.endDay > :startDay)" +
            "       or o.startDay = :endDay or (o.startDay < :endDay and o.endDay > :endDay))" +
            "       or (o.startDay > :startDay and :endDay > o.endDay)))")
    Optional<Item> getFirstFreeItem(@Param("department") Department department,
                                    @Param("itemType") ItemType itemType,
                                    @Param("startDay") LocalDateTime startDay,
                                    @Param("endDay") LocalDateTime endDay);

/*
    @Query("select it " +
            "from Item it " +
            "where it.itemType = :itemType " +
            "and it.departmentId.department = :department " +
            "and it.departmentId.id = (" +
            "   select max(it2.departmentId.id) " +
            "   from Item it2 " +
            "   where it2.itemType = :itemType " +
            "   and it2.departmentId.department = :department " +
            "   and not exists (" +
            "       select o.id " +
            "       from Order o " +
            "       where o.item = it2 " +
            "       and ((o.startDay = :startDay or o.startDay < :startDay and o.endDay > :startDay)" +
            "       or o.startDay = :endDay or (o.startDay < :endDay and o.endDay > :endDay))" +
            "       or (o.startDay > :startDay and :endDay > o.endDay)))")
    Optional<Item> getFreeItem(@Param("department") Department department,
                                    @Param("itemType") ItemType itemType,
                                    @Param("startDay") LocalDateTime startDay,
                                    @Param("endDay") LocalDateTime endDay);
*/

}
