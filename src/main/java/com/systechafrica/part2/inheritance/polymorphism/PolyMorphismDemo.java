package com.systechafrica.part2.inheritance.polymorphism;

import com.systechafrica.part2.inheritance.protectedaccessmodifier.nomenclature.genus.Genus;
import com.systechafrica.part2.inheritance.protectedaccessmodifier.nomenclature.kingdom.Kingdom;
import com.systechafrica.part2.inheritance.protectedaccessmodifier.nomenclature.species.Species;
import com.systechafrica.part2.inheritance.company.DatabaseEngineer;
import com.systechafrica.part2.inheritance.company.Employee;
import com.systechafrica.part2.inheritance.company.QualityAssurance;
import com.systechafrica.part2.inheritance.company.SoftwareEngineer;

public class PolyMorphismDemo {
    public static void main(String[] args) {

        Employee james = new QualityAssurance("001", "James",
                "047", "Quality Assurance Chief Engineer");

        Employee ivy = new SoftwareEngineer("002", "Ivy",
                "035", "Senior Software Engineer");

        Employee lenna = new DatabaseEngineer("003", "Lenna",
                "035", "Senior Database Engineer");

        System.out.println(james);
        System.out.println(ivy);
        System.out.println(lenna);


        Kingdom species = new Species();
        Kingdom genus = new Genus();


    }
}
