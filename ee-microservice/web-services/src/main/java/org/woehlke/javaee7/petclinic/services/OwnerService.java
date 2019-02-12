package org.woehlke.javaee7.petclinic.services;

import org.woehlke.javaee7.petclinic.entities.Visit;

/**
 * Created by tw on 10.03.14.
 */
public interface OwnerService {


    // owner - book a visit
    void addNewVisit(Visit visit);
}
