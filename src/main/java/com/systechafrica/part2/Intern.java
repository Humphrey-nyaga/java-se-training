package com.systechafrica.part2;

import com.systechafrica.atmmachine.ATMMachine;

import java.util.logging.Logger;

public class Intern {
    private static final Logger LOGGER = Logger.getLogger(Intern.class.getName());

    String name;
    String phoneNumber;
    String email;

    public void attendClass() {
        LOGGER.info("Attended Class");
    }

    public void doAssignment() {
        LOGGER.info("Do Assignment");
    }
}
