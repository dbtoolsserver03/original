package com.ph.share.share.validator.web;

import com.ph.share.share.validator.enums.ErrorCode;
import com.ph.share.share.validator.exception.ListValidException;
import com.ph.share.share.validator.vo.ResultVO;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice(basePackages = "com.ph.share.share.validator.controller")
@ResponseBody
public class CtrlAdvice {

    @ExceptionHandler
    public ResultVO exceptionHandler(MethodArgumentNotValidException e){
        /**
         * id - 主键不可以有值
         * name - name 不能为空
         */
        Map<String, String> collect = e.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        return ResultVO.fail(ErrorCode.PARAM_ERROR,collect);
    }

    @ExceptionHandler
    public ResultVO exceptionHandler(ConstraintViolationException e){
        Map<Path, String> collect = e.getConstraintViolations().stream()
                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
        return ResultVO.fail(ErrorCode.PARAM_ERROR,collect);
    }


    @ExceptionHandler
    public ResultVO exceptionHandler(ValidationException e){
        Map<Integer, Map<Path, String>> map = new HashMap<>();

        ((ListValidException)e.getCause()).getErrors().forEach((integer, constraintViolations) -> {
            map.put(integer, constraintViolations.stream()
                    .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage)));
        });
        return ResultVO.fail(ErrorCode.PARAM_ERROR,map);
    }

    @ExceptionHandler
    public ResultVO exceptionHandler(Exception e){
        return ResultVO.fail(ErrorCode.SYSTEM_ERROR);
    }
}
