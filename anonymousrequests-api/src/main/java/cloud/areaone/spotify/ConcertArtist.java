package cloud.areaone.spotify;

public class ConcertArtist
{
    public String uri;

    public ConcertArtist(String uri)
    {
        this.uri = uri;
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static final class Builder
    {
        private String uri;

        private Builder()
        {
        }

        public Builder withUri(String uri)
        {
            this.uri = uri;
            return this;
        }

        public ConcertArtist build()
        {
            return new ConcertArtist(uri);
        }
    }
}
