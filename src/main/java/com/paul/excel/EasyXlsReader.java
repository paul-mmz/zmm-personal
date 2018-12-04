package com.paul.excel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EasyXlsReader {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("C:/Users/hzzhouminmin/Desktop/地址库.xlsx")));
//        InputStream inputStream = ClassLoader.getSystemResourceAsStream("地址库.xlsx");

        List<Object> contents = new ArrayList<>();

        ExcelReader excelReader = new ExcelReader(inputStream, null, new AnalysisEventListener<Object>() {

            @Override
            public void invoke(Object object, AnalysisContext context) {
                contents.add(object);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println("finish excel reader");
            }
        });

        excelReader.read();

        System.out.println(contents);
    }
}
