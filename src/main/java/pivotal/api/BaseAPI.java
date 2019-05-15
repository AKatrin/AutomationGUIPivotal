package pivotal.api;

import core.selenium.utils.LoaderPropertiesFile;

public abstract class BaseAPI {

    final String X_TRACKER_TOKEN = "X-TrackerToken";

    /**
     * Header value for the token.
     */
    String trackerTokenValue;
    /**
     * Header name for the content type.
     */
    final String CONTENT_TYPE = "Content-Type";

    /**
     * Header value for content type.
     */
     String contentTypeValue;

    /**
     * Base url to do requests by API.
     */
    String apiBaseURL = LoaderPropertiesFile.getInstance().getProperties().get("urlAPI");

    protected BaseAPI(){
        trackerTokenValue = LoaderPropertiesFile.getInstance().getProperties().get(X_TRACKER_TOKEN);
        contentTypeValue = LoaderPropertiesFile.getInstance().getProperties().get(CONTENT_TYPE);
    }
}
