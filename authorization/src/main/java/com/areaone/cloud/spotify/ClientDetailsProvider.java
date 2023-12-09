package com.areaone.cloud.spotify;

import java.net.URI;

public interface ClientDetailsProvider
{
    String getClientId();

    String getClientSecret();

    URI getRedirectUri();
}
