package cloud.areaone.spotify;

import com.google.gson.Gson;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ArtistConcertsRequestTest
{

    @Test
//    @Disabled
    void getArtistConcerts()
    {
        String accessToken = "BQA9myHUp8XY8a8AsO9JC-ruwzzZGuFIdtvKaBtmxvpes6cUvuHyFdtctsb_NqU1HxwlwDfXOSWx1OTHdiFVM8uFCqyAYy_YTP-FuzXQdA5PL7AKvvE";
        AnonymousCodeCredentials anonymousCodeCredentials = new AnonymousCodeCredentials(accessToken, 0L);
        ArtistConcertResponse artistConcerts = new ArtistConcertsRequest().getArtistConcerts(anonymousCodeCredentials,
                                                                                             "1He0ZKninbT4FMEV9hUZKn");
        System.out.println("artistConcerts: " + new Gson().toJson(artistConcerts));
    }
}