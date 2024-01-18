package cloud.areaone.spotify;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.enums.ModelObjectType;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.exceptions.detailed.TooManyRequestsException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.SavedTrack;
import se.michaelthelin.spotify.requests.data.library.GetUsersSavedTracksRequest;

import java.io.IOException;
import java.time.Instant;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryArtistsSimplifiedRequest
{
    public LibraryArtistsSimplifiedResponse getLibraryArtistsSimplified(AuthorizationCodeCredentials credentials,
                                                                        int limit,
                                                                        int offset) throws TooManyRequestsException
    {
        GetUsersSavedTracksRequest.Builder requestBuilder = SpotifyApiClient.build(credentials)
                                                                            .getUsersSavedTracks();

        try
        {
            Paging<SavedTrack> savedTracks = requestBuilder.limit(limit)
                                                           .offset(offset)
                                                           .build()
                                                           .execute();

            List<ArtistSimplified> artistsSimplified = Stream.of(savedTracks.getItems())
                                                             .map(t -> t.getTrack()
                                                                        .getArtists()[0])
                                                             .filter(a -> a.getType()
                                                                           .equals(ModelObjectType.ARTIST))
                                                             .distinct()
                                                             .collect(Collectors.toList());

            Instant newestAddedTime = Stream.of(savedTracks.getItems())
                                            .map(SavedTrack::getAddedAt)
                                            .map(Date::toInstant)
                                            .max(Comparator.naturalOrder())
                                            .orElse(Instant.now());

            boolean hasNext = savedTracks.getNext() != null && !savedTracks.getNext()
                                                                           .isEmpty();

            return new LibraryArtistsSimplifiedResponse(artistsSimplified,
                                                        hasNext,
                                                        newestAddedTime);
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
