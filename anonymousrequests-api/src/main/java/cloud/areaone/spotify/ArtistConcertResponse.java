package cloud.areaone.spotify;

import java.util.List;

public class ArtistConcertResponse
{
    public Artist artist;
    public List<ConcertWrapper> concerts;

    public ArtistConcertResponse()
    {
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static final class Builder
    {
        private Artist artist;
        private List<ConcertWrapper> concerts;

        private Builder()
        {
        }

        public Builder withArtist(Artist artist)
        {
            this.artist = artist;
            return this;
        }

        public Builder withConcerts(List<ConcertWrapper> concerts)
        {
            this.concerts = concerts;
            return this;
        }

        public ArtistConcertResponse build()
        {
            ArtistConcertResponse artistConcertResponse = new ArtistConcertResponse();
            artistConcertResponse.concerts = this.concerts;
            artistConcertResponse.artist = this.artist;
            return artistConcertResponse;
        }
    }
}
