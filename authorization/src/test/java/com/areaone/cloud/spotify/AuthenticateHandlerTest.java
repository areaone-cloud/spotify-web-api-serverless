package com.areaone.cloud.spotify;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.auth.credentials.AnonymousCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.endpoints.Endpoint;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.InvocationType;
import software.amazon.awssdk.services.lambda.model.InvokeRequest;
import software.amazon.awssdk.services.lambda.model.InvokeResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

class AuthenticateHandlerTest
{

    @Test
    void name() throws URISyntaxException
    {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("DUMBY1", "TES");

        HashMap<String, Object> stringObjectHashMap2 =  new HashMap<>();
        stringObjectHashMap2.put("dada", 12321);
        stringObjectHashMap.put("dawad", stringObjectHashMap2);

        URI uri = new URI("http://localhost:9000");

        try (LambdaClient client = LambdaClient.builder()
                                               .region(Region.US_EAST_1)
                                               .credentialsProvider(AnonymousCredentialsProvider.create())
                                               .endpointProvider(endpointParams -> {
                                                   Endpoint build = Endpoint.builder()
                                                                            .url(uri)
                                                                            .putHeader("Content-Type",
                                                                                       "application/json")
                                                                            .build();
                                                   return CompletableFuture.completedFuture(build);
                                               })
                                               .build())
        {

            InvokeRequest request = InvokeRequest.builder()
                                                 .invocationType(InvocationType.EVENT)
                                                 .functionName("function")
                                                 .clientContext(Base64.getEncoder().encodeToString("{custom: {\"key1\":\"value1\"}".getBytes(StandardCharsets.UTF_8)))
                  .payload(SdkBytes.fromString(new Gson().toJson(stringObjectHashMap),
                                                                              Charset.defaultCharset()))
                  .build();

            InvokeResponse invoke = client.invoke(request);

            System.out.println("paylod:" + invoke.payload().asString(Charset.defaultCharset()));
        }
    }

    private static class TestContext
    {
        Map<String, Object> custom;

        TestContext(Map<String, Object> custom)
        {
            this.custom = custom;
        }
    }
}