package com.areaone.cloud.spotify;

import org.junit.jupiter.api.Test;

class AnonymousCodeProviderTest
{

    @Test
    void getAuthorizationCredentials()
    {
        AnonymousCodeProvider anonymousCodeProvider = new AnonymousCodeProvider();
        AnonymousCodeCredentials authorizationCredentials = anonymousCodeProvider.getAnonymousCredentials(null);

        System.out.println(authorizationCredentials.getAccessToken());
        System.out.println(authorizationCredentials.getAccessTokenExpirationTimestampMs());
    }
}