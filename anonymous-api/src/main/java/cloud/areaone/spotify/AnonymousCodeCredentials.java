package cloud.areaone.spotify;

public class AnonymousCodeCredentials
{
    private final String accessToken;
    private final Long accessTokenExpirationTimestampMs;

    public AnonymousCodeCredentials(String accessToken, Long accessTokenExpirationTimestampMs)
    {
        this.accessToken = accessToken;
        this.accessTokenExpirationTimestampMs = accessTokenExpirationTimestampMs;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public Long getAccessTokenExpirationTimestampMs()
    {
        return accessTokenExpirationTimestampMs;
    }
}
