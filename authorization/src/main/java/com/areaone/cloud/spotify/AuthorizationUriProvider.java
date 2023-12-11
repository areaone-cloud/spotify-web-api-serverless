package com.areaone.cloud.spotify;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.enums.AuthorizationScope;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;
import java.util.List;

public class AuthorizationUriProvider
{
    public URI authenticate(ClientDetailsProvider detailsProvider, List<AuthorizationScope> scopes)
    {
        String clientId = detailsProvider.getClientId();
        String clientSecret = detailsProvider.getClientSecret();
        URI redirectUri = detailsProvider.getRedirectUri();

        SpotifyApi spotifyApi = SpotifyApi.builder()
                                          .setClientId(clientId)
                                          .setClientSecret(clientSecret)
                                          .setRedirectUri(redirectUri)
                                          .build();

        AuthorizationCodeUriRequest authRequest = spotifyApi.authorizationCodeUri()
                                                            .scope(scopes.toArray(new AuthorizationScope[0]))
                                                            .show_dialog(true)
                                                            .build();

        return authRequest.execute();
    }
}
