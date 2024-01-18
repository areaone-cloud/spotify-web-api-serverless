package cloud.areaone.spotify;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.exceptions.detailed.TooManyRequestsException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.specification.Artist;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LibraryArtistsRequest
{
    public List<Artist> getLibraryArtists(AuthorizationCodeCredentials credentials,
                                          List<String> artistIds) throws TooManyRequestsException
    {
        try
        {
            Artist[] artists = SpotifyApiClient.build(credentials)
                                               .getSeveralArtists(artistIds.toArray(new String[0]))
                                               .build()
                                               .execute();

            return Arrays.asList(artists);
        }
        catch (IOException | ParseException e)
        {
            throw new RuntimeException(e);
        }
        catch (SpotifyWebApiException e)
        {
            if (e instanceof TooManyRequestsException)
            {
                throw (TooManyRequestsException) e;
            }
            else
            {
                throw new RuntimeException(e);
            }
        }
    }
}
