package es.s2o.selenium.domain;

import cucumber.deps.com.thoughtworks.xstream.converters.basic.StringConverter;

public class TableColorConverter extends StringConverter {
    public Object fromString(String str) {
        String result;
        switch (str){
            case "red":
                result = "#b35a5a";
                break;
            default:
                result = str;
        }
        return result;
    }
}
