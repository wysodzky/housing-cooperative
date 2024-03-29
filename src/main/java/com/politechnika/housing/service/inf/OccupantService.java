package com.politechnika.housing.service.inf;

import com.politechnika.housing.exception.OccupantNotFoundException;
import com.politechnika.housing.model.Occupant;

import java.util.List;

public interface OccupantService {

    int save(Occupant occupant);

    Occupant get(int id) throws OccupantNotFoundException;

    int update(Occupant occupant);

    void delete(int id) throws OccupantNotFoundException;

    void addPremisesToOccupant(int premisesId, int occupantId);

    void deletePremisesFromOccupant(int premisesId, int occupantId);

    List<Occupant> getAll();
}
