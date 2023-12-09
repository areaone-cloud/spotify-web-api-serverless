package com.areaone.cloud.spotify;

import java.net.URI;

public interface ClientDetailsProvider<T>
{
    String getClientId(T options);

    String getClientSecret(T options);

    URI getRedirectUri(T options);
}
