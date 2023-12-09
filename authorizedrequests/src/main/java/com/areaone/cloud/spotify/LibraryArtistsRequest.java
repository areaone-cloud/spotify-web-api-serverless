package com.areaone.cloud.spotify;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.SavedTrack;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryRequest
{
    List<ArtistSimplified> getLibraryArtistsSimplified(AuthorizationCodeCredentials credentials)
    {
        SpotifyApi spotifyApi = SpotifyApiClient.build(credentials);

        try
        {
            Paging<SavedTrack> savedTracks = spotifyApi.getUsersSavedTracks()
                                                       .build()
                                                       .execute();

            return Stream.of(savedTracks.getItems())
                         .flatMap(t -> Stream.of(t.getTrack()
                                                  .getArtists()))
                         .collect(Collectors.toList());
        }
        catch (IOException | SpotifyWebApiException | ParseException e)
        {
            throw new RuntimeException(e);
        }
    }
}
