package com.david.citasMedicas.exception;

import com.david.citasMedicas.exception.enums.ResultEnum;

public class Exceptions extends RuntimeException{

    private final Integer code;

    public Exceptions(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public Exceptions(Integer code, String message){
        super(message);
        this.code=code;
    }
}
