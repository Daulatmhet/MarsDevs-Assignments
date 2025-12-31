    package com.marsdevs.Driver;

    import Utils.PropertyUtil;
    import com.marsdevs.Enums.ConfigProperies;
    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;

    import java.util.HashMap;
    import java.util.Map;
    import java.util.Objects;

    public class Driver {


        private Driver(){}

        private static WebDriver driver;

        public static void initDriver() throws Exception {
            if(Objects.isNull(DriverManager.getDriver())) {
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();

                options.addArguments("--disable-notifications");
                options.addArguments("--disable-save-password-bubble");
                options.addArguments("--disable-infobars");
                options.addArguments("--incognito");

                // Headless for CI
                if (Boolean.parseBoolean(System.getenv("HEADLESS"))) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                }

                // 🔥 Unique temp profile (works on ALL machines)
                String tempProfile = System.getProperty("java.io.tmpdir")
                        + "/chrome-profile-" + System.currentTimeMillis();

                options.addArguments("user-data-dir=" + tempProfile);

                // Disable password manager
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);

                DriverManager.setDriver( new ChromeDriver(options) );
                DriverManager.getDriver().get(PropertyUtil.get(ConfigProperies.URL));
                DriverManager.getDriver().manage().window().maximize();
                // DriverManager.getDriver().get(PropertyUtil.get(ConfigProperies.));
                //ExplicitWaitFactory.wai
            }
        }

        public static void quitDriver() {
            if (Objects.nonNull(DriverManager.getDriver())) {
                DriverManager.getDriver().quit();
                DriverManager.unload();
            }
        }
    }


