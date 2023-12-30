package cloud.areaone.spotify;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.enums.AuthorizationScope;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;

public class AuthorizationUriProvider
{
    public URI authenticate(ClientDetailsProvider detailsProvider, AuthorizationInput input)
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
                                                            .scope(input.getScopes()
                                                                        .toArray(new AuthorizationScope[0]))
                                                            .show_dialog(true)
                                                            .build();

        return authRequest.execute();
    }
}
