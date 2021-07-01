package fr.ayfri.mod.items

import fr.ayfri.mod.utils.customID
import net.fabricmc.fabric.api.`object`.builder.v1.client.model.FabricModelPredicateProviderRegistry
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsage
import net.minecraft.loot.LootManager
import net.minecraft.loot.condition.KilledByPlayerLootCondition
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.resource.ResourceManager
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Hand
import net.minecraft.util.Identifier
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World


object GoatHornItem : BaseItem("goat_horn", Settings().group(ItemGroup.MATERIALS).maxCount(1)) {
	override fun getMaxUseTime(stack: ItemStack) = 1200
	
	override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
		world.playSound(user, user.blockPos, SoundEvents.EVENT_RAID_HORN, SoundCategory.PLAYERS, 200f, 1f)
		return ItemUsage.consumeHeldItem(world, user, hand)
	}
	
	override fun finishUsing(stack: ItemStack, world: World, user: LivingEntity): ItemStack {
		stopSound()
		return stack
	}
	
	override fun onStoppedUsing(stack: ItemStack?, world: World?, user: LivingEntity?, remainingUseTicks: Int) = stopSound()
	
	private fun stopSound() = MinecraftClient.getInstance().soundManager.stopSounds(SoundEvents.EVENT_RAID_HORN.id, SoundCategory.PLAYERS)
	
	init {
		LootTableLoadingCallback.EVENT.register(LootTableLoadingCallback { _: ResourceManager?, _: LootManager?, id: Identifier?, table: FabricLootSupplierBuilder, _: LootTableLoadingCallback.LootTableSetter? ->
			if (id == customID(this.id)) {
				val poolBuilder = FabricLootPoolBuilder.builder()
					.rolls(ConstantLootNumberProvider.create(1f))
					.withCondition(KilledByPlayerLootCondition.builder().build())
					.withCondition(RandomChanceWithLootingLootCondition.builder(0.1f, 0.02f).build())
					.with(ItemEntry.builder(this))
				
				table.pool(poolBuilder)
			}
		})
		
		FabricModelPredicateProviderRegistry.register(
			this,
			Identifier("using")
		) { itemStack, _, livingEntity, _ ->
			return@register if(livingEntity != null && livingEntity.isUsingItem && livingEntity.activeItem == itemStack) 1f else 0f
		}
	}
}
