module com.hirrao.socketclient {
    requires java.base;
    requires com.google.gson;
    requires org.apache.logging.log4j;
    requires org.apache.commons.cli;

    exports com.hirrao.socketclient.main;
}