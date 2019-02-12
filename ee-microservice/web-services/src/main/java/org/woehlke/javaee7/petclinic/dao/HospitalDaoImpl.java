package org.woehlke.javaee7.petclinic.dao;

import org.woehlke.javaee7.petclinic.entities.Hospital;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class HospitalDaoImpl implements HospitalDao {
    // Service = Stateless



    @Override
    public List<Hospital> getAll() {
        return null;
    }

    @Override
    public void addNew(Hospital hospital) {

    }

    @Override
    public List<Hospital> searchByType(String type) {
        return null;
    }
}
