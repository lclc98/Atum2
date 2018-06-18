package com.teammetallurgy.atum.entity.undead;

import com.teammetallurgy.atum.init.AtumItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class EntityForsaken extends EntityUndeadBase {

    public EntityForsaken(World world) {
        super(world);
        this.experienceValue = 6;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
    }

    @Override
    protected float getBurnDamage() {
        return 0.5F;
    }

    @Override
    protected void dropFewItems(boolean recentlyHit, int looting) {
        if (this.rand.nextInt(4) == 0) {
            int amount = MathHelper.getInt(new Random(), 1, 2) + looting;
            this.dropItem(AtumItems.DUSTY_BONE, amount);
        }
    }
}