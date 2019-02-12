package org.woehlke.javaee7.petclinic.entities;

import lombok.Data;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Digits;

import java.util.*;


@Entity
@Table(name = "owners")
@Indexed // Add hibernate index
@Data
public class Owner {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    private String firstName; // Find owner by name : SQL: Select * from Owner where firstName := name
    // Index : name field


    @Column(name = "last_name")
    @NotEmpty
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String lastName;

    @Column(name = "address")
    @NotEmpty
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String address; // search owner by address - su dung hibernate index

    @Column(name = "city")
    @NotEmpty
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO) // select * from owner where
    private String city;
    // select * from owner where city := city



    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    // Owner has many pets
    @IndexedEmbedded
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner",fetch = FetchType.EAGER)
    private Set<Pet> pets = new TreeSet<Pet>();
    // Find Owner by pet : Select * from Owner inner join Pet on id = pet_id where owner.id = id


    // owner - pet



    public void addPet(Pet pet){
        pets.add(pet);
        pet.setOwner(this);
    }




}
