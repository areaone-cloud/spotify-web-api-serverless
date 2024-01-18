package cloud.areaone.spotify;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.exceptions.detailed.TooManyRequestsException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;

import java.io.IOException;
import java.net.URI;

public class AuthorizationCodeProvider
{
    public AuthorizationCodeCredentials getAuthorizationCredentials(ClientDetailsProvider detailsProvider,
                                                                    String code) throws TooManyRequestsException
    {
        String clientId = detailsProvider.getClientId();
        String clientSecret = detailsProvider.getClientSecret();
        URI redirectUri = detailsProvider.getRedirectUri();

        SpotifyApi spotifyApi = SpotifyApi.builder()
                                          .setClientId(clientId)
                                          .setClientSecret(clientSecret)
                                          .setRedirectUri(redirectUri)
                                          .build();
        try
        {
            return spotifyApi.authorizationCode(code)
                             .build()
                             .execute();
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
