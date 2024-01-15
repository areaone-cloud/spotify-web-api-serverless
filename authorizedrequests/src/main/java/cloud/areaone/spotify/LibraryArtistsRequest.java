package cloud.areaone.spotify;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.enums.ModelObjectType;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.SavedTrack;
import se.michaelthelin.spotify.requests.data.library.GetUsersSavedTracksRequest;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryArtistsRequest
{
    public LibraryArtistsResponse getLibraryArtists(AuthorizationCodeCredentials credentials,
                                                    List<String> previouslyFetchedIds,
                                                    Integer limit,
                                                    Integer offset)
    {
        LibraryArtistSimplifiedResponse response = getLibraryArtistsSimplified(credentials,
                                                                               previouslyFetchedIds,
                                                                               limit,
                                                                               offset);

        SpotifyApi requestBuilder = SpotifyApiClient.build(credentials);

        List<Artist> artists = response.getArtistsSimplified()
                                       .stream()
                                       .map(a -> executeArtistRequest(requestBuilder, a))
                                       .collect(Collectors.toList());

        return new LibraryArtistsResponse(artists, response.isHasNext());
    }

    public LibraryArtistSimplifiedResponse getLibraryArtistsSimplified(AuthorizationCodeCredentials credentials,
                                                                       List<String> previouslyFetchedIds,
                                                                       Integer limit,
                                                                       Integer offset)
    {
        GetUsersSavedTracksRequest.Builder requestBuilder = SpotifyApiClient.build(credentials)
                                                                            .getUsersSavedTracks();

        try
        {
            List<String> previousIds = Optional.ofNullable(previouslyFetchedIds)
                                               .orElse(Collections.emptyList());

            Optional.ofNullable(limit)
                    .ifPresent(requestBuilder::limit);

            Optional.ofNullable(offset)
                    .ifPresent(requestBuilder::offset);

            Paging<SavedTrack> savedTracks = requestBuilder.build()
                                                           .execute();

            List<ArtistSimplified> artistsSimplified = Stream.of(savedTracks.getItems())
                                                             .flatMap(t -> Stream.of(t.getTrack()
                                                                                      .getArtists()))
                                                             .filter(a -> a.getType()
                                                                           .equals(ModelObjectType.ARTIST))
                                                             .filter(a -> !previousIds.contains(a.getId()))
                                                             .distinct()
                                                             .collect(Collectors.toList());

            boolean hasNext = savedTracks.getNext() != null && !savedTracks.getNext()
                                                                           .isEmpty();

            return new LibraryArtistSimplifiedResponse(artistsSimplified, hasNext);
        }
        catch (IOException | SpotifyWebApiException | ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static Artist executeArtistRequest(SpotifyApi requestBuilder, ArtistSimplified a)
    {
        try
        {
            return requestBuilder.getArtist(a.getId())
                                 .build()
                                 .execute();
        }
        catch (IOException | SpotifyWebApiException | ParseException e)
        {
            throw new RuntimeException(e);
        }
    }
}
