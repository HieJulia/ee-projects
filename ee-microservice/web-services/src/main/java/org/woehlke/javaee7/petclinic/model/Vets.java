package org.woehlke.javaee7.petclinic.model;

import org.woehlke.javaee7.petclinic.entities.Vet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Vets {

    private List<Vet> vetList;
    

    @XmlElement
    public List<Vet> getVetList() {
        if (vetList == null) {
            vetList = new ArrayList<Vet>();
        }
        return vetList;
    }

    public void setVetList(List<Vet> vetList) {
        this.vetList = vetList;
    }


}



// Dung chinh sua - hay add them