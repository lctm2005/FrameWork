package com.licong.webapp.controller;

import com.licong.repository.dao.GlobalConfigDao;
import com.licong.repository.domain.GlobalConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/globalconfig")
public class GlobalConfigController {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalConfigController.class);

    @Autowired
    private GlobalConfigDao globalConfigDao;

    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public GlobalConfig getGlobalConfig(@PathVariable Long id) {
        return globalConfigDao.findOne(id);
    }
}
