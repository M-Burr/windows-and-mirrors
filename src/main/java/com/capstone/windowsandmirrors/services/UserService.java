package com.capstone.windowsandmirrors.services;

import com.capstone.windowsandmirrors.models.User;
import com.capstone.windowsandmirrors.repositories.UserRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class UserService {
    final static JacksonFactory jsonFactory = new JacksonFactory();
    final static HttpTransport transport = new NetHttpTransport();
    final static String CLIENT_ID = "134231042819-ldje18ruml7mdidv2ca21946nputsmbu.apps.googleusercontent.com";

    final GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
            .setAudience(Collections.singletonList(CLIENT_ID))
            .build();

    @Autowired
    private UserRepository userRepository;

    public User login(String userToken) {
        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(userToken);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            String email = payload.getEmail();
            User user = userRepository.findUserByEmail(email);
            if (user == null){
                user = new User();
                user.setName((String) payload.get("name"));
                user.setEmail(email);
                user.setAccountType("general");
                userRepository.save(user);
            }
//            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
//            String name = (String) payload.get("name");
//            String pictureUrl = (String) payload.get("picture");
//            String locale = (String) payload.get("locale");
//            String familyName = (String) payload.get("family_name");
//            String givenName = (String) payload.get("given_name");

            // Use or store profile information
            // ...
            return user;
        } else {
            System.out.println("Invalid ID token.");
        }

        return null;
    }
}
