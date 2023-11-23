package ex00;

import java.io.*;
import java.util.Map;

public class SignalFinder {
    public static Map<String, String> signalMap = SignalReader.read();

    public static String findType(String fileName) {
        String hexString = readHex(fileName);
        return compareTypes(hexString, signalMap);
    }

    private static String readHex(String fileName) {
        StringBuilder hexString = new StringBuilder();
        try {
            FileInputStream input = new FileInputStream(fileName);
            byte[] buffer = new byte[8];
            int bytesRead = input.read(buffer);

            for (int i = 0; i < bytesRead; i++) {
                hexString.append(String.format("%02X", buffer[i]));
                if (i != bytesRead - 1)
                    hexString.append(" ");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return hexString.toString();
    }

    private static String compareTypes(String hexString, Map<String, String> signalMap) {
        String type = null;
        for (Map.Entry<String, String> entry : signalMap.entrySet()
        ) {
            if (hexString.startsWith(entry.getValue())) {
                type = entry.getKey();
                break;
            }
        }
        return type;
    }
}
