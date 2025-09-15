import java.util.*;

public class DialingCodes {

    private Map<Integer, String> intCallCodes = new HashMap<>();
    public Map<Integer, String> getCodes() {
                return intCallCodes;
    }

    public void setDialingCode(Integer code, String country) {
                intCallCodes.put(code, country);
    }

    public String getCountry(Integer code) {
                return intCallCodes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!intCallCodes.containsKey(code) && !intCallCodes.containsValue(country)) {
            setDialingCode(code, country);
        }
    }

    public Integer findDialingCode(String country) {
                Integer foundKey =null;
                for (Map.Entry<Integer, String> entry : intCallCodes.entrySet()) {
                if (entry.getValue().equals(country)) {
                    foundKey = entry.getKey();
            }
        }
            return foundKey;
    }

    public void updateCountryDialingCode(Integer code, String country) {
              Integer oldCode = findDialingCode(country);
            if (oldCode != null) {
            intCallCodes.remove(oldCode);
            setDialingCode(code, country);
        }
    }
}
