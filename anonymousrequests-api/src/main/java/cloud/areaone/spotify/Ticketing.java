package cloud.areaone.spotify;

public class Ticketing
{
    public String minPrice;
    public String maxPrice;

    public Ticketing()
    {
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static final class Builder
    {
        private String minPrice;
        private String maxPrice;

        private Builder()
        {
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

        public Ticketing build()
        {
            Ticketing ticketing = new Ticketing();
            ticketing.minPrice = this.minPrice;
            ticketing.maxPrice = this.maxPrice;
            return ticketing;
        }
    }
}
