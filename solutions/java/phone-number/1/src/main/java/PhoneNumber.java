class PhoneNumber {

    String number;
    
    PhoneNumber (String phoneNumber) throws IllegalArgumentException {
        number = phoneNumber;
        
        if (number.replaceAll("[A-Za-z]", "").length() != number.length()) {
            throw new IllegalArgumentException("letters not permitted");
        } else if (number.replaceAll("[@:!?]", "").length() != number.length()) {
            throw new IllegalArgumentException("punctuations not permitted");
        }
        number = number.replaceAll("[^0-9]", "");
        
        if (number.length() < 10) {
            throw new IllegalArgumentException("must not be fewer than 10 digits");
        } else if (number.length() > 11) {
            throw new IllegalArgumentException("must not be greater than 11 digits");
        }
        
        if (number.length() == 11) {
            if (number.charAt(0) != '1') {
                throw new IllegalArgumentException("11 digits must start with 1");
            } else {
                number = number.substring(1);
            }
        }
        
        if (number.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        } else if (number.charAt(0) == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
        }
        if (number.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        } else if (number.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }
    }

    String getNumber() {
        return number;
    }
    
}