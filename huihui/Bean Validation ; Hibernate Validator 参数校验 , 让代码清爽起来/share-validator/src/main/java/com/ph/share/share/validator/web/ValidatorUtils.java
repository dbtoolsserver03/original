package com.ph.share.share.validator.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Validator;


@Component
public class ValidatorUtils {

    public static Validator validator;

    @Autowired
    public void setValidator(Validator validator) {
        ValidatorUtils.validator = validator;
    }
}
