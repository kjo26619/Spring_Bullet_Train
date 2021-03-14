package com.challenge.topcoder.bullettrain.entity;

import javax.persistence.*;

@Entity
@Table(name = "trains")
public class TrainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "distance_btw_stop")
    private String distanceBtwStop;

    @Column(name = "max_speed")
    private String maxSpeed;

    @Column(name = "sharing_tracks")
    private Boolean sharingTracks;

    @Column(name = "grade_crossing")
    private Boolean gradeCrossing;

    @Column(name = "train_frequency")
    private String trainFrequency;

    @Column(name = "amenities")
    private String amenities;

    public TrainEntity() {

    }
    public TrainEntity(long id, String name, String description, String distanceBtwStop, String maxSpeed, Boolean sharingTracks,
                       Boolean gradeCrossing, String trainFrequency, String amenities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.distanceBtwStop = distanceBtwStop;
        this.maxSpeed = maxSpeed;
        this.sharingTracks = sharingTracks;
        this.gradeCrossing = gradeCrossing;
        this.trainFrequency = trainFrequency;
        this.amenities = amenities;
    }

    /************/
    /** Getter **/
    /************/
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDistanceBtwStop() {
        return distanceBtwStop;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public Boolean getSharingTracks() {
        return sharingTracks;
    }

    public Boolean getGradeCrossing() {
        return gradeCrossing;
    }

    public String getTrainFrequency() {
        return trainFrequency;
    }

    public String getAmenities() {
        return amenities;
    }

    /************/
    /** Setter **/
    /************/
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDistanceBtwStop(String distanceBtwStop) {
        this.distanceBtwStop = distanceBtwStop;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setSharingTracks(Boolean sharingTracks) {
        this.sharingTracks = sharingTracks;
    }

    public void setGradeCrossing(Boolean gradeCrossing) {
        this.gradeCrossing = gradeCrossing;
    }

    public void setTrainFrequency(String trainFrequency) {
        this.trainFrequency = trainFrequency;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString(){
        return "Train [id = " + id + ", name = " + name + ", description = " + description + ", distance-between-stop = " +
                distanceBtwStop + ", max-speed = " + maxSpeed + ", sharing-tracks = " + sharingTracks + ", grade-crossing = " +
                gradeCrossing + ", train-frequency" + trainFrequency + ", amenities = " + amenities;
    }
}
