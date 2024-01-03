package cloud.areaone.spotify;

import java.util.List;

public class ConcertWrapper
{
    public Concert concert;
    public String clickThruUrl;
    public Boolean nearUser;
    public List<ClickThru> clickThrus;

    public ConcertWrapper()
    {
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static final class Builder
    {
        private Concert concert;
        private String clickThruUrl;
        private Boolean nearUser;
        private List<ClickThru> clickThrus;

        private Builder()
        {
        }

        public Builder withConcert(Concert concert)
        {
            this.concert = concert;
            return this;
        }

        public Builder withClickThruUrl(String clickThruUrl)
        {
            this.clickThruUrl = clickThruUrl;
            return this;
        }

        public Builder withNearUser(Boolean nearUser)
        {
            this.nearUser = nearUser;
            return this;
        }

        public Builder withClickThrus(List<ClickThru> clickThrus)
        {
            this.clickThrus = clickThrus;
            return this;
        }

        public ConcertWrapper build()
        {
            ConcertWrapper concertWrapper = new ConcertWrapper();
            concertWrapper.clickThruUrl = this.clickThruUrl;
            concertWrapper.clickThrus = this.clickThrus;
            concertWrapper.nearUser = this.nearUser;
            concertWrapper.concert = this.concert;
            return concertWrapper;
        }
    }
}
