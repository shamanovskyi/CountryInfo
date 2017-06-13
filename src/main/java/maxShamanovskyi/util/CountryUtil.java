package maxShamanovskyi.util;

import maxShamanovskyi.model.Country;

import java.util.Map;

public final class CountryUtil {

    public static boolean isValidString(String value){
        boolean valid = true;
        if (value == null || value.trim().isEmpty()){
            valid = false;
        }
        return valid;
    }

    public static boolean isValidDouble(Double value){
        boolean valid = true;
        if (value.isNaN() || value < 0) {
            valid = false;
        }
        return valid;
    }

    public static boolean isValidMap(Map<String, Double> map){
        boolean valid = true;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Double> value : map.entrySet()) {
                if (!isValidDouble(value.getValue()) || !isValidString(value.getKey())){
                    valid = false;
                }
            }
        }
        return valid;
    }

    public static boolean isValidCountry(Country country){
        boolean valid = false;
        if (country != null) {
            if (isValidString(country.getName()) &&
                    isValidDouble(country.getPopulation()) &&
                    isValidDouble(country.getArea()) &&
                    isValidDouble(country.getGdp()) &&
                    isValidString(country.getCapital()) &&
                    isValidString(country.getCapital()) &&
                    isValidString(country.getPresident()) &&
                    isValidString(country.getVicePresident()) &&
                    isValidMap(country.getLanguages())){
                valid = true;
            }
        }
        return valid;
    }
}
