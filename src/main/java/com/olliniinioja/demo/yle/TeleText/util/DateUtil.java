package com.olliniinioja.demo.yle.TeleText.util;

import java.time.Instant;

public class DateUtil {

    private DateUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static Instant getUTCFromEpoch(String epoch) {
        try {
            long longEpoch = Long.parseLong(epoch);
            return getUTCFromEpoch(longEpoch);
        } catch (NumberFormatException e) {
            // noop
        }

        return null;
    }

    public static Instant getUTCFromEpoch(long epoch) {
        return Instant.ofEpochSecond(epoch);
    }
}
