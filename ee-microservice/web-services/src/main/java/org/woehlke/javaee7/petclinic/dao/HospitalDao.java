package org.woehlke.javaee7.petclinic.dao;

import org.woehlke.javaee7.petclinic.entities.Hospital;
import org.woehlke.javaee7.petclinic.entities.Vet;

import java.util.List;

public interface HospitalDao {

    // Get all
    List<Hospital> getAll();

    // Add new Hospital
    void addNew(Hospital hospital);


    // Search hospital by type
    List<Hospital> searchByType(String type);



}
