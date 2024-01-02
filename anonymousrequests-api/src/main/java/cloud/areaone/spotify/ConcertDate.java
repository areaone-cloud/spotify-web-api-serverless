package cloud.areaone.spotify;

public class ConcertDate
{
    public String date;
    public Integer utcOffset;
    public String localDate;
    public Boolean unknownTime;

    public ConcertDate()
    {
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static final class Builder
    {
        private String date;
        private Integer utcOffset;
        private String localDate;
        private Boolean unknownTime;

        private Builder()
        {
        }

        public Builder withDate(String date)
        {
            this.date = date;
            return this;
        }

        public Builder withUtcOffset(Integer utcOffset)
        {
            this.utcOffset = utcOffset;
            return this;
        }

        public Builder withLocalDate(String localDate)
        {
            this.localDate = localDate;
            return this;
        }

        public Builder withUnknownTime(Boolean unknownTime)
        {
            this.unknownTime = unknownTime;
            return this;
        }

        public ConcertDate build()
        {
            ConcertDate endDate = new ConcertDate();
            endDate.utcOffset = this.utcOffset;
            endDate.localDate = this.localDate;
            endDate.unknownTime = this.unknownTime;
            endDate.date = this.date;
            return endDate;
        }
    }
}
