package com.SmithsModding.SmithsCore.Util.Client.Color;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

/**
 * The IIconRegistrar used to retrieve IIcons in form of PlaceHolders from Items for Color Sampling.
 *
 * Created by Orion
 * Created on 14.06.2015
 * 12:19
 * <p/>
 * Copyrighted according to Project specific license
 */
public class PlaceHolderRegistrar implements IIconRegister {

    @Override
    public IIcon registerIcon(String pAddress) {
        return new IconPlaceHolder(new ResourceLocation(pAddress));
    }
}