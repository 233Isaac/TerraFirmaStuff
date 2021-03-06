package com.technode.terrafirmastuff.block.clay;

import com.technode.terrafirmastuff.core.reference.CreativeTab;
import com.technode.terrafirmastuff.core.reference.Reference;
import net.minecraft.util.IIcon;

public class BlockClayChiseled3 extends BlockClayChiseled
{
    public BlockClayChiseled3()
    {
        super();
        this.setCreativeTab(CreativeTab.TFS_TAB);
        this.names = new String[4];
        System.arraycopy(Reference.COLOURS, 8, names, 0, 4);
        this.sideIcons = new IIcon[names.length];
        this.topIcons = new IIcon[names.length];
        this.rotatedSideIcons = new IIcon[names.length];
    }
}