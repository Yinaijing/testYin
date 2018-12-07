package com.winterchen.mqtt.protocol.mqttImp.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class request {
    private String clientId;
    private String willTopic;
    private String userName;
    private String passWord;
    private String willMessage;

}
