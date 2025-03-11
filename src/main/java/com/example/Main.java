package com.example;

import com.example.project.Encryptor;

public class Main{
    public static void main(String[] args) {
        String decryptedMessage = Encryptor.decryptMessage(" a , dh=ehakens=v  onui=a,eooof=Havl p =", 8);
        System.out.println(decryptedMessage);
    }
}