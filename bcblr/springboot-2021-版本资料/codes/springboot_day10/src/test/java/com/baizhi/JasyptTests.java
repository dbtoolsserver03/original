package com.baizhi;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTests {


    private StringEncryptor stringEncryptor;

    @Autowired
    public JasyptTests(StringEncryptor stringEncryptor) {
        this.stringEncryptor = stringEncryptor;
    }

    @Test
    public void testSecret(){
        //for (int i = 0; i < 10; i++) {
        //    //加密
        //    String secret = stringEncryptor.encrypt("root");
        //    System.out.println(secret);
        //}

        String localhost = stringEncryptor.encrypt("localhost");
        System.out.println(localhost);

        String decrypt = stringEncryptor.decrypt("cv2W1fM0vSNpx4R12MsY2Q==");
        System.out.println(decrypt);

    }
}
