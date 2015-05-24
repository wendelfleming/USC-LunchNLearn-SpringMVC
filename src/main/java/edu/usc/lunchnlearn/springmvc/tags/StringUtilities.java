package edu.usc.lunchnlearn.springmvc.tags;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * EL Custom tag class that handles URL encoding.
 */
public class StringUtilities {

    private StringUtilities() {
        //hide the constructor since static class.
    }

    /**
     * encoded url in utf-8 format
     *
     * @param input
     * @return encoded string
     */
    public static String encodeUrl(String input) {
        String out = null;
        try {
            if (input != null) {
                out = URLEncoder.encode(input, "utf-8");
            }
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return out;
    }


}
