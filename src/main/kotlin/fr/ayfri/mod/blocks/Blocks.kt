package fr.ayfri.mod.blocks

import net.minecraft.block.BlockState
import net.minecraft.block.Material
import net.minecraft.item.Item
import net.minecraft.sound.BlockSoundGroup


val BLOCKS = mutableMapOf<String, BaseBlock>()
val BLOCK_ITEMS = mutableMapOf<String, BaseBlockItem>()

fun initBlocks() {
	val stoneMountainBlock = object : BaseBlock("stone_mountain", Material.STONE) {
		override fun getSoundGroup(state: BlockState?) = BlockSoundGroup.DEEPSLATE_TILES
	}
	
	addBlock(stoneMountainBlock)
	addBlockItem(BLOCKS["stone_mountain"]!!)
	
	register()
}

fun addBlockItem(block: BaseBlock, settings: Item.Settings = Item.Settings()) = BLOCK_ITEMS.put(block.id, BaseBlockItem(block, settings))

fun addBlock(block: BaseBlock) = BLOCKS.put(block.id, block)

fun register() {
	BLOCKS.values.forEach(BaseBlock::register)
	BLOCK_ITEMS.values.forEach(BaseBlockItem::register)
}
