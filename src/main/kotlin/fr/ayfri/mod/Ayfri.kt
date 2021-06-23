package fr.ayfri.mod

import fr.ayfri.mod.blocks.initBlocks
import net.fabricmc.api.ModInitializer

const val mod_id = "aymod"

class Ayfri : ModInitializer {
	override fun onInitialize() {
		initBlocks()
		println("AyMod loaded !")
	}
}
