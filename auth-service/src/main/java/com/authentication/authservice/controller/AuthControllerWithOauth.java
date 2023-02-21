package com.authentication.authservice.controller;

//import com.authentication.authservice.model.AuthResponse;
//import org.apache.catalina.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
//import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.ui.Model;
//
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthControllerWithOauth {
//
//    @Autowired
//    private OAuth2AuthorizedClientService authorizedClientService;
//    private WebClient webClient;
//    private final Logger logger = LoggerFactory.getLogger(AuthControllerWithOauth.class);
//
//    @GetMapping("/login")
//    public ResponseEntity<AuthResponse> login(
//            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
//            @AuthenticationPrincipal OidcUser user,
//            Model model
//    ) {
//        logger.info("user email id" + user.getEmail());
//        // creating auth response setting
//        AuthResponse authResponse = new AuthResponse();
//        authResponse.setUserId(user.getEmail());
//        authResponse.setAccessToken(client.getAccessToken().getTokenValue());
//        authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
//        authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
//        List<String> authorities = user.getAuthorities().stream().map(grantedAuthorities -> {
//            return grantedAuthorities.getAuthority();
//        }).collect(Collectors.toList());
//        authResponse.setAuthorities(authorities);
//        return new ResponseEntity<>(authResponse, HttpStatus.OK);
//    }
//
//    @PreAuthorize("permitAll()")
//    @PostMapping("/singup")
//    private ResponseEntity<String> signUp(OAuth2AuthenticationToken authentication, @RequestBody User user) {
//      try {
//          OAuth2AuthorizedClient authorizedClient =
//                  authorizedClientService.loadAuthorizedClient(
//                          authentication.getAuthorizedClientRegistrationId(),
//                          authentication.getName());
//
//          HttpHeaders headers = new HttpHeaders();
//          headers.setContentType(MediaType.APPLICATION_JSON);
//
//          HttpEntity<User> request = new HttpEntity(user, headers);
//          headers.setBearerAuth(authorizedClient.getAccessToken().getTokenValue());
//          webClient.post().
//                  uri("https://dev-69209525.okta.com/api/v1/users")
//                  .body(request, com.authentication.authservice.model.User.class)
//                  .retrieve()
//                  .bodyToMono(com.authentication.authservice.model.User.class);
//          return new ResponseEntity("Success", HttpStatus.CREATED);
//      }catch(Exception e){
//          return new ResponseEntity("bad", HttpStatus.BAD_REQUEST);
//
//      }


  //  }
}
