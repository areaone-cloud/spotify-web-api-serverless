package cloud.areaone.spotify;

public class PartnerConcert
{
    public String partnerId;
    public String concertId;

    public PartnerConcert()
    {
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static final class Builder
    {
        private String partnerId;
        private String concertId;

        private Builder()
        {
        }

        public Builder withPartnerId(String partnerId)
        {
            this.partnerId = partnerId;
            return this;
        }

        public Builder withConcertId(String concertId)
        {
            this.concertId = concertId;
            return this;
        }

        public PartnerConcert build()
        {
            PartnerConcert partnerConcert = new PartnerConcert();
            partnerConcert.concertId = this.concertId;
            partnerConcert.partnerId = this.partnerId;
            return partnerConcert;
        }
    }
}
