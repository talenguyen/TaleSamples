package com.talenguyen.TaleSamples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by TALE on 1/17/14.
 */
public class Utils {

    private static final String EMAIL_REG_EX =
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

    public static boolean validEmail(String email)
    {
        final Pattern pattern = Pattern.compile(EMAIL_REG_EX, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
