package com.tpig.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import org.junit.Test;

/**
 * @author Wang Ruoruo
 * @date 2019/8/11
 * @time 16:58
 **/
public class JwtTest {

  @Test
  public void test() {

    try {
      Algorithm algorithm = Algorithm.HMAC256("secret");
      String token = JWT.create().withIssuer("e589918").sign(algorithm);
      System.out.println(token);
    } catch (JWTCreationException exception) {
      //Invalid Signing configuration / Couldn't convert Claims.
    }

  }

  @Test
  public void verify_test() {
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJlNTg5OTE4In0.5nsPzadsgTGO8ysSPsv-8Le-s9wThQu67WNVCyA1UXc";
    try {
      Algorithm algorithm = Algorithm.HMAC256("secret");
      JWTVerifier verifier = JWT.require(algorithm)
          .withIssuer("e589918")
          .build(); //Reusable verifier instance
      DecodedJWT jwt = verifier.verify(token);
      System.out.println(jwt);
    } catch (JWTVerificationException exception) {
      //Invalid signature/claims
      exception.printStackTrace();
    }
  }

}
