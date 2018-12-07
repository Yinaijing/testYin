package com.winterchen.controller;

import com.winterchen.mqtt.protocol.mqttImp.Handler.DBHandler;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {



        @RequestMapping(value = "/test",method = RequestMethod.GET)

        public JSONArray helloData(){
            JSONArray json = JSONArray.fromObject(new DBHandler().getResponseArduinos());
            String data1="{\n" +
                    "\t\"deviceData\": [{\n" +
                    "\t\t\t\"deviceId\": \"#1001\",\n" +
                    "\t\t\t\"deviceName\": \"device1\",\n" +
                    "\t\t\t\"voltage\": \"220.5\",\n" +
                    "\t\t\t\"current\": \"33.0\",\n" +
                    "\t\t\t\"temp\": \"22.1\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"deviceId\": \"#1002\",\n" +
                    "\t\t\t\"deviceName\": \"device2\",\n" +
                    "\t\t\t\"voltage\": \"239.99\",\n" +
                    "\t\t\t\"current\": \"33.4\",\n" +
                    "\t\t\t\"temp\": \"22.2\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"deviceId\": \"#1001\",\n" +
                    "\t\t\t\"deviceName\": \"device1\",\n" +
                    "\t\t\t\"voltage\": \"220.5\",\n" +
                    "\t\t\t\"current\": \"33.0\",\n" +
                    "\t\t\t\"temp\": \"22.3\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"deviceId\": \"#1001\",\n" +
                    "\t\t\t\"deviceName\": \"device1\",\n" +
                    "\t\t\t\"voltage\": \"220.5\",\n" +
                    "\t\t\t\"current\": \"33.87\",\n" +
                    "\t\t\t\"temp\": \"22.4\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"002\"\n" +
                    "\t\t}]}";
            String data2="{\n" +
                    "\t\"deviceData\": [{\n" +
                    "\t\t\t\"deviceId\": \"#1001\",\n" +
                    "\t\t\t\"deviceName\": \"device1\",\n" +
                    "\t\t\t\"voltage\": \"220.5\",\n" +
                    "\t\t\t\"current\": \"33.87\",\n" +
                    "\t\t\t\"temp\": \"22.4\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"002\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"deviceId\": \"#1002\",\n" +
                    "\t\t\t\"deviceName\": \"device2\",\n" +
                    "\t\t\t\"voltage\": \"220.5\",\n" +
                    "\t\t\t\"current\": \"33.99\",\n" +
                    "\t\t\t\"temp\": \"22.5\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"deviceId\": \"#1001\",\n" +
                    "\t\t\t\"deviceName\": \"device1\",\n" +
                    "\t\t\t\"voltage\": \"220.5\",\n" +
                    "\t\t\t\"current\": \"31.00\",\n" +
                    "\t\t\t\"temp\": \"22.6\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t}]}";

            String data3="{\n" +
                    "\t\"deviceData\": [{\n" +
                    "\t\t\"deviceId\": \"#1002\",\n" +
                    "\t\t\"deviceName\": \"device2\",\n" +
                    "\t\t\"voltage\": \"220.5234\",\n" +
                    "\t\t\"current\": \"330\",\n" +
                    "\t\t\"temp\": \"22.7\",\n" +
                    "\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\"stateCode\": \"001\"\n" +
                    "\t}]\n" +
                    "}";


            String data4="{\n" +
                    "\t\"deviceData\": [{\n" +
                    "\t\t\t\"deviceId\": \"#1002\",\n" +
                    "\t\t\t\"deviceName\": \"device2\",\n" +
                    "\t\t\t\"voltage\": \"220.5234\",\n" +
                    "\t\t\t\"current\": \"330\",\n" +
                    "\t\t\t\"temp\": \"22.7\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"deviceId\": \"#1001\",\n" +
                    "\t\t\t\"deviceName\": \"device1\",\n" +
                    "\t\t\t\"voltage\": \"230.5\",\n" +
                    "\t\t\t\"current\": \"330\",\n" +
                    "\t\t\t\"temp\": \"22.8\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"deviceId\": \"#1003\",\n" +
                    "\t\t\t\"deviceName\": \"device3\",\n" +
                    "\t\t\t\"voltage\": \"220.78\",\n" +
                    "\t\t\t\"current\": \"32.78\",\n" +
                    "\t\t\t\"temp\": \"22.9\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t}\n" +
                    "\t]\n" +
                    "}";

            String data5="{\n" +
                    "\t\"deviceData\": [{\n" +
                    "\t\t\t\"deviceId\": \"#1001\",\n" +
                    "\t\t\t\"deviceName\": \"device1\",\n" +
                    "\t\t\t\"voltage\": \"220.5\",\n" +
                    "\t\t\t\"current\": \"43.2\",\n" +
                    "\t\t\t\"temp\": \"21.5\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"deviceId\": \"#1001\",\n" +
                    "\t\t\t\"deviceName\": \"device1\",\n" +
                    "\t\t\t\"voltage\": \"920.3\",\n" +
                    "\t\t\t\"current\": \"22.0\",\n" +
                    "\t\t\t\"temp\": \"20.5\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"deviceId\": \"#1004\",\n" +
                    "\t\t\t\"deviceName\": \"device4\",\n" +
                    "\t\t\t\"voltage\": \"220.5\",\n" +
                    "\t\t\t\"current\": \"30.9\",\n" +
                    "\t\t\t\"temp\": \"23.5\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"001\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"deviceId\": \"#1001\",\n" +
                    "\t\t\t\"deviceName\": \"device1\",\n" +
                    "\t\t\t\"voltage\": \"880.5\",\n" +
                    "\t\t\t\"current\": \"32.4\",\n" +
                    "\t\t\t\"temp\": \"24.5\",\n" +
                    "\t\t\t\"date\": \"2018.10.23\",\n" +
                    "\t\t\t\"stateCode\": \"003\"\n" +
                    "\t\t}\n" +
                    "\t]\n" +
                    "}";



            String[] data = {data1,data2,data3,data4,data5,data2,data3,data4,data2,data1};

            int rand = (int)(1+Math.random()*9)-1;
            return json;

        }
    }

