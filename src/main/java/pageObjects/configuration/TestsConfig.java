package pageObjects.configuration;

import pageObjects.configuration.properties.PropertiesLoader;
import pageObjects.configuration.properties.Property;
import pageObjects.configuration.properties.PropertyFile;
import pageObjects.webtestsbase.Browser;

/**
 * Created by Sidelnikov Mikhail on 18.09.14.
 * Class for base tests properties - urls for test, browser name and version
 */
@PropertyFile ("config.properties")
public class TestsConfig {

    private static TestsConfig config;

    public static TestsConfig getConfig() {
        if (config == null) {
            config = new TestsConfig ();
        }
        return config;
    }

    public TestsConfig() {
        PropertiesLoader.populate (this);
    }

    @Property ("browser.name")
    private String browser = "firefox";

    @Property ("browser.version")
    private String version = "";


    /**
     * getting browser object
     *
     * @return browser object
     */
    public Browser getBrowser() {
        Browser browserForTests = Browser.getByName (browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException ("Browser name '" + browser + "' is not valid");
        }
    }

    /**
     * getting browser version
     *
     * @return browser version
     */
    public String getBrowserVersion() {
        return version;
    }


}
