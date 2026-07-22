package com.example.client;

import com.example.ExampleMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ExampleModClient implements ClientModInitializer {
	private static KeyBinding openGuiKey;

	@Override
	public void onInitializeClient() {
		openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"Open ClickGUI",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_RIGHT_SHIFT,
				"key.category." + ExampleMod.MOD_ID
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (openGuiKey.wasPressed()) {
				client.setScreen(new TestClickGuiScreen());
			}
		});
	}
}