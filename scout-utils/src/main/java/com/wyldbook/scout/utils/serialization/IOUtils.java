package com.wyldbook.scout.utils.serialization;

import java.io.InputStream;
import java.util.Scanner;

public class IOUtils {
    public static final String INPUT_BEGIN_DELIMITER = "\\A";

    public static String readAsString(String pathToFile) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathToFile);
        return readAsString(inputStream);
    }

    public static String readAsString(InputStream inputStream) {
        return readAsString(inputStream, "UTF-8");
    }

    public static String readAsString(InputStream inputStream, String charsetName) {
        return new Scanner(inputStream, charsetName).useDelimiter(INPUT_BEGIN_DELIMITER).next();
    }
}
