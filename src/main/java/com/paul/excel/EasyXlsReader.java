package com.paul.excel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EasyXlsReader {
    public static void main(String[] args) throws FileNotFoundException {
        List<Long> bizs = new ArrayList<>();
        bizs.add(1000L);
        bizs.add(2000L);
        System.out.println(JSON.toJSONString(bizs));
    }
}
