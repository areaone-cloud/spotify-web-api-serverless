package cloud.areaone.spotify;

public class ClickThru
{
    public String partnerDisplayName;
    public String url;
    public String imageURL;

    public ClickThru()
    {
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static final class Builder
    {
        private String partnerDisplayName;
        private String url;
        private String imageURL;

        private Builder()
        {
        }

        public Builder withPartnerDisplayName(String partnerDisplayName)
        {
            this.partnerDisplayName = partnerDisplayName;
            return this;
        }

        public Builder withUrl(String url)
        {
            this.url = url;
            return this;
        }

        public Builder withImageURL(String imageURL)
        {
            this.imageURL = imageURL;
            return this;
        }

        public ClickThru build()
        {
            ClickThru clickThru = new ClickThru();
            clickThru.url = this.url;
            clickThru.partnerDisplayName = this.partnerDisplayName;
            clickThru.imageURL = this.imageURL;
            return clickThru;
        }
    }
}
