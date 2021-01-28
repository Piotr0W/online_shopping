package pl.gov.govtech.pegasus.orders.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gov.govtech.pegasus.orders.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o1 " +
            "from Order o1 " +
            "where o1.id =(" +
            "   select max(o2.id) " +
            "   from Order o2 " +
            "   where o2.startDay = (" +
            "       select max(o3.startDay) " +
            "       from Order o3))")
    Order findLastOrder();

    @Modifying
    @Query("delete from Order o where o.startDay = (select max(o2.startDay) from Order o2)")
    void deleteLast();

}
