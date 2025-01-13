package net.antwibuadum.practicemodone.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ExtraFood {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1200), 1.0f).build();
}
