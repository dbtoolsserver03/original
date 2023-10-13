package com.ph.share.share.validator.controller;


import com.ph.share.share.validator.entity.Job;
import com.ph.share.share.validator.vo.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/job")
@Validated
public class JobController {
    @PostMapping
    public ResultVO add(@RequestBody @Valid Job job) {
        return ResultVO.success();
    }
}
