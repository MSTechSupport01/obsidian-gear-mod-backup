// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.obsidiangear.block;

import java.util.Collections;
import net.minecraft.util.IItemProvider;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.Property;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.loot.LootContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.SlabBlock;
import net.mcreator.obsidiangear.itemgroup.ObsidianGearItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.Block;
import net.mcreator.obsidiangear.ObsidianGearModElements.ModElement;
import net.mcreator.obsidiangear.ObsidianGearModElements;

@Tag
public class DesolateSlabBlock extends ObsidianGearModElements.ModElement
{
    @ObjectHolder("obsidian_gear:desolate_slab")
    public static final Block block;
    
    public DesolateSlabBlock(final ObsidianGearModElements instance) {
        super(instance, 67);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> new CustomBlock());
        final BlockItem blockItem;
        this.elements.items.add(() -> {
            new BlockItem(DesolateSlabBlock.block, new Item.Properties().func_200916_a(ObsidianGearItemGroup.tab));
            return (Item)blockItem.setRegistryName(DesolateSlabBlock.block.getRegistryName());
        });
    }
    
    static {
        block = null;
    }
    
    public static class CustomBlock extends SlabBlock
    {
        public CustomBlock() {
            super(AbstractBlock.Properties.func_200945_a(Material.field_151575_d).func_200947_a(SoundType.field_185848_a).func_200948_a(2.0f, 3.0f).func_235838_a_(s -> 0));
            this.setRegistryName("desolate_slab");
        }
        
        public int getFlammability(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
            return 5;
        }
        
        public List<ItemStack> func_220076_a(final BlockState state, final LootContext.Builder builder) {
            final List<ItemStack> dropsOriginal = (List<ItemStack>)super.func_220076_a(state, builder);
            if (!dropsOriginal.isEmpty()) {
                return dropsOriginal;
            }
            return Collections.singletonList(new ItemStack((IItemProvider)this, (state.func_177229_b((Property)CustomBlock.field_196505_a) == SlabType.DOUBLE) ? 2 : 1));
        }
    }
}