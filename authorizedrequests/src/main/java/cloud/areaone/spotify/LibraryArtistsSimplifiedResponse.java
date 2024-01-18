package cloud.areaone.spotify;

import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;

import java.util.List;

public class LibraryArtistsSimplifiedResponse
{
    private final List<ArtistSimplified> artistsSimplified;
    private final boolean hasNext;

    public LibraryArtistsSimplifiedResponse(List<ArtistSimplified> artistsSimplified, boolean hasNext)
    {
        this.artistsSimplified = artistsSimplified;
        this.hasNext = hasNext;
    }

    public List<ArtistSimplified> getArtistsSimplified()
    {
        return artistsSimplified;
    }

    public boolean isHasNext()
    {
        return hasNext;
    }
}
