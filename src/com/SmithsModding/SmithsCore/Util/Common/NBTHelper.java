/*
 * Copyright (c) 2015.
 *
 * Copyrighted by SmithsModding according to the project License
 */

package com.SmithsModding.SmithsCore.Util.Common;

import com.SmithsModding.SmithsCore.Util.Common.Postioning.Coordinate2D;
import com.SmithsModding.SmithsCore.Util.Common.Postioning.Coordinate3D;
import com.SmithsModding.SmithsCore.Util.CoreReferences;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.UUID;

public class NBTHelper {

    public static Coordinate2D readCoordinate2DFromNBT(NBTTagCompound pCoordinateData) {
        return new Coordinate2D(pCoordinateData.getInteger("XCoord"), pCoordinateData.getInteger("YCoord"));
    }

    public static Coordinate3D readCoordinate3DFromNBT(NBTTagCompound pCoordinateData) {
        return new Coordinate3D(pCoordinateData.getInteger("XCoord"), pCoordinateData.getInteger("YCoord"), pCoordinateData.getInteger("ZCoord"));
    }


    public static NBTTagCompound writeCoordinate2DToNBT(Coordinate2D pCoordinate) {
        NBTTagCompound tCoordinateData = new NBTTagCompound();

        tCoordinateData.setInteger("XCoord", pCoordinate.getXComponent());
        tCoordinateData.setInteger("YCoord", pCoordinate.getYComponent());

        return tCoordinateData;
    }

    public static NBTTagCompound writeCoordinate3DToNBT(Coordinate3D pCoordinate) {
        NBTTagCompound tCoordinateData = new NBTTagCompound();

        tCoordinateData.setInteger("XCoord", pCoordinate.getXComponent());
        tCoordinateData.setInteger("YCoord", pCoordinate.getYComponent());
        tCoordinateData.setInteger("ZCoord", pCoordinate.getZComponent());

        return tCoordinateData;
    }

    private static void initNBTTagCompound(ItemStack itemStack) {
        if (itemStack.stackTagCompound == null) {
            itemStack.setTagCompound(new NBTTagCompound());
        }
    }

    public static boolean hasTag(ItemStack itemStack, String keyName) {
        return itemStack != null && itemStack.stackTagCompound != null && itemStack.stackTagCompound.hasKey(keyName);
    }

    public static void removeTag(ItemStack itemStack, String keyName) {
        if (itemStack.stackTagCompound != null) {
            itemStack.stackTagCompound.removeTag(keyName);
        }
    }

    public static void setBoolean(ItemStack itemStack, String keyName, boolean keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setBoolean(keyName, keyValue);
    }

    public static void setByte(ItemStack itemStack, String keyName, byte keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setByte(keyName, keyValue);
    }

    public static void setByteArray(ItemStack itemStack, String keyName, byte[] keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setByteArray(keyName, keyValue);
    }

    public static void setDouble(ItemStack itemStack, String keyName, double keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setDouble(keyName, keyValue);
    }

    public static void setFloat(ItemStack itemStack, String keyName, float keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setFloat(keyName, keyValue);
    }

    public static void setIntArray(ItemStack itemStack, String keyName, int[] keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setIntArray(keyName, keyValue);
    }

    public static void setInteger(ItemStack itemStack, String keyName, int keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setInteger(keyName, keyValue);
    }

    public static void setLong(ItemStack itemStack, String keyName, long keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setLong(keyName, keyValue);
    }

    public static void setShort(ItemStack itemStack, String keyName, short keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setShort(keyName, keyValue);
    }

    public static void setString(ItemStack itemStack, String keyName, String keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setString(keyName, keyValue);
    }

    public static void setTagCompound(ItemStack itemStack, String keyName, NBTTagCompound keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setTag(keyName, keyValue);
    }

    public static void setTagList(ItemStack itemStack, String keyName, NBTTagList keyValue) {
        initNBTTagCompound(itemStack);
        itemStack.stackTagCompound.setTag(keyName, keyValue);
    }

    public static void setUUID(ItemStack itemStack) {
        initNBTTagCompound(itemStack);
        if (!hasTag(itemStack, CoreReferences.NBT.UUID_MOST_SIG) && !hasTag(itemStack, CoreReferences.NBT.UUID_LEAST_SIG)) {
            UUID itemUUID = UUID.randomUUID();
            setLong(itemStack, CoreReferences.NBT.UUID_MOST_SIG, itemUUID.getMostSignificantBits());
            setLong(itemStack, CoreReferences.NBT.UUID_LEAST_SIG, itemUUID.getLeastSignificantBits());
        }
    }

    public static boolean getBoolean(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setBoolean(itemStack, keyName, false);
        }
        return itemStack.stackTagCompound.getBoolean(keyName);
    }

    public static byte getByte(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setByte(itemStack, keyName, (byte) 0);
        }
        return itemStack.stackTagCompound.getByte(keyName);
    }

    public static byte[] getByteArray(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setByteArray(itemStack, keyName, new byte[0]);
        }
        return itemStack.stackTagCompound.getByteArray(keyName);
    }

    public static double getDouble(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setDouble(itemStack, keyName, 0.0D);
        }
        return itemStack.stackTagCompound.getDouble(keyName);
    }

    public static float getFloat(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setFloat(itemStack, keyName, 0.0F);
        }
        return itemStack.stackTagCompound.getFloat(keyName);
    }

    public static int[] getIntArray(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setIntArray(itemStack, keyName, new int[0]);
        }
        return itemStack.stackTagCompound.getIntArray(keyName);
    }

    public static int getInteger(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setInteger(itemStack, keyName, 0);
        }
        return itemStack.stackTagCompound.getInteger(keyName);
    }

    public static long getLong(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setLong(itemStack, keyName, (long) 0);
        }
        return itemStack.stackTagCompound.getLong(keyName);
    }

    public static short getShort(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setShort(itemStack, keyName, (short) 0);
        }
        return itemStack.stackTagCompound.getShort(keyName);
    }

    public static String getString(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setString(itemStack, keyName, "");
        }
        return itemStack.stackTagCompound.getString(keyName);
    }

    public static NBTTagCompound getTagCompound(ItemStack itemStack, String keyName) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setTagCompound(itemStack, keyName, new NBTTagCompound());
        }
        return itemStack.stackTagCompound.getCompoundTag(keyName);
    }

    public static NBTTagList getTagList(ItemStack itemStack, String keyName, int nbtBaseType) {
        initNBTTagCompound(itemStack);
        if (!itemStack.stackTagCompound.hasKey(keyName)) {
            setTagList(itemStack, keyName, new NBTTagList());
        }
        return itemStack.stackTagCompound.getTagList(keyName, nbtBaseType);
    }

    public static boolean hasUUID(ItemStack itemStack) {
        return hasTag(itemStack, CoreReferences.NBT.UUID_MOST_SIG) && hasTag(itemStack, CoreReferences.NBT.UUID_LEAST_SIG);
    }
}
