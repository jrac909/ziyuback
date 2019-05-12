package com.xk.ziyu.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Map;

public class JavaWebToken {
    /*
     * java 开发过程中经常需要打印日志信息，往往会在每个类的第一行加上这一句
     * 目的：使用指定的类是初花日志对象，方便在日志输出的时候，可以打印出日志信息所属的类
     */
    private static Logger log = LoggerFactory.getLogger(JavaWebToken.class);

    /**
     * 该方法使用 HS256 算法和 Secrer:bankg1 生成 signKey
     * @return
     */
    private static Key getKeyInstance(){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("bankgl");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        return signingKey;
    }

    /**
     * 使用 HS256 签名算法和生成的 signingKey 最终Token，claims 中是有效载荷
     * @param claims
     * @return
     */
    public static String createJavaWebToken(Map<String, Object> claims){
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
    }

    /**
     * 解析 Token，同时也能验证Token，当验证失败返回 null
     * @param jwt
     * @return
     */
    public  static Map<String, Object> parserJavaWebToken(String jwt){
        try {
            Map<String, Object> jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();

            return jwtClaims;
        } catch (Exception e){
            log.error("json web token verify failed");
            return null;
        }
    }
}
