package com.challenge.topcoder.bullettrain.repository;

import com.challenge.topcoder.bullettrain.entity.TrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<TrainEntity, Long> {

    List<TrainEntity> findByNameContaining(String name);

    List<TrainEntity> findBySharingTracks(boolean sharingTracks);

    List<TrainEntity> findByAmenitiesContaining(String amenities);

    List<TrainEntity> findByNameContainingAndAmenitiesContaining(String name, String amenities);
}
