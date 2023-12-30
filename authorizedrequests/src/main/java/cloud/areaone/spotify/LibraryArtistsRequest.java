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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryArtistsRequest
{
    public List<ArtistSimplified> getLibraryArtistsSimplified(AuthorizationCodeCredentials credentials,
                                                              Integer limit,
                                                              Integer offset)
    {
        GetUsersSavedTracksRequest.Builder requestBuilder = SpotifyApiClient.build(credentials)
                                                                            .getUsersSavedTracks();

        try
        {
            Optional.ofNullable(limit)
                    .ifPresent(requestBuilder::limit);

            Optional.ofNullable(offset)
                    .ifPresent(requestBuilder::offset);

            Paging<SavedTrack> savedTracks = requestBuilder.build()
                                                           .execute();

            return Stream.of(savedTracks.getItems())
                         .flatMap(t -> Stream.of(t.getTrack()
                                                  .getArtists()))
                         .filter(a -> a.getType()
                                       .equals(ModelObjectType.ARTIST))
                         .distinct()
                         .collect(Collectors.toList());
        }
        catch (IOException | SpotifyWebApiException | ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<ArtistSimplified> getLibraryArtistsSimplified(AuthorizationCodeCredentials credentials, int limit)
    {
        return getLibraryArtistsSimplified(credentials, limit, null);
    }

    public List<ArtistSimplified> getLibraryArtistsSimplified(AuthorizationCodeCredentials credentials)
    {
        return getLibraryArtistsSimplified(credentials, null, null);
    }

    public List<Artist> getLibraryArtists(AuthorizationCodeCredentials credentials, Integer limit, Integer offset)
    {
        List<ArtistSimplified> libraryArtistsSimplified = getLibraryArtistsSimplified(credentials, limit, offset);

        SpotifyApi requestBuilder = SpotifyApiClient.build(credentials);

        return libraryArtistsSimplified.stream()
                                       .map(a -> executeArtistRequest(requestBuilder, a))
                                       .collect(Collectors.toList());
    }

    public List<Artist> getLibraryArtists(AuthorizationCodeCredentials credentials, Integer limit)
    {
        List<ArtistSimplified> libraryArtistsSimplified = getLibraryArtistsSimplified(credentials, limit, null);

        SpotifyApi requestBuilder = SpotifyApiClient.build(credentials);

        return libraryArtistsSimplified.stream()
                                       .map(a -> executeArtistRequest(requestBuilder, a))
                                       .collect(Collectors.toList());
    }

    public List<Artist> getLibraryArtists(AuthorizationCodeCredentials credentials)
    {
        List<ArtistSimplified> libraryArtistsSimplified = getLibraryArtistsSimplified(credentials, null, null);

        SpotifyApi requestBuilder = SpotifyApiClient.build(credentials);

        return libraryArtistsSimplified.stream()
                                       .map(a -> executeArtistRequest(requestBuilder, a))
                                       .collect(Collectors.toList());
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
