package com.example.demo.Controller;

import com.example.demo.model.Data;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customer")
public class RestWebController {

    public String encrypt(String textToEncrypt) {
        String password = "hFFChF6tY7Jk7wcLfBqfJ2zE";
        String salt = KeyGenerators.string().generateKey();
        TextEncryptor encryptor = Encryptors.text(password, salt);
        String encryptedText = encryptor.encrypt(textToEncrypt);

        System.out.println("Text to Encrypt: " + textToEncrypt + " Encrypted: " + encryptedText);

        return encryptedText;
    }

    public String decrypt(String textToDecrypt){
        String password = "hFFChF6tY7Jk7wcLfBqfJ2zE";
        String salt = KeyGenerators.string().generateKey();
        TextEncryptor decryptor = Encryptors.text(password,salt);
        String decryptedText = decryptor.decrypt(textToDecrypt);

        System.out.println("Text to Decrypt: " + textToDecrypt + " Decrypted: " + decryptedText);

        return decryptedText;
    }
    Data data = new Data("");

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Data getResource() {

        return data;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody String postCustomer(@RequestBody String textToUse) {

        String returnText;

        data.setTextToUse(textToUse);

        returnText = encrypt(data.getTextToUse());

        return returnText;
    }
}