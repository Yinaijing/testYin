package com.winterchen.service.user;

import com.winterchen.model.arduino;
import com.winterchen.model.exceptionArduino;

public interface ArduinoService {
    int addArduino(arduino au);
    int addExceptionArduino(exceptionArduino au);
}
