package cloud.areaone.spotify;

import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;

import java.time.Instant;

public class AuthorizationCodeCredentialsResponse
{
    public AuthorizationCodeCredentials credentials;
    public Instant expireTime;

    public AuthorizationCodeCredentialsResponse()
    {
    }

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
