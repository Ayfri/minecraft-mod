package fr.ayfri.mod

import fr.ayfri.mod.blocks.initBlocks
import fr.ayfri.mod.items.initItems
import net.fabricmc.api.ModInitializer

const val mod_id = "aymod"

/**
 * SUBS GIFTS :
 * Splashley * 5
 */

/**
 * SUBS :
 * Splashley
 * Ocelus
 */

/**
 * Bits :
 * Ocelus * 1024
 * Splashley * 550
 * CHARLITOTI * 12
 */

class AyMod : ModInitializer {
	override fun onInitialize() {
		initBlocks()
		initItems()
		println("AyMod loaded !")
	}
}
