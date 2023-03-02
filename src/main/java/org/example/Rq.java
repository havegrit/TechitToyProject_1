package org.example;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode;
    private Map<String, String> params = new HashMap<>();
    public Rq(String input) {
        String[] inputBits = input.split("\\?", 2);

        if(inputBits.length == 1) {
            actionCode = input;
            return;
        }

        actionCode = inputBits[0];
        String[] paramBits = inputBits[1].split("&");
        for(String paramStr:paramBits) {
            String[] paramStrBits = paramStr.split("=", 2);
            String key = paramStrBits[0];
            String value = paramStrBits[1];
            params.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;

    }
    public String getParams(String name) {
        return params.get(name);
    }

    public int getIntParam(String name, int defaultValue) {
        try {
            return Integer.parseInt(getParams(name));
        } catch (NumberFormatException e) {
        }
        return defaultValue;
    }
}
