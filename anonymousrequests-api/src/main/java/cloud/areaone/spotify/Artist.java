package cloud.areaone.spotify;

public class Artist
{
    public String uri;
    public String name;
    public String imageUri;
    public String topTrackUri;
    public String bio;
    public Integer monthlyListeners;
    public String id;

    public Artist()
    {
    }

    public static Builder builder()
    {
        return new Builder();
    }


    public static final class Builder
    {
        private String uri;
        private String name;
        private String imageUri;
        private String topTrackUri;
        private String bio;
        private Integer monthlyListeners;
        private String id;

        private Builder()
        {
        }

        public Builder withUri(String uri)
        {
            this.uri = uri;
            return this;
        }

        public Builder withName(String name)
        {
            this.name = name;
            return this;
        }

        public Builder withImageUri(String imageUri)
        {
            this.imageUri = imageUri;
            return this;
        }

        public Builder withTopTrackUri(String topTrackUri)
        {
            this.topTrackUri = topTrackUri;
            return this;
        }

        public Builder withBio(String bio)
        {
            this.bio = bio;
            return this;
        }

        public Builder withMonthlyListeners(Integer monthlyListeners)
        {
            this.monthlyListeners = monthlyListeners;
            return this;
        }

        public Builder withId(String id)
        {
            this.id = id;
            return this;
        }

        public Artist build()
        {
            Artist artist = new Artist();
            artist.uri = this.uri;
            artist.id = this.id;
            artist.topTrackUri = this.topTrackUri;
            artist.bio = this.bio;
            artist.monthlyListeners = this.monthlyListeners;
            artist.imageUri = this.imageUri;
            artist.name = this.name;
            return artist;
        }
    }
}
