package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
    "classpath:config/real.properties")
public interface RealConfig extends Config {

  @Key("hub.url")
  String hubUrl();

  @Key("deviceName")
  String deviceName();

  @Key("language")
  String language();

  @Key("platformName")
  String platformName();

  @Key("locale")
  String locale();

  @Key("version")
  String version();
}