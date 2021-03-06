package com.technode.terrafirmastuff;

import com.technode.terrafirmastuff.core.*;
import com.technode.terrafirmastuff.core.proxy.CommonProxy;
import com.technode.terrafirmastuff.core.utility.LogHelper;
import com.technode.terrafirmastuff.handler.ChunkEventHandler;
import com.technode.terrafirmastuff.handler.ConfigurationHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ModDetails.ModID, name = ModDetails.ModName, version = ModDetails.ModVersion, guiFactory = ModDetails.GUI_FACTORY_CLASS)

public class TerraFirmaStuff
{
    @Instance(ModDetails.ModID)
    public static TerraFirmaStuff instance;
  //  public static final String AssetPath = "/assets/" + ModDetails.ModID + "/";
    //public static final String AssetPathGui = "textures/gui";

    @SidedProxy(clientSide = ModDetails.CLIENT_PROXY_CLASS, serverSide = ModDetails.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

 //   public File getMinecraftDirectory() { return proxy.getMinecraftDirectory(); }

    @EventHandler
    public void preInitialize(FMLPreInitializationEvent e)
    {
        instance = this;
        ConfigurationHandler.init(e.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        LogHelper.info("Pre Initialization Complete");

        proxy.registerTileEntities(true);
        ModItems.itemReferences();
        ModBlocks.blockReferences();
        ModBlocks.setupFire();
    }

    @EventHandler
    public void initialize(FMLInitializationEvent e)
    {
        LogHelper.info("Initialization Complete");

        // Register Crafting Handler
        FMLCommonHandler.instance().bus().register(new com.technode.terrafirmastuff.handler.CraftingHandler());
        FMLCommonHandler.instance().bus().register(instance);

        // Register the Chunk Load/Save Handler
        MinecraftForge.EVENT_BUS.register(new ChunkEventHandler());

        Recipes.registerRecipes();

        proxy.registerChiselModes();

        ItemHeat.setupItemHeat();
        ModItems.registerFurnaceFuel();

        proxy.registerWailaClasses();
        proxy.hideNEIItems();
    }

    @EventHandler
    public void postInitialize(FMLPostInitializationEvent e)
    {
        LogHelper.info("Post Initialization Complete");
    }
}
