package cloud.areaone.spotify;

public class StartDate
{
    public String date;
    public Integer utcOffset;
    public String localDate;
    public Boolean unknownTime;

    public StartDate()
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

        public StartDate build()
        {
            StartDate startDate = new StartDate();
            startDate.unknownTime = this.unknownTime;
            startDate.utcOffset = this.utcOffset;
            startDate.date = this.date;
            startDate.localDate = this.localDate;
            return startDate;
        }
    }
}
