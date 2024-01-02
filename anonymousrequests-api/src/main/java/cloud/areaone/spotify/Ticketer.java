package cloud.areaone.spotify;

public class Ticketer
{
    public String partnerDisplayName;
    public String url;
    public String imageURL;
    public String type;
    public String minPrice;
    public String maxPrice;
    public Boolean soldOut;
    public String partnerURL;
    public ConcertDate startDate;
    public ConcertDate endDate;

    public Ticketer()
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
        private String type;
        private String minPrice;
        private String maxPrice;
        private Boolean soldOut;
        private String partnerURL;
        private ConcertDate startDate;
        private ConcertDate endDate;

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

        public Builder withType(String type)
        {
            this.type = type;
            return this;
        }

        public Builder withMinPrice(String minPrice)
        {
            this.minPrice = minPrice;
            return this;
        }

        public Builder withMaxPrice(String maxPrice)
        {
            this.maxPrice = maxPrice;
            return this;
        }

        public Builder withSoldOut(Boolean soldOut)
        {
            this.soldOut = soldOut;
            return this;
        }

        public Builder withPartnerURL(String partnerURL)
        {
            this.partnerURL = partnerURL;
            return this;
        }

        public Builder withConcertDate(ConcertDate startDate)
        {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(ConcertDate endDate)
        {
            this.endDate = endDate;
            return this;
        }

        public Ticketer build()
        {
            Ticketer ticketer = new Ticketer();
            ticketer.soldOut = this.soldOut;
            ticketer.type = this.type;
            ticketer.partnerURL = this.partnerURL;
            ticketer.startDate = this.startDate;
            ticketer.minPrice = this.minPrice;
            ticketer.maxPrice = this.maxPrice;
            ticketer.imageURL = this.imageURL;
            ticketer.endDate = this.endDate;
            ticketer.partnerDisplayName = this.partnerDisplayName;
            ticketer.url = this.url;
            return ticketer;
        }
    }
}
