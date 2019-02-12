package org.woehlke.javaee7.petclinic.model;


import org.woehlke.javaee7.petclinic.entities.Pet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
public class Pets  {

    private List<Pet> petList;

    @XmlElement
    public List<Pet> getPetList() {
        if (petList == null) {
            petList = new ArrayList<Pet>();
        }
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }


}
