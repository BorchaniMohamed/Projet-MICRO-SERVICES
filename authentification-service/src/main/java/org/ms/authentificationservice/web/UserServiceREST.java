package org.ms.authentificationservice.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.ms.authentificationservice.entities.AppRole;
import org.ms.authentificationservice.entities.AppUser;
import org.ms.authentificationservice.entities.UserRoleCollection;
import org.ms.authentificationservice.services.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserServiceREST {
    public final String PREFIXE_JWT="Bearer ";
    public final String CLE_SIGNATURE ="MaClé";
    private final UserServiceImpl userService;
    @GetMapping(path="")
    public ResponseEntity<List<AppUser>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping(path = "/users")
    @PostAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
    }
    @PostMapping(path = "/roles")
    public ResponseEntity<AppRole> saveRole(@RequestBody AppRole role){
        return new ResponseEntity<>(userService.addRole(role), HttpStatus.OK);
    }
    @PostMapping(path = "/addRoleToUser")
    public ResponseEntity<AppUser> addRoleToUser2(@RequestBody UserRoleCollection col){
        return new ResponseEntity<>(userService.addRoleToUser(col.getUsername(), col.getRoleName()), HttpStatus.OK);

    }
    @GetMapping(path="/refreshToken")
    public void refreshToken (HttpServletRequest request , HttpServletResponse
            response)
    {
// récupérer le header "Authorization" (refresh-token)
        String refreshToken = request.getHeader("Authorization");
// vérifier l'état du header
        if (refreshToken!=null && refreshToken.startsWith(PREFIXE_JWT))
        {
            try {
//récupérer la valeur du refresh-token
                String jwtRefresh = refreshToken.substring(PREFIXE_JWT.length());
//Préparer une instance du même algorithme de cryptage (HMAC256)
                Algorithm algo = Algorithm.HMAC256(CLE_SIGNATURE);
// vérifier la validité du JWT par la vérification de sa signature
                JWTVerifier jwtVerifier = JWT.require(algo).build();
//décoder le refresh-JWT
                DecodedJWT decodedJWT =jwtVerifier.verify(jwtRefresh);
//récupérer la valeur de "username"
                String username = decodedJWT.getSubject();
//Recharger l'utilisateur à partir de la BD
                AppUser user = userService.getUserByName(username);
//Construire le access JWT
                String jwtAccessToken = JWT.create()
// stocker le nom de l'utilisateur
                        .withSubject(user.getUsername())
// date d'expiration après 1 minute
                        .withExpiresAt(new Date(System.currentTimeMillis()+1*60*1000))
//url de la reuête d'origine
                        .withIssuer(request.getRequestURL().toString())
//placer la liste des rôles associés à l'utilisateur courant
                        .withClaim("roles", user.getRoles().stream().map(r->r.getRoleName()).collect(Collectors.toList()))
//signer le access JWT avec l'algorithme choisi
                        .sign(algo);
//stocker les deux tokens dans un objet HashMap
                Map<String,String> mapTokens = new HashMap<>();
                mapTokens.put("access-token",jwtAccessToken);
                mapTokens.put("refresh-token",jwtRefresh);
//Spécifier le format du contenu de la réponse
                response.setContentType("application/json");
//place l'objet HashMap dans le corps de la réponse
                new ObjectMapper().writeValue(response.getOutputStream(),mapTokens);
            } catch (Exception e) {
                new RuntimeException(e);
            }
        }
        else
        {
            new RuntimeException("Refresh Token non disponible..");
        }
    }
}
