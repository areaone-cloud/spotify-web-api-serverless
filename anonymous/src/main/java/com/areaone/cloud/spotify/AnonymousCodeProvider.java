package com.areaone.cloud.spotify;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.net.HttpURLConnection.HTTP_OK;

public class AnonymousCodeProvider
{
    public AnonymousCodeCredentials getAnonymousCredentials(AnonymousInput input)
    {
        HttpGet request = new HttpGet("https://open.spotify.com");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request))
        {
            HttpEntity entity = response.getEntity();

            if (response.getCode() != HTTP_OK || Objects.isNull(entity))
            {
                throw new RuntimeException();
            }

            String result = EntityUtils.toString(entity);

            String accessRegex = "\"accessToken\":\"(.+?)\"";
            String expiryRegex = "\"accessTokenExpirationTimestampMs\":([0-9]+)";

            Pattern acessPattern = Pattern.compile(accessRegex);
            Matcher accessMatcher = acessPattern.matcher(result);

            Pattern expiryPattern = Pattern.compile(expiryRegex);
            Matcher expiryMatcher = expiryPattern.matcher(result);

            if (accessMatcher.find() && expiryMatcher.find())
            {
                String group = accessMatcher.group(1);
                String group1 = expiryMatcher.group(1);

                return new AnonymousCodeCredentials(group, Long.valueOf(group1));
            }
            else
            {
                throw new RuntimeException();
            }
        }
        catch (IOException | ParseException e)
        {
            throw new RuntimeException(e);
        }
    }
}
