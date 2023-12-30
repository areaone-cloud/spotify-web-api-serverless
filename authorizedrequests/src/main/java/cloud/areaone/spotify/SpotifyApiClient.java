package cloud.areaone.spotify;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;

public class SpotifyApiClient
{
    private SpotifyApiClient()
    {
    }

    static SpotifyApi build(AuthorizationCodeCredentials credentials)
    {
        return SpotifyApi.builder()
                         .setAccessToken(credentials.getAccessToken())
                         .setRefreshToken(credentials.getRefreshToken())
                         .build();
    }
}
