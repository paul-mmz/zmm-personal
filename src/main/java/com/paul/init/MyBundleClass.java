package com.paul.init;

import java.util.ListResourceBundle;

/**
 * Created by hzzhouminmin on 2017/12/6.
 */
public class MyBundleClass extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            { "price"   , new Double(75.00) },
            { "currency", "DKK" },
    };
}
