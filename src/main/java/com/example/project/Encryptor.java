package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        int columns;
        if (messageLen == 0) {
            columns = 1;
        }else if (((messageLen / rows) * rows) < messageLen) {
            columns = messageLen / rows + 1;
        }else{
            columns = messageLen / rows;
        }
        return columns;
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int columns = determineColumns(message.length(), rows);
        String[][] encryptedArrary = new String[rows][columns];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (count < message.length()){
                    encryptedArrary[i][j] = message.substring(count, count + 1);
                    count++;
                }else{
                    encryptedArrary[i][j] = "=";
                }
            }
        }
        return encryptedArrary;
    }

    public static String encryptMessage(String message, int rows){
        String encryptedMessage = "";
        String[][] arr = generateEncryptArray(message, rows);
        int columns = determineColumns(message.length(), rows);
        for (int i = columns - 1; i >= 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                encryptedMessage += arr[j][i];
            }
        }
        return encryptedMessage;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        int columns = determineColumns (encryptedMessage.length(), rows);
        String[][] arr = new String[rows][columns];
        
        if (columns * rows != encryptedMessage.length()){
            return "";
        }
        
        int index = 0;
        for (int c = columns - 1; c >= 0; c--) {
            for (int r = 0; r < rows; r++) {
                arr[r][c] = String.valueOf(encryptedMessage.charAt(index++));
            }
        }
        
        String decryptedMessage = "";
        for (String[] row : arr) {
            for (String column : row) {
                if (!column.equals("=")) {
                    decryptedMessage += column;
                }
            }
        }
        
        return decryptedMessage;
    }
}