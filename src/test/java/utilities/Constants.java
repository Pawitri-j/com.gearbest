package utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {

	public static final int IMPLICIT_WAIT_TIME = 30;
	public static final int EXPLICIT_WAIT_TIME = 30;

	public static final String SCREENSHOT_FILEPATH = "target/ScreenShotsGeneral/";

	public static final String SCREENSHOT_FILEPATH_FAIL = "target/ScreenShotsForFail/";

	public static final String SCREENSHOT_FILEPATH_PASS = "target/ScreenShotsForPass/";

	public static ArrayList<String> socialMediasBanner 
	= new ArrayList<>(Arrays.asList("facebook", "messenger", "youtube",
			"pinterest", "vk", "instagram", "twitter", "blog", "tumblr"));
	
	public static ArrayList<String> yellowBanner = 
			new ArrayList<>(Arrays.asList("flash-sale", "app-exclusive", "new-products"));
}
