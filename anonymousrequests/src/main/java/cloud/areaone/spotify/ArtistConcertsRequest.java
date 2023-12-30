package cloud.areaone.spotify;

import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicHeader;

import java.io.IOException;
import java.util.Objects;

import static java.net.HttpURLConnection.HTTP_OK;

public class ArtistConcertsRequest
{
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
        HttpGet request = new HttpGet("https://spclient.wg.spotify.com/concerts/v2/concerts/artist/" + artistId);

        BasicHeader authorizationHeader = new BasicHeader("Authorization", "Bearer " + credentials.getAccessToken());
        request.addHeader(authorizationHeader);

        try (CloseableHttpClient httpClient = HttpClients.createDefault())
        {
            String response = httpClient.execute(request, responseHandler);

            return new Gson().fromJson(response, ArtistConcertResponse.class);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
