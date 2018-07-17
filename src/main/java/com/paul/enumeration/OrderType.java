package com.paul.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum OrderType{

    UNKNOWN(-1, "未知"),
    NORMAL(1000, "正常订单"),
    VM_CARD(1010, "会员月卡"),
    VIRTUAL_NTE_APC_DIRECT(2010, "网易一卡通直冲"),
    VIRTUAL_BATTLENET_APC_DIRECT(2020, "战网一卡通直冲"),
    VIRTUAL_STARCRAFT_CDKEY(2030, "星际CDKEY"),
    VIRTUAL_OVERWATCH_CDKEY(2040, "守望先锋CDKEY"),
    VIRTUAL_DIABLO_CDKEY(2050, "暗黑CDKEY"),
    VIRTUAL_WORLD_OF_WARCRAFT(2060, "魔兽世界月卡季卡充值");

    private final int value;

    private final String desc;

    private static OrderType[] NORMAL_ARRAY = new OrderType[] { NORMAL, VM_CARD };

    private static OrderType[] VIRTUAL_ARRAY = new OrderType[] { VIRTUAL_NTE_APC_DIRECT, VIRTUAL_BATTLENET_APC_DIRECT,
            VIRTUAL_STARCRAFT_CDKEY, VIRTUAL_OVERWATCH_CDKEY, VIRTUAL_DIABLO_CDKEY,VIRTUAL_WORLD_OF_WARCRAFT };

    static Map<Integer, OrderType> values = new HashMap<>();

    static {
        for (OrderType code : values()) {
            values.put(code.value, code);
        }
    }

    private OrderType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public OrderType genEnumByIntValue(int value) {
        return values.get(value);
    }

    public int intValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
    
    public static void main(String[] args) {
		OrderType[] array = values();
		for(OrderType o : array){
//			System.out.println(o.getDesc() +", " + o.toString());
//			System.out.println(o.intValue() +", " + o.ordinal());
            System.out.println(o.name());
            System.out.println(o.ordinal());
        }
	}

}