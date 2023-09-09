package com.systechafrica.pos;

import java.util.logging.Logger;

public class PointOfSale {
    private static final Logger LOGGER = Logger.getLogger(PointOfSale.class.getName());
    public static void main(String[] args) {
        Authentication authentication = new Authentication();
       if(authentication.login()){
           LOGGER.info("Successful Login");
       }else {
           System.exit(-1);
       }
    }
}
