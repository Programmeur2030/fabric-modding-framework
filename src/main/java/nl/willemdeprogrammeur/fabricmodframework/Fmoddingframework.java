package nl.willemdeprogrammeur.fabricmodframework;

import net.fabricmc.api.ModInitializer;

import nl.willemdeprogrammeur.fabricmodframework.register.basic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fmoddingframework implements ModInitializer {
	public static final String MOD_ID = "f-modding-framework";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("loading moding framework. next updates will be in dutch");
		basic.Register_Basic();
	}
}