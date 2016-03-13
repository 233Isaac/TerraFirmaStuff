package com.technode.terrafirmastuff.block.clay;

import com.technode.terrafirmastuff.core.ModDetails;
import com.technode.terrafirmastuff.core.reference.CreativeTab;
import com.technode.terrafirmastuff.core.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockClayChiseled extends BlockClayRotatableDecor {

    public BlockClayChiseled()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTab.TFS_TAB);
        this.names = new String[16];
        System.arraycopy(Reference.COLOURS, 0, names, 0, 16);
        this.sideIcons = new IIcon[names.length];
        this.topIcons = new IIcon[names.length];
        this.rotatedSideIcons = new IIcon[names.length];
    }
    /**
     * Gets the block's texture. Args: side, meta
     */

    @SideOnly(Side.CLIENT)
    @Override
    protected IIcon getSideIcon(int meta)
    {
        if ((meta & 12) == 0) {
            return this.rotatedSideIcons[meta];
        } else if ((meta & 12) == 8) {
            return this.rotatedSideIcons[meta];
        }
        return this.sideIcons[meta];
    }

    @SideOnly(Side.CLIENT)
    @Override
    protected IIcon getTopIcon(int meta)
    {
        return this.topIcons[meta];
    }
    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        for(int i = 0; i < names.length; i++)
        {
            sideIcons[i] = reg.registerIcon(ModDetails.ModID + ":" + "clay/" + "blockHardenedClayChiseledSide" + names[i]);
            topIcons[i] = reg.registerIcon(ModDetails.ModID + ":" + "clay/" + "blockHardenedClayChiseledTop" + names[i]);
            rotatedSideIcons[i] = reg.registerIcon(ModDetails.ModID + ":" + "clay/" + "blockHardenedClayChiseledSideRotate" + names[i]);
        }
    }
}