package org.woehlke.javaee7.petclinic.model;


import lombok.Data;
import org.woehlke.javaee7.petclinic.entities.Owner;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@Data
public class Owners {

    // Get list of Owners -


    private List<Owner> ownerList;
}
