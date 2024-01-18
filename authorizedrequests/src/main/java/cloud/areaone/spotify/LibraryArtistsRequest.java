package cloud.areaone.spotify;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.enums.ModelObjectType;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.exceptions.detailed.TooManyRequestsException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.SavedTrack;
import se.michaelthelin.spotify.requests.data.library.GetUsersSavedTracksRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryArtistsRequest
{
    public LibraryArtistsResponse getLibraryArtists(AuthorizationCodeCredentials credentials,
                                                    List<String> artistIds) throws TooManyRequestsException
    {
        try
        {
            Artist[] artists = SpotifyApiClient.build(credentials)
                                               .getSeveralArtists(artistIds.toArray(new String[0]))
                                               .build()
                                               .execute();


            return new LibraryArtistsResponse(Arrays.asList(artists));
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
