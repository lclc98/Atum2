package com.teammetallurgy.atum.client.render.entity;

import com.teammetallurgy.atum.client.model.entity.ModelStonewarden;
import com.teammetallurgy.atum.entity.stone.EntityStonewarden;
import com.teammetallurgy.atum.utils.Constants;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class RenderStonewarden extends RenderLiving<EntityStonewarden> {
    private static final ResourceLocation STONEWARDEN_TEXTURES = new ResourceLocation(Constants.MOD_ID, "textures/entities/stonewarden.png");

    public RenderStonewarden(RenderManager manager) {
        super(manager, new ModelStonewarden(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(@Nonnull EntityStonewarden stonewarden) {
        return STONEWARDEN_TEXTURES;
    }

    @Override
    protected void applyRotations(EntityStonewarden stonewarden, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(stonewarden, ageInTicks, rotationYaw, partialTicks);
        if ((double) stonewarden.limbSwingAmount >= 0.01D) {
            float swingValue = stonewarden.limbSwing - stonewarden.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
            float swing = (Math.abs(swingValue % 13.0F - 6.5F) - 3.25F) / 3.25F;
            GlStateManager.rotate(6.5F * swing, 0.0F, 0.0F, 1.0F);
        }
    }
}