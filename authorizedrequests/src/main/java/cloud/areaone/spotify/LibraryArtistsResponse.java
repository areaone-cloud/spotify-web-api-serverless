package cloud.areaone.spotify;

import se.michaelthelin.spotify.model_objects.specification.Artist;

import java.util.List;

public class LibraryArtistsResponse
{
    private final List<Artist> artists;

    public LibraryArtistsResponse(List<Artist> artists)
    {
        this.artists = artists;
    }

    public List<Artist> getArtists()
    {
        return artists;
    }
}
