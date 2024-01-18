package cloud.areaone.spotify;

import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;

import java.time.Instant;

public class AuthorizationCodeCredentialsResponse
{
    private final AuthorizationCodeCredentials credentials;
    private final Instant expireTime;

    public AuthorizationCodeCredentialsResponse(AuthorizationCodeCredentials credentials)
    {
        this.credentials = credentials;
        this.expireTime = Instant.now()
                                 .plusSeconds(credentials.getExpiresIn() - 5);
    }

    public AuthorizationCodeCredentials getCredentials()
    {
        return credentials;
    }

    public Instant getExpireTime()
    {
        return expireTime;
    }
}
