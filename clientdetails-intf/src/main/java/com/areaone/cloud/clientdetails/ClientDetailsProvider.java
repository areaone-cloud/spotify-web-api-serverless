package com.areaone.cloud.clientdetails;

import java.net.URI;

public interface ClientDetailsProvider
{
    String getClientId();

    String getClientSecret();

    URI getRedirectUri();
}
