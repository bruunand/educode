package com.educode.minecraft.render;

import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.entity.EntityRobot;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderRobot extends RenderLiving<EntityRobot>
{
	public final static ResourceLocation TextureResource = new ResourceLocation(CompilerMod.MODID, CompilerMod.ROBOT_TEXTURE_LOCATION);
	
    public RenderRobot(RenderManager manager)
    {
        super(manager, new ModelPlayer(0.0F, false), 0.2F);
        this.addLayer(new LayerHeldItem(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(EntityRobot entity)
    {
        return TextureResource;
    }
}