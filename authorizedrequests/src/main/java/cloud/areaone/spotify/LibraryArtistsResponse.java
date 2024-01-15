package cloud.areaone.spotify;

import se.michaelthelin.spotify.model_objects.specification.Artist;

import java.util.List;

public class LibraryArtistsResponse
{
    private final List<Artist> artists;
    private final boolean hasNext;

    public LibraryArtistsResponse(List<Artist> artists, boolean hasNext)
    {
        this.artists = artists;
        this.hasNext = hasNext;
    }

    public List<Artist> getArtists()
    {
        return artists;
    }

    public boolean isHasNext()
    {
        return hasNext;
    }
}
