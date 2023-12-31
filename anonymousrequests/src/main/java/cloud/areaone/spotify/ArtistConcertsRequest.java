package cloud.areaone.spotify;

import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.net.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import static java.net.HttpURLConnection.HTTP_OK;

public class ArtistConcertsRequest
{
    public static final String CONCERT_URL = "https://spclient.wg.spotify.com/concerts/v2/concerts/artist/";

    private final HttpClientResponseHandler<String> responseHandler = response -> {
        HttpEntity entity = response.getEntity();

        if (response.getCode() != HTTP_OK || Objects.isNull(entity))
        {
            throw new RuntimeException();
        }

        return EntityUtils.toString(entity);
    };

    public ArtistConcertResponse getArtistConcerts(AnonymousCodeCredentials credentials, String artistId)
    {
        try (CloseableHttpClient httpClient = HttpClients.createDefault())
        {
            URI uri = new URIBuilder(CONCERT_URL + artistId).setParameter("filterByLoc", "false")
                                                            .build();

            HttpGet request = new HttpGet(uri);

            BasicHeader authorizationHeader = new BasicHeader("Authorization",
                                                              "Bearer " + credentials.getAccessToken());
            request.addHeader(authorizationHeader);

            String response = httpClient.execute(request, responseHandler);

            System.out.println("response: " + response);

            return new Gson().fromJson(response, ArtistConcertResponse.class);
        }
        catch (IOException | URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
    }
}
