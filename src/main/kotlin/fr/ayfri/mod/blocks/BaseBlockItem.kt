package fr.ayfri.mod.blocks

import fr.ayfri.mod.utils.IDOwner
import fr.ayfri.mod.utils.getFullID
import net.minecraft.item.BlockItem
import net.minecraft.util.registry.Registry

class BaseBlockItem(block: BaseBlock, settings: Settings) : BlockItem(block, settings), IDOwner {
	override var id = block.id
	
	override val fullID
		get() = getFullID(id)
	
	override fun register() {
		Registry.register(Registry.ITEM, fullID, this)
		println("Added block item '$fullID' !")
	}
}
