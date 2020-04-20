/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.security.temp;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @since 3.0.0
 */
public class Snippet{

    private static final Logger LOGGER = LoggerFactory.getLogger(Snippet.class);

    /**
     * Name.
     * 
     * @throws NoSuchAlgorithmException
     *             the no such algorithm exception
     */
    @Test
    public void name() throws NoSuchAlgorithmException{
        /**
         * 获取JAVA中有多少种加密方式
         * RSA, DES,
         * Triple DES,
         * AES, Blowfish, ARCFOUR, RC2, PBE, Diffie-Hellman, HMAC<br>
         * 
         * SunJCE Provider (implements RSA, DES, Triple DES, AES, Blowfish, ARCFOUR, RC2, PBE, Diffie-Hellman, HMAC)
         */
        // java.security.NoSuchAlgorithmException: RSA KeyGenerator not available
        KeyGenerator keyGenerator = KeyGenerator.getInstance("RSA");
        // kg.init(561);
        Provider provider = keyGenerator.getProvider();
        LOGGER.debug(provider.getInfo());
    }

    /** The algorithm. */
    private String algorithm;

    /**
     * 自定义一个key.
     * 
     * @param keyRule
     *            the key rule
     * @return the key2
     */
    private Key getKey2(String keyRule){
        byte[] keyByte = keyRule.getBytes();
        // 创建一个空的八位数组,默认情况下为0
        byte[] byteTemp = new byte[8];
        int keyByteLenth = keyByte.length;
        // 将用户指定的规则转换成八位数组
        for (int i = 0; i < byteTemp.length && i < keyByteLenth; ++i){
            byteTemp[i] = keyByte[i];
        }
        return new SecretKeySpec(byteTemp, algorithm);
    }
}