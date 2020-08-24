package com.paul.leetcode;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private ThreadLocal<List<Long>> longLocal;

    private InheritableThreadLocal<List<Long>> inheritableLongLocal;

    public ThreadLocal<List<Long>> getLongLocal() {
        return longLocal;
    }

    public void setLongLocal(ThreadLocal<List<Long>> longLocal) {
        this.longLocal = longLocal;
    }

    public InheritableThreadLocal<List<Long>> getInheritableLongLocal() {
        return inheritableLongLocal;
    }

    public void setInheritableLongLocal(InheritableThreadLocal<List<Long>> inheritableLongLocal) {
        this.inheritableLongLocal = inheritableLongLocal;
    }

    public static void main(String[] args) throws InterruptedException {
    }
}
