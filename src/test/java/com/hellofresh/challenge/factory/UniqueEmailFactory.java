package com.hellofresh.challenge.factory;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class UniqueEmailFactory {
    private final String EMAIL_FORMAT = "hf_challenge_%s@hf%s.com";

    public String getFakeEmail() {
        String timestamp = String.valueOf(new Date().getTime());
        String email = String.format(EMAIL_FORMAT, timestamp, timestamp.substring(7));
        return email;
    }
}
