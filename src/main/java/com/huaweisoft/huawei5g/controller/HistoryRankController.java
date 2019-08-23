package com.huaweisoft.huawei5g.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("历史排行")
@RestController
@RequestMapping(value = "/admin")
public class HistoryRankController {
    @RequestMapping(value = "/getHistoryRank", method = RequestMethod.POST)
    public Object getHistoryRank() {
        return null;
    }

    @RequestMapping(value = "/exportHisRank", method = RequestMethod.GET)
    public Object exportHisRank() {
        return null;
    }
}
