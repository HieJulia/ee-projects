package org.woehlke.javaee7.petclinic.dao;

import java.util.List;

import org.woehlke.javaee7.petclinic.entities.Visit;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 07.01.14
 * Time: 12:43
 * To change this template use File | Settings | File Templates.
 */
public interface VisitDao {

    // Create new visit 

    void addNew(Visit visit);


    // Updata visit 
    void update(Visit visit);

    // Get all visit 
    void getAll();


    // Get visit by Vet 
    List<Visit> getByVetId(int id);
    

    // Get all visits by Pet 
    List<Visit> getByPetId(int id);


    // Delete visit 
    void delete(Visit visit);

    

}
