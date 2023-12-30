package com.hirrao.socketclient.main;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.DefaultParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Parameter {

    private static final Logger logger = LogManager.getLogger(Parameter.class);
    private final Options options = new Options()
            .addOption("h", "help", false, "显示帮助")
            .addOption("v", "version", false, "显示版本信息")
            .addOption("o", "options", true, "指定选项")
            .addOption("s", "server", true, "指定服务器地址");

    void parsing(String[] args) {
        try {
            logger.info("Parsing parameters");
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("h")) Help.printMainHelp();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
