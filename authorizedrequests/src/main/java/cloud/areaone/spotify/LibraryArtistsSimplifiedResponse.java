package cloud.areaone.spotify;

import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;

import java.time.Instant;
import java.util.List;

public class LibraryArtistsSimplifiedResponse
{
    private final List<ArtistSimplified> artistsSimplified;
    private final boolean hasNext;
    private final Instant newestAddedTime;

    public LibraryArtistsSimplifiedResponse(List<ArtistSimplified> artistsSimplified,
                                            boolean hasNext,
                                            Instant newestAddedTime)
    {
        this.artistsSimplified = artistsSimplified;
        this.hasNext = hasNext;
        this.newestAddedTime = newestAddedTime;
    }

    public List<ArtistSimplified> getArtistsSimplified()
    {
        return artistsSimplified;
    }

    public boolean isHasNext()
    {
        return hasNext;
    }

    public Instant getNewestAddedTime()
    {
        return newestAddedTime;
    }
}
