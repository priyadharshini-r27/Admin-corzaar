package utils;

public class Constant {

 public static final int IMPLICIT_WAIT_TIME = 10;
 public static final int EXPLICIT_WAIT_TIME = 10;
 public static final int PAGE_LOAD_TIME = 20;

 public static String getEmailId() {
 return ConfigReader.getProperty("validmailid");
 }

 public static String getPassword() {
 return ConfigReader.getProperty("validpassword");
 }

 public static String getOtp() {
 return ConfigReader.getProperty("validotp");
 }
}