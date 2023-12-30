package cloud.areaone.spotify;

import java.util.List;

public class Concert
{
    private String id;
    private List<String> artistUris;
    private List<Artist> artists;
    private String date;
    private String title;
    private String location;
    private String venue;
    private Double lat;
    private Double lon;
    private List<PartnerConcert> partnerConcerts;
    private StartDate startDate;
    private Boolean festival;
    private List<Ticketing> ticketing;
    private String artistNameTitle;
    private String carouselArtistGid;
    private String carouselImage;
    private String carouselArtistName;
    private Boolean isParent;
    private String category;
    private Boolean isFirstParty;
    private List<Ticketer> ticketers;
    private EndDate endDate;

    public Concert()
    {
    }

    public static final class Builder
    {
        private String id;
        private List<String> artistUris;
        private List<Artist> artists;
        private String date;
        private String title;
        private String location;
        private String venue;
        private Double lat;
        private Double lon;
        private List<PartnerConcert> partnerConcerts;
        private StartDate startDate;
        private Boolean festival;
        private List<Ticketing> ticketing;
        private String artistNameTitle;
        private String carouselArtistGid;
        private String carouselImage;
        private String carouselArtistName;
        private Boolean isParent;
        private String category;
        private Boolean isFirstParty;
        private List<Ticketer> ticketers;
        private EndDate endDate;

        private Builder()
        {
        }

        public static Builder aConcert()
        {
            return new Builder();
        }

        public Builder withId(String id)
        {
            this.id = id;
            return this;
        }

        public Builder withArtistUris(List<String> artistUris)
        {
            this.artistUris = artistUris;
            return this;
        }

        public Builder withArtists(List<Artist> artists)
        {
            this.artists = artists;
            return this;
        }

        public Builder withDate(String date)
        {
            this.date = date;
            return this;
        }

        public Builder withTitle(String title)
        {
            this.title = title;
            return this;
        }

        public Builder withLocation(String location)
        {
            this.location = location;
            return this;
        }

        public Builder withVenue(String venue)
        {
            this.venue = venue;
            return this;
        }

        public Builder withLat(Double lat)
        {
            this.lat = lat;
            return this;
        }

        public Builder withLon(Double lon)
        {
            this.lon = lon;
            return this;
        }

        public Builder withPartnerConcerts(List<PartnerConcert> partnerConcerts)
        {
            this.partnerConcerts = partnerConcerts;
            return this;
        }

        public Builder withStartDate(StartDate startDate)
        {
            this.startDate = startDate;
            return this;
        }

        public Builder withFestival(Boolean festival)
        {
            this.festival = festival;
            return this;
        }

        public Builder withTicketing(List<Ticketing> ticketing)
        {
            this.ticketing = ticketing;
            return this;
        }

        public Builder withArtistNameTitle(String artistNameTitle)
        {
            this.artistNameTitle = artistNameTitle;
            return this;
        }

        public Builder withCarouselArtistGid(String carouselArtistGid)
        {
            this.carouselArtistGid = carouselArtistGid;
            return this;
        }

        public Builder withCarouselImage(String carouselImage)
        {
            this.carouselImage = carouselImage;
            return this;
        }

        public Builder withCarouselArtistName(String carouselArtistName)
        {
            this.carouselArtistName = carouselArtistName;
            return this;
        }

        public Builder withIsParent(Boolean isParent)
        {
            this.isParent = isParent;
            return this;
        }

        public Builder withCategory(String category)
        {
            this.category = category;
            return this;
        }

        public Builder withIsFirstParty(Boolean isFirstParty)
        {
            this.isFirstParty = isFirstParty;
            return this;
        }

        public Builder withTicketers(List<Ticketer> ticketers)
        {
            this.ticketers = ticketers;
            return this;
        }

        public Builder withEndDate(EndDate endDate)
        {
            this.endDate = endDate;
            return this;
        }

        public Concert build()
        {
            Concert concert = new Concert();
            concert.venue = this.venue;
            concert.carouselArtistGid = this.carouselArtistGid;
            concert.ticketers = this.ticketers;
            concert.lat = this.lat;
            concert.category = this.category;
            concert.partnerConcerts = this.partnerConcerts;
            concert.id = this.id;
            concert.isFirstParty = this.isFirstParty;
            concert.startDate = this.startDate;
            concert.ticketing = this.ticketing;
            concert.location = this.location;
            concert.carouselImage = this.carouselImage;
            concert.festival = this.festival;
            concert.isParent = this.isParent;
            concert.artistNameTitle = this.artistNameTitle;
            concert.endDate = this.endDate;
            concert.lon = this.lon;
            concert.carouselArtistName = this.carouselArtistName;
            concert.artistUris = this.artistUris;
            concert.artists = this.artists;
            concert.title = this.title;
            concert.date = this.date;
            return concert;
        }
    }
}
