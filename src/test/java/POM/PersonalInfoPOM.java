package POM;

import org.openqa.selenium.By;

public class PersonalInfoPOM extends BasePOM {
public By myPersonalInformationButton =By.xpath("//span[text()='My personal information']");
public By firstnameInput =By.id("firstname");
public By passwordInput=By.id("old_passwd");
public By saveButton=By.cssSelector("button[name='submitIdentity']");
public By accountName=By.cssSelector(".account");





}
