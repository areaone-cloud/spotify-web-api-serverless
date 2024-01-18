package cloud.areaone.spotify;

import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;

import java.time.Instant;

public class AuthorizationCodeCredentialsResponse
{
    private final AuthorizationCodeCredentials authorizationCodeCredentials;
    private final Instant expireTime;

    public AuthorizationCodeCredentialsResponse(AuthorizationCodeCredentials authorizationCodeCredentials)
    {
        this.authorizationCodeCredentials = authorizationCodeCredentials;
        this.expireTime = Instant.now()
                                 .plusSeconds(authorizationCodeCredentials.getExpiresIn() - 5);
    }

    public AuthorizationCodeCredentials getAuthorizationCodeCredentials()
    {
        return authorizationCodeCredentials;
    }

    public Instant getExpireTime()
    {
        return expireTime;
    }
}
