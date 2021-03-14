package com.challenge.topcoder.bullettrain.controller;

import com.challenge.topcoder.bullettrain.dto.GenericResponse;
import com.challenge.topcoder.bullettrain.entity.TrainEntity;
import com.challenge.topcoder.bullettrain.error.EntityEmptyException;
import com.challenge.topcoder.bullettrain.error.HandlerNotFoundException;
import com.challenge.topcoder.bullettrain.error.ResourceNotFoundException;
import com.challenge.topcoder.bullettrain.repository.TrainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TrainController {

    private static final boolean _DEBUG_ = true;

    @Autowired
    TrainRepository trainRepository;

    @GetMapping("/**")
    public ModelAndView noMappingFound() throws HandlerNotFoundException {
        if(_DEBUG_) { System.out.println("Get Mapping Not /trains"); }
        throw new HandlerNotFoundException("invalid endpoint");
    }

    @GetMapping("/trains/**")
    public ModelAndView noTrainsMappingFound() throws HandlerNotFoundException {
        if(_DEBUG_) { System.out.println("Get Mapping Not /trains/**"); }
        throw new HandlerNotFoundException("invalid endpoint");
    }

    @GetMapping("/trains")
    public ResponseEntity<List<TrainEntity>> getAllTrains(@RequestParam(required = false) String name,
                                                          @RequestParam(required = false) String amenities) {
        if(_DEBUG_) { System.out.println("Get Mapping /trains Name or Amenities"); }
        try {
            List<TrainEntity> trains = new ArrayList<TrainEntity>();

            if (name == null && amenities == null)
                trainRepository.findAll().forEach(trains::add);
            else if (name != null && amenities == null)
                trainRepository.findByNameContaining(name).forEach(trains::add);
            else if (name == null && amenities != null)
                trainRepository.findByAmenitiesContaining(amenities).forEach(trains::add);
            else
                trainRepository.findByNameContainingAndAmenitiesContaining(name, amenities).forEach(trains::add);

            if (trains.isEmpty()) {
                throw new EntityEmptyException("train not found");
            }

            return new ResponseEntity<>(trains, HttpStatus.OK);
        }
        catch (HandlerNotFoundException e) {
            throw new HandlerNotFoundException("invalid endpoint");
        }
        catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("train not found");
        }
    }

    @GetMapping("/trains/{id}")
    public ResponseEntity<TrainEntity> getTrainById(@PathVariable("id") String id) {
        if (_DEBUG_) {
            System.out.println("Get Mapping /trains Id");
        }

        try {
            Long long_id = Long.parseLong(id);
            TrainEntity trainData = trainRepository.findById(long_id)
                    .orElseThrow(() -> new ResourceNotFoundException("train not found"));

            return new ResponseEntity<>(trainData, HttpStatus.OK);
        }
        catch(NumberFormatException e) {
            throw new HandlerNotFoundException("invalid endpoint");
        }


    }

    @GetMapping("/trains/sharing-tracks")
    public ResponseEntity<List<TrainEntity>> getTrainBySharingTracks() {
        if(_DEBUG_) { System.out.println("Get Mapping /trains Sharing Tracks"); }
        List<TrainEntity> trains = new ArrayList<TrainEntity>();

        trainRepository.findBySharingTracks(true).forEach(trains::add);

        if (trains.isEmpty()) {
            throw new EntityEmptyException("train not found");
        }

        return new ResponseEntity<>(trains, HttpStatus.OK);
    }

    @DeleteMapping("/trains/{id}")
    public ResponseEntity<GenericResponse> deleteById(@PathVariable("id") long id) {
        try {
            trainRepository.deleteById(id);

            return new ResponseEntity<>(new GenericResponse("train removed successfully", null), HttpStatus.OK);
        }
        catch (ResourceNotFoundException e){
            return new ResponseEntity<>(new GenericResponse("train not found", null), HttpStatus.NOT_FOUND);
        }
    }
}
