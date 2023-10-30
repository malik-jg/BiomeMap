package malikjg.biomemap;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import malikjg.biomemap.BiomeMap;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		BiomeMapFrame biomeMapFrame = new BiomeMapFrame();
		biomeMapFrame.start();
	}
}
