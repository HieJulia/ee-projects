package org.woehlke.javaee7.petclinic.entities;

import lombok.Data;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "hospitals")
@Indexed
@Data // get - set - construction
public class Hospital {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotEmpty
    @Field(index= org.hibernate.search.annotations.Index.YES, analyze= Analyze.YES, store= Store.NO) // Add hibernate index search field for name
    private String name;

    @Column(name = "address")
    @NotEmpty
    @Field(index= org.hibernate.search.annotations.Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String address;

    @Column(name = "city")
    @NotEmpty
    @Field(index= Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String city;

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    // One Hospital - has many vets

    // One vet belong to only one hospital - One - Many

    @IndexedEmbedded
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospital",fetch = FetchType.EAGER)
    private Set<Vet> vets = new TreeSet<Vet>();


    // Type of hospital

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id")
    private HospitalType type;



}
