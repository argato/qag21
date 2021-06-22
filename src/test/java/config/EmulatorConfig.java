package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "classpath:config/emulator.properties"})
public interface EmulatorConfig extends Config {

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