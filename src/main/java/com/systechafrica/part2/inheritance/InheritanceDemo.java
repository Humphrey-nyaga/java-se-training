package com.systechafrica.part2.inheritance;

import com.systechafrica.part2.inheritance.company.QualityAssurance;
import com.systechafrica.part2.inheritance.company.SoftwareEngineer;

import java.util.logging.Logger;

public class InheritanceDemo {
    private static final Logger LOGGER = Logger.getLogger(InheritanceDemo.class.getName());
    public static void main(String[] args) {
       InheritanceDemo app = new InheritanceDemo();
       app.companySetup();
    }
    /* public void companySetup(){
        SoftwareEngineer e1 = new SoftwareEngineer();
        e1.setName("Gacungi");
        e1.setEmpNo("001");
        e1.setAddress("Nakawa - Kampala");
        e1.setTitle("Software Engineer");
        LOGGER.info("Software Engineer => " + e1.toString());

        QualityAssurance qa = new QualityAssurance();
        qa.setName("Harry");
        qa.setEmpNo("002");
        qa.setAddress("Westlands - Nairobi");
        qa.setTitle("Software Engineer in Test");
        LOGGER.info("Quality Assurance => " + qa.toString());

    }*/
    public void companySetup(){
        SoftwareEngineer e1 = new SoftwareEngineer("Gacungi","001","Nakawa - Kampala","Software Engineer");
        LOGGER.info("Software Engineer => " + e1.toString());

        QualityAssurance qa = new QualityAssurance("Harry","002","Westlands - Nairobi","Software Engineer in Test");
        LOGGER.info("Quality Assurance => " + qa.toString());

    }
}
