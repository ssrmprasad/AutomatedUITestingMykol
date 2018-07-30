package AutomatedUITestingJava.AutomatedUITesting;

import java.util.HashSet;

public enum Platform {
	CHROME("chrome"),
	FIREFOX("firefox"),
	IE("ie"),
	SAFARI("safari"),
	OPERA("opera"),
	ANDROID_NATIVE("android_native"),
	IOS_NATIVE("ios_native"),
	ANY("anu");
	
	private String value;

	private Platform(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public boolean isAndroidNative()
	{
		return this.equals(ANDROID_NATIVE);
	}
	public boolean isIOSNative()
	{
		return this.equals(IOS_NATIVE);
	}
	public boolean isMobile()
	{
		return new HashSet<Platform>()
				{
					private static final long serialVerion=1L;
					{
						add(ANDROID_NATIVE);
						add(IOS_NATIVE);
					}
				}.contains(this);
	}
}
