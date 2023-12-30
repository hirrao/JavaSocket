package com.hirrao.socketclient.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Program Started");
        Parameter parameter = new Parameter();
        parameter.parsing(args);
    }
}