package pixelmon.gui;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiContainer;

import org.lwjgl.input.Keyboard;

import pixelmon.battles.BattleController;
import pixelmon.entities.pixelmon.EntityPixelmon;

public class GuiPokemonFaintedChoice extends GuiContainer {

	private EntityPixelmon mypixelmon;
	private BattleController bc;

	public GuiPokemonFaintedChoice(BattleController bc, EntityPixelmon entity) {
		super(new ContainerEmpty());
		mypixelmon = entity;
		this.bc = bc;
	}

	@SuppressWarnings("unchecked")
	public void initGui() {
		super.initGui();
		Keyboard.enableRepeatEvents(true);
		controlList.clear();
		controlList.add(new GuiButton(10, width / 2 - 100, height / 2 - 20,
				"Switch To Another Pokemon"));
		if (!bc.isTrainerVsTrainer())
			controlList.add(new GuiButton(10, width / 2 - 100, height / 2 + 20,
					"Run"));
	}

	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}
	
	public void keyTyped(char i, int i1) {
	}

	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.id == 0) {

		} else {

		}
		mc.thePlayer.closeScreen();
		mc.setIngameFocus();
	}

	protected void mouseClicked(int par1, int par2, int par3) {
		super.mouseClicked(par1, par2, par3);
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int i1) {

		drawDefaultBackground();
		drawCenteredString(fontRenderer, mypixelmon.getName()
				+ "can no longer fight", width / 2, 10, 0xFFFFFF);
	}
}
