package com.politechnika.housing.controller;

import com.politechnika.housing.exception.BuildingNotFoundException;
import com.politechnika.housing.model.Building;
import com.politechnika.housing.model.Premises;
import com.politechnika.housing.service.inf.BuildingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;


@RestController
@RequestMapping("/building")
public class BuildingController {

    private static final Logger logger = Logger.getLogger(BuildingController.class);

    @Autowired
    private BuildingService buildingService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getBuilding(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(buildingService.get(id));
        } catch (BuildingNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createBuilding(@RequestBody Building building) {
        int id = buildingService.save(building);
        return ResponseEntity.ok(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity updateBuilding(@RequestBody Building building) {
        int id = buildingService.save(building);
        return ResponseEntity.ok(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteBuilding(@PathVariable("id") int id) throws BuildingNotFoundException {
        buildingService.delete(id);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{buildingId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addPremisesToBuilding(@RequestBody Premises premises, @PathVariable("buildingId") int buildingId) {
        buildingService.addPremisesToBuilding(premises, buildingId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{premisesId}/{buildingId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deletePremisesFromBuilding(@PathVariable("premisesId") int premisesId, @PathVariable("buildingId") int buildingId) {
        buildingService.deletePremisesFromBuidling(premisesId, buildingId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllBuildings() {
        return ResponseEntity.ok(buildingService.getAll());
    }

    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getPremisesForBuilding(@PathVariable("id") int buildingId) throws BuildingNotFoundException {
        return ResponseEntity.ok(buildingService.getPremisesForBuilding(buildingId));
    }

    @RequestMapping(value = "/manager/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getBuildingsForManager(@PathVariable("id") int managerId) {
        return ResponseEntity.ok(buildingService.getBuildingsForManageR(managerId));
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllAvailableBuildings() {
        return ResponseEntity.ok(buildingService.gettAllAvailableBuildings());
    }
}
