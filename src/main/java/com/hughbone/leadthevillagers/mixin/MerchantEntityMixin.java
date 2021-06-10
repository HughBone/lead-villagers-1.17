package com.hughbone.leadthevillagers.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MerchantEntity.class)
abstract class MerchantEntityMixin extends PassiveEntity {

	protected MerchantEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "canBeLeashedBy", at = @At("RETURN"), cancellable = true)
	private void onCanBeLeashedBy(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(cir.getReturnValue() || !this.isLeashed());
	}
}
