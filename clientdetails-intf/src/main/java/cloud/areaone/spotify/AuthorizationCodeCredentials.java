package cloud.areaone.spotify;

public class AuthorizationCodeCredentials
{
    public String accessToken;
    public String tokenType;
    public String scope;
    public Integer expiresIn;
    public String refreshToken;

    public AuthorizationCodeCredentials()
    {
        //FOR JSON
    }

    private AuthorizationCodeCredentials(se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials credentials)
    {
        accessToken = credentials.getAccessToken();
        tokenType = credentials.getTokenType();
        scope = credentials.getScope();
        expiresIn = credentials.getExpiresIn();
        refreshToken = credentials.getRefreshToken();
    }

    public static AuthorizationCodeCredentials fromApi(se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials credentials)
    {
        return new AuthorizationCodeCredentials(credentials);
    }

    public se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials toApi()
    {
        return new se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials.Builder().setAccessToken(accessToken)
                                                                                                            .setTokenType(tokenType)
                                                                                                            .setScope(scope)
                                                                                                            .setExpiresIn(expiresIn)
                                                                                                            .setRefreshToken(refreshToken)
                                                                                                            .build();
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public String getTokenType()
    {
        return tokenType;
    }

    public String getScope()
    {
        return scope;
    }

    public Integer getExpiresIn()
    {
        return expiresIn;
    }

    public String getRefreshToken()
    {
        return refreshToken;
    }
}
