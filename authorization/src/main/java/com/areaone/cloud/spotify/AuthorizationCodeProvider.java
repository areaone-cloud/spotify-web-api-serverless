package com.areaone.cloud.spotify;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;

import java.io.IOException;

public class AuthorizationCodeProvider
{
    public AuthorizationCodeCredentials getAuthorizationCredentials(String code)
    {
        SpotifyApi spotifyAPi = SpotifyApi.builder()
                                          .build();

        try
        {
            return spotifyAPi.authorizationCode(code)
                             .build()
                             .execute();

        }
        catch (IOException | SpotifyWebApiException | ParseException e)
        {
            throw new RuntimeException(e);
        }
    }
}
