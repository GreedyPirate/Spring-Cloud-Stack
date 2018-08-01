package com.ttyc.doc.extend.args;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

@Component
public class BootstrapArgs {

    @Autowired
    public BootstrapArgs(ApplicationArguments args) {
        boolean myargs = args.containsOption("myargs");
        Assert.state(myargs, "无法获取自定义参数");
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("nonOptionArgs : " + StringUtils.collectionToCommaDelimitedString(nonOptionArgs));
        Set<String> optionNames = args.getOptionNames();
        for (String optionName : optionNames) {
            List<String> optionValues = args.getOptionValues(optionName);
            System.out.println(optionValues);
        }
    }
}
