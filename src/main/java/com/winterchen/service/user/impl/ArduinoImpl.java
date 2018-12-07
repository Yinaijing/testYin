package com.winterchen.service.user.impl;

import com.winterchen.dao.arduinoMapper;
import com.winterchen.dao.exceptionArduinoMapper;
import com.winterchen.model.arduino;
import com.winterchen.model.exceptionArduino;
import com.winterchen.service.user.ArduinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "arduinoService")
public class ArduinoImpl implements ArduinoService {
    @Autowired(required = true)
    private arduinoMapper arduinoMapper1;
    @Autowired(required = true)
    private exceptionArduinoMapper exceptionArduinoMapper1;
    @Override
    public int addArduino(arduino au) {
        return   arduinoMapper1.insert(au);
    }

    @Override
    public int addExceptionArduino(exceptionArduino reArduino) {
        return exceptionArduinoMapper1.insert(reArduino);
    }
}
