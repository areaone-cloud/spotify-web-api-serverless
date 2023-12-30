package cloud.areaone.spotify;

import se.michaelthelin.spotify.enums.AuthorizationScope;

import java.util.List;

public class AuthorizationInput
{
    private final List<AuthorizationScope> scopes;

    public AuthorizationInput(List<AuthorizationScope> scopes)
    {
        this.scopes = scopes;
    }

    public List<AuthorizationScope> getScopes()
    {
        return scopes;
    }
}
