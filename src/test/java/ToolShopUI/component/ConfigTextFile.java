package ToolShopUI.component;

public class ConfigTextFile {
    private String browserType;
    private String siteUrl;

    public ConfigTextFile()
    {
        this.browserType = "chrome";
        this.siteUrl = "https://practicesoftwaretesting.com/";
    }
    public ConfigTextFile(String browserType, String siteUrl) {
        this.browserType = browserType;
        this.siteUrl = siteUrl;
    }

    public ConfigTextFile(ConfigTextFile iConfigTextFile) {
        this.browserType = iConfigTextFile.getBrowserType();
        this.siteUrl = iConfigTextFile.getSiteUrl();
    }

    public String getBrowserType() {
        return browserType;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setBrowserType(String iBrowserType)
    {
        this.browserType = iBrowserType;
    }

    public void setSiteUrl(String iSiteUrl)
    {
        this.siteUrl = iSiteUrl;
    }


}
