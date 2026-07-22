package com.example.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class TestClickGuiScreen extends Screen {
    public TestClickGuiScreen() {
        super(Text.literal("Test ClickGUI"));
    }

    @Override
    protected void init() {
        super.init();

        addDrawableChild(ButtonWidget.builder(
                Text.literal("Test Button"),
                button -> {
                    // Intentionally does nothing.
                })
                .dimensions(this.width / 2 - 90, this.height / 2 - 10, 180, 20)
                .build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        context.drawTextWithShadow(
                this.textRenderer,
                Text.literal("Right Shift opens this GUI"),
                this.width / 2 - 95,
                40,
                0xFFFFFF
        );
    }
}
