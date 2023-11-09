package com.scaler.scaler_authentication.util;

public class RandomString {
    private Integer LB;
    private Integer UB;
    public RandomString(Integer LB, Integer UB) {
        this.LB = LB;
        this.UB = UB;
    }
    public String generate(Integer targetStringLength) {
        int leftLimit = this.LB;
        int rightLimit = this.UB;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (Math.random() * (rightLimit - leftLimit));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
