package cloud.areaone.spotify;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

class ArtistConcertsRequestTest
{

    @Test
    void getArtistConcerts()
    {
        String accessToken = "BQCmKQrZTjtvM2ckXcZTLZGtimZ93JxlOCrAh6O1J3jPDG0p6Bpm_JT1lOXUdS91IElEVaOTOGVrNZlTs4JRU7XV90eW9cuz_t_lCG3GX9Iv-PnIrtc";
        AnonymousCodeCredentials anonymousCodeCredentials = new AnonymousCodeCredentials(accessToken, 0L);
        ArtistConcertResponse artistConcerts = new ArtistConcertsRequest().getArtistConcerts(anonymousCodeCredentials,
                                                                                             "1He0ZKninbT4FMEV9hUZKn");
        System.out.println("artistConcerts: " + new Gson().toJson(artistConcerts));
    }
}