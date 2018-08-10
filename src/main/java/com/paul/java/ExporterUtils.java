package com.paul.java;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ExporterUtils {

    private static Exporter outexporter;

    private static Integer va = 1;


    public enum ExporterType {

        NO(-1, "NO", outexporter),
        A(1, "A", outexporter),
        B(2, "B", outexporter);

        private Integer value;

        private String desc;

        private Exporter exporter;

        private static Map<Integer, ExporterType> map;

        static {
            map = new HashMap<>();
            ExporterType[] values = ExporterType.values();
            for (ExporterType v : values) {
                map.put(v.value, v);
            }
        }

        ExporterType(Integer value, String desc, Exporter exporter) {
            this.value = value;
            this.desc = desc;
            this.exporter = exporter;
        }

        public static ExporterType genEnum(int value) {
            ExporterType exporterType = map.get(value);
            if (exporterType == null) {
                return NO;
            }
            return exporterType;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = va;
            this.value = value;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

    }

    public static void main(String[] args) throws NoSuchMethodException {
        ExporterType[] values = ExporterType.values();
        for (ExporterType type : values) {
            System.out.println(type.ordinal() + "- " + type.getValue());
        }
    }
}
