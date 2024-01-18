package cloud.areaone.spotify;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.exceptions.detailed.TooManyRequestsException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;

import java.io.IOException;
import java.net.URI;

public class RefreshTokenProvider
{
    public AuthorizationCodeCredentials getRefreshedToken(ClientDetailsProvider detailsProvider,
                                                          AuthorizationCodeCredentials credentials) throws TooManyRequestsException
    {
        String clientId = detailsProvider.getClientId();
        String clientSecret = detailsProvider.getClientSecret();
        URI redirectUri = detailsProvider.getRedirectUri();

        SpotifyApi spotifyApi = SpotifyApi.builder()
                                          .setClientId(clientId)
                                          .setClientSecret(clientSecret)
                                          .setRedirectUri(redirectUri)
                                          .setAccessToken(credentials.getAccessToken())
                                          .setRefreshToken(credentials.getRefreshToken())
                                          .build();

        AuthorizationCodeRefreshRequest request = spotifyApi.authorizationCodeRefresh()
                                                            .build();

        try
        {
            return request.execute();
        }
        catch (IOException | ParseException e)
        {
            throw new RuntimeException(e);
        }
        catch (SpotifyWebApiException e)
        {
            if (e instanceof TooManyRequestsException)
            {
                throw (TooManyRequestsException) e;
            }
            else
            {
                throw new RuntimeException(e);
            }
        }
    }
}
