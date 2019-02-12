package org.woehlke.javaee7.petclinic.dao;

import org.woehlke.javaee7.petclinic.entities.Visit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA. User: tw Date: 07.01.14 Time: 12:43 To change
 * this template use File | Settings | File Templates.
 */
@Stateless
public class VisitDaoImpl implements VisitDao {

    private static Logger log = Logger.getLogger(VisitDaoImpl.class.getName());

    @PersistenceContext(unitName = "javaee7petclinic")
    private EntityManager entityManager;


    @Override
    public void addNew(Visit visit) {
        entityManager.persist(visit);
    }

    @Override
    public void update(Visit visit) {
        visit = entityManager.merge(visit);
    }

    @Override
    public void getAll() {


    }

    @Override
    public List<Visit> getByVetId(int id) {
        // Get List of Visit by Id
        List<Visit> visits = new ArrayList<>();
        // Run SQL query :
        // SQL : Select name,id from Visit join Vet on vet_id = id where id:id
        // List
        // SQL
        Query q = entityManager.createNativeQuery("SELECT v.name, v.id FROM Visit v INNER JOIN Vet ON id = vet_id where v.id :=id");
        visits = q.getResultList();
        return visits;
    }

    @Override
    public List<Visit> getByPetId(int id) {



        return null;
    }

    @Override
    public void delete(Visit visit) {


    }



}
