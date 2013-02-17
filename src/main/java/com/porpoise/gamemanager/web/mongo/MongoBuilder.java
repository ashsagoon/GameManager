package com.porpoise.gamemanager.web.mongo;

import com.mongodb.Mongo;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.util.StringUtils.commaDelimitedListToStringArray;

public class MongoBuilder {

    public Mongo buildMongoInstance(String serverAddressString, int port) throws UnknownHostException {
        List<String> serverAddressStrings = newArrayList(commaDelimitedListToStringArray(serverAddressString));

        if (serverAddressStrings.size() > 1) {
            List<ServerAddress> serverAddresses = newArrayList();

            for (String address : serverAddressStrings) {
                serverAddresses.add(new ServerAddress(address, port));
            }

            return new Mongo(serverAddresses);
        }

        return new Mongo(serverAddressStrings.get(0), port);
    }
}
