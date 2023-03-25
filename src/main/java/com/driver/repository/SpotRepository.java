package com.driver.repository;

import com.driver.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer>{

    @Query(value = "select s.id from spot s where s.parking_lot_id=:parkingLotId and s.occupied=0 and s.spot_type=:spotType order by price_per_hour ASC limit 1",nativeQuery = true)
    int findSpot(Integer parkingLotId, String spotType);
}
