package com.app.ordenaly.services;

import com.app.ordenaly.models.User;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

  @Value("${security.jwt.expiration-minutes}")
  private long EXPIRATION_MINUTES;
  @Value("${security.jwt.secret-key}")
  private String SECRET_KEY;

  public String generateToken(User user, Map<String,Object> extraClaims) {

    //1.
    Date issueAt = new Date(System.currentTimeMillis());
    Date expiration = new Date( issueAt.getTime() + (EXPIRATION_MINUTES * 60 * 1000));

    //2.
    return Jwts.builder()
            .setClaims(extraClaims)
            .setSubject(user.getUsername())
            .setIssuedAt(issueAt)
            .setExpiration(expiration)
            .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
            .signWith(generateKey(), SignatureAlgorithm.HS256)
            .compact();
  }

  //3.
  private Key generateKey() {
    byte[] secretKeyAsBytes = Decoders.BASE64.decode(SECRET_KEY);
    System.out.println("🔐clave: " + new String( secretKeyAsBytes ));
    return Keys.hmacShaKeyFor( secretKeyAsBytes );
  }

  public String extractUsername(String jwt) {
    return Jwts.parser().setSigningKey(generateKey())
            .build()
            .parseClaimsJws(jwt).getBody().getSubject();
  }

}

//1. Configuracion de tiempos de expedicion y caducidad del token en milisegundos

/*2. Toma una serie de reclamos adicionales (extraClaims) y establece el tipo de token,
     su firma con una clave secreta generada y devuelve el token JWT como una cadena compacta */

/*3. Decodifica una clave secreta en base64, la imprime en la consola y luego la utiliza para
     generar una instancia de Key que se utilizará en la firma de tokens JWT. */

// ANOTATIONS
/* @Value, se utiliza para inyectar valores directamente en campos de una clase desde
   el entorno de configuración de Spring, como properties files, variables de entorno,
   valores por defecto, etc. Esta anotación es parte de la inyección de dependencias de
   Spring y es especialmente útil para inyectar valores simples, como cadenas de texto,
   números u otros tipos de datos básicos. */