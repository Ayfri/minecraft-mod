package fr.ayfri.mod.items

import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterials

val ITEMS = mutableMapOf<String, IItem>()

fun initItems() {
	addItem(object : DoubleAxeItem("netherite_double_axe", ToolMaterials.NETHERITE, DoubleAxeSettings().apply {
		attackDamage = 7f
		attackSpeed = -3.1f
		maxDamage(2500)
		group(ItemGroup.TOOLS)
		fireproof()
	}) {
		override fun isEnchantable(stack: ItemStack?): Boolean {
			return super.isEnchantable(stack)
		}
	})
	addItem(DoubleAxeItem("diamond_double_axe", ToolMaterials.DIAMOND, DoubleAxeSettings().apply {
		attackDamage = 7.5f
		attackSpeed = -3.1f
		maxDamage(2000)
		group(ItemGroup.TOOLS)
	}))
	addItem(DoubleAxeItem("iron_double_axe", ToolMaterials.IRON, DoubleAxeSettings().apply {
		attackDamage = 8f
		attackSpeed = -3.2f
		maxDamage(300)
		group(ItemGroup.TOOLS)
	}))
	addItem(DoubleAxeItem("golden_double_axe", ToolMaterials.GOLD, DoubleAxeSettings().apply {
		attackDamage = 8f
		attackSpeed = -3.1f
		maxDamage(50)
		group(ItemGroup.TOOLS)
	}))
	addItem(DoubleAxeItem("stone_double_axe", ToolMaterials.STONE, DoubleAxeSettings().apply {
		attackDamage = 8f
		attackSpeed = -3.3f
		maxDamage(180)
		group(ItemGroup.TOOLS)
	}))
	addItem(DoubleAxeItem("wooden_double_axe", ToolMaterials.WOOD, DoubleAxeSettings().apply {
		attackDamage = 7f
		attackSpeed = -3.3f
		maxDamage(75)
		group(ItemGroup.TOOLS)
	}))
	
	register()
}

fun addItem(item: IItem) = ITEMS.put(item.id, item)

fun register() = ITEMS.values.forEach(IItem::register)
