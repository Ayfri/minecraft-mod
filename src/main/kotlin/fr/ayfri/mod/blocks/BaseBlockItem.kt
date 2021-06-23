package fr.ayfri.mod.blocks

import fr.ayfri.mod.utils.getFullID
import net.minecraft.item.BlockItem
import net.minecraft.util.registry.Registry

class BaseBlockItem(block: BaseBlock, settings: Settings) : BlockItem(block, settings) {
	var id: String
	
	init {
		id = block.id;
	}
	val fullID
		get() = getFullID(id)
	
	fun register() {
		Registry.register(Registry.ITEM, fullID, this)
		println("Added block item '$fullID' !")
	}
}
