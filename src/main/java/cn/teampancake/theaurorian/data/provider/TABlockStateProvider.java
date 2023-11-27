package cn.teampancake.theaurorian.data.provider;

import cn.teampancake.theaurorian.AurorianMod;
import cn.teampancake.theaurorian.common.blocks.*;
import cn.teampancake.theaurorian.registry.TABlocks;
import cn.teampancake.theaurorian.utils.TACommonUtils;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
public class TABlockStateProvider extends BlockStateProvider {

    private static final ResourceLocation CUTOUT = new ResourceLocation("cutout");
    private static final ResourceLocation CUTOUT_MIPPED = new ResourceLocation("cutout_mipped");
    private static final ResourceLocation TRANSLUCENT = new ResourceLocation("translucent");
    private static final Map<Direction, Integer> DIRECTION_WITH_ROTATION =
            Map.of(Direction.NORTH, 0, Direction.EAST, 90,
            Direction.SOUTH, 180, Direction.WEST, 270);

    public TABlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AurorianMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.registerLiquidStates();
        this.registerScrapperState();
        this.registerCraftingTableState();
        this.registerAurorianPortalState();
        this.registerAurorianFurnaceState();
        this.registerAurorianFarmlandState();
        this.registerSilentWoodLadderState();
        this.simpleBlock(TABlocks.GEODE_ORE.get());
        this.simpleBlock(TABlocks.CERULEAN_ORE.get());
        this.simpleBlock(TABlocks.MOONSTONE_ORE.get());
        this.simpleBlock(TABlocks.AURORIAN_DIRT.get());
        this.simpleBlock(TABlocks.AURORIAN_STONE.get());
        this.simpleBlock(TABlocks.AURORIAN_COAL_ORE.get());
        this.simpleBlock(TABlocks.AURORIAN_STONE_BRICKS.get());
        this.simpleBlock(TABlocks.AURORIAN_COBBLESTONE.get());
        this.simpleBlock(TABlocks.AURORIAN_PORTAL_FRAME_BRICKS.get());
        this.simpleBlock(TABlocks.AURORIAN_PERIDOTITE.get());
        this.simpleBlock(TABlocks.MOON_SAND.get());
        this.simpleBlock(TABlocks.MOON_SAND_RIVER.get());
        this.simpleBlock(TABlocks.MOON_SAND_STONE_1.get());
        this.simpleBlock(TABlocks.MOON_SAND_STONE_2.get());
        this.simpleBlock(TABlocks.MOON_SAND_STONE_3.get());
        this.simpleBlock(TABlocks.RUNE_STONE.get());
        this.simpleBlock(TABlocks.SMOOTH_RUNE_STONE.get());
        this.simpleBlock(TABlocks.CHISELED_RUNE_STONE.get());
        this.simpleBlock(TABlocks.AURORIAN_CASTLE_RUNE_STONE.get());
        this.simpleBlock(TABlocks.AURORIAN_STEEL_CASTLE_RUNE_STONE.get());
        this.simpleBlock(TABlocks.CERULEAN_CASTLE_RUNE_STONE.get());
        this.simpleBlock(TABlocks.CRYSTALLINE_CASTLE_RUNE_STONE.get());
        this.simpleBlock(TABlocks.MOON_CASTLE_RUNE_STONE.get());
        this.simpleBlock(TABlocks.TRANSPARENT_RUNE_STONE.get());
        this.simpleBlock(TABlocks.UMBRA_CASTLE_RUNE_STONE.get());
        this.simpleBlock(TABlocks.RUNE_STONE_PILLAR.get());
        this.simpleBlock(TABlocks.MOON_TEMPLE_BRICKS.get());
        this.simpleBlock(TABlocks.DARK_STONE_BRICKS.get());
        this.simpleBlock(TABlocks.DARK_STONE_FANCY.get());
        this.simpleBlock(TABlocks.DARK_STONE_LAYERS.get());
        this.simpleBlock(TABlocks.SMOOTH_MOON_TEMPLE_BRICKS.get());
        this.simpleBlock(TABlocks.SMOOTH_AURORIAN_PERIDOTITE.get());
        this.simpleBlock(TABlocks.RUNE_STONE_LAMP.get());
        this.simpleBlock(TABlocks.DARK_STONE_LAMP.get());
        this.simpleBlock(TABlocks.MOON_TEMPLE_LAMP.get());
        this.simpleBlock(TABlocks.CERULEAN_BLOCK.get());
        this.simpleBlock(TABlocks.MOONSTONE_BLOCK.get());
        this.simpleBlock(TABlocks.AURORIAN_COAL_BLOCK.get());
        this.simpleBlock(TABlocks.AURORIAN_STEEL_BLOCK.get());
        this.simpleBlock(TABlocks.RUNE_STONE_GATE.get());
        this.simpleBlock(TABlocks.DARK_STONE_GATE.get());
        this.simpleBlock(TABlocks.MOON_TEMPLE_GATE.get());
        this.simpleBlock(TABlocks.RUNE_STONE_LOOT_GATE.get());
        this.simpleBlock(TABlocks.MOON_TEMPLE_CELL_GATE.get());
        this.simpleBlock(TABlocks.RUNE_STONE_GATE_KEYHOLE.get());
        this.simpleBlock(TABlocks.DARK_STONE_GATE_KEYHOLE.get());
        this.simpleBlock(TABlocks.MOON_TEMPLE_GATE_KEYHOLE.get());
        this.simpleBlock(TABlocks.RUNE_STONE_LOOT_GATE_KEYHOLE.get());
        this.simpleBlock(TABlocks.MOON_TEMPLE_CELL_GATE_KEYHOLE.get());
        this.simpleBlock(TABlocks.UMBRA_STONE.get());
        this.simpleBlock(TABlocks.UMBRA_STONE_CRACKED.get());
        this.simpleBlock(TABlocks.UMBRA_STONE_ROOF_TILES.get());
        this.simpleBlock(TABlocks.INDIGO_MUSHROOM_CRYSTAL.get());
        this.simpleBlock(TABlocks.SILENT_TREE_PLANKS.get());
        this.simpleBlock(TABlocks.WEEPING_WILLOW_PLANKS.get());
        this.simpleBlock(TABlocks.SILENT_WOOD_TORCH.get(),
                this.models().torch(this.name(TABlocks.SILENT_WOOD_TORCH.get()),
                        this.blockTexture(TABlocks.SILENT_WOOD_TORCH.get())));
        this.simpleBlock(TABlocks.MOON_TORCH.get(),
                this.models().torch(this.name(TABlocks.MOON_TORCH.get()),
                        this.blockTexture(TABlocks.MOON_TORCH.get())));
        this.logBlock((RotatedPillarBlock) TABlocks.SILENT_TREE_LOG.get());
        this.logBlock((RotatedPillarBlock) TABlocks.WEEPING_WILLOW_LOG.get());
        this.simpleBlock(TABlocks.SILENT_TREE_SAPLING.get(),
                this.models().cross(this.name(TABlocks.SILENT_TREE_SAPLING.get()),
                        this.blockTexture(TABlocks.SILENT_TREE_SAPLING.get())).renderType(CUTOUT));
        this.axisBlock((RotatedPillarBlock) TABlocks.SILENT_TREE_WOOD.get(),
                this.modLoc("block/silent_tree_log"),
                this.modLoc("block/silent_tree_log"));
        this.axisBlock((RotatedPillarBlock) TABlocks.WEEPING_WILLOW_WOOD.get(),
                this.modLoc("block/weeping_willow_log"),
                this.modLoc("block/weeping_willow_log"));
        this.simpleBlock(TABlocks.AURORIAN_GRASS_BLOCK.get(),
                this.models().cubeBottomTop("aurorian_grass_block",
                        this.modLoc("block/aurorian_grass_block"),
                        this.modLoc("block/aurorian_dirt"),
                        this.modLoc("block/aurorian_grass_block_top")));
        this.simpleBlock(TABlocks.AURORIAN_GRASS_LIGHT_BLOCK.get(),
                this.models().cubeBottomTop("aurorian_grass_light_block",
                        this.modLoc("block/aurorian_grass_light_block"),
                        this.modLoc("block/aurorian_dirt"),
                        this.modLoc("block/aurorian_grass_light_block_top")));
        this.simpleBlockWithRenderType(TABlocks.MOON_GLASS.get(), TRANSLUCENT);
        this.simpleBlockWithRenderType(TABlocks.AURORIAN_GLASS.get(), TRANSLUCENT);
        this.simpleBlockWithRenderType(TABlocks.SILENT_TREE_LEAVES.get(), CUTOUT_MIPPED);
        this.simpleBlockWithRenderType(TABlocks.WEEPING_WILLOW_LEAVES.get(), CUTOUT_MIPPED);
        this.registerBarStates(TABlocks.RUNE_STONE_BARS.get());
        this.registerBarStates(TABlocks.MOON_TEMPLE_BARS.get());
        this.registerGlassPaneStates(TABlocks.MOON_GLASS_PANE.get());
        this.registerGlassPaneStates(TABlocks.AURORIAN_GLASS_PANE.get());
        this.registerWallTorchStates(TABlocks.MOON_WALL_TORCH.get());
        this.registerWallTorchStates(TABlocks.SILENT_WOOD_WALL_TORCH.get());
        this.registerCropStates(TABlocks.LAVENDER_CROP.get());
        this.registerCropStates(TABlocks.SILK_BERRY_CROP.get());
        this.registerPlantStates(TABlocks.AURORIAN_FLOWER_1.get());
        this.registerPlantStates(TABlocks.AURORIAN_FLOWER_2.get());
        this.registerPlantStates(TABlocks.AURORIAN_FLOWER_3.get());
        this.registerPlantStates(TABlocks.AURORIAN_FLOWER_4.get());
        this.registerPlantStates(TABlocks.LAVENDER_PLANT.get());
        this.registerPlantStates(TABlocks.PETUNIA_PLANT.get());
        this.registerPlantStates(TABlocks.INDIGO_MUSHROOM.get());
        this.registerPlantStates(TABlocks.AURORIAN_GRASS.get());
        this.registerPlantStates(TABlocks.AURORIAN_GRASS_LIGHT.get());
        this.registerMushroomStates(TABlocks.INDIGO_MUSHROOM_BLOCK.get());
        this.registerMushroomStates(TABlocks.INDIGO_MUSHROOM_STEM.get());
        for (Block block : TACommonUtils.getKnownBlocks()) {
            if (block instanceof StairBlock stairBlock) {
                this.stairsBlock(stairBlock, this.blockTexture(stairBlock.base));
            } else if (block instanceof SlabBlockWithBase slabBlock) {
                ResourceLocation texture = this.blockTexture(slabBlock.getBase());
                this.slabBlock(slabBlock, texture, texture);
            } else if (block instanceof WallBlockWithBase wallBlock) {
                ResourceLocation texture = this.blockTexture(wallBlock.getBase());
                this.wallBlock(wallBlock, this.blockTexture(wallBlock.getBase()));
                this.simpleBlockItem(wallBlock, this.models().wallInventory(this.name(wallBlock), texture));
            } else if (block instanceof FlowerPotBlock flowerPotBlock) {
                this.pottedPlants(flowerPotBlock, flowerPotBlock.getContent());
            }
        }
    }

    private void registerBarStates(Block block) {
        String name = this.name(block);
        ResourceLocation texture = this.blockTexture(block);
        ModelFile post = this.models().getBuilder(name + "_post").renderType(CUTOUT_MIPPED)
                .texture("particle", texture).texture("bars", texture).ao(false)
                .element().from(8.0F, 0.0F, 7.0F).to(8.0F, 16.0F, 9.0F)
                .face(Direction.WEST).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#bars").end()
                .face(Direction.EAST).uvs(9.0F, 0.0F, 7.0F, 16.0F).texture("#bars").end().end()
                .element().from(7.0F, 0.0F, 8.0F).to(9.0F, 16.0F, 8.0F)
                .face(Direction.NORTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#bars").end()
                .face(Direction.SOUTH).uvs(9.0F, 0.0F, 7.0F, 16.0F).texture("#bars").end().end();
        ModelFile postEnds = this.models().getBuilder(name + "_post_ends").renderType(CUTOUT_MIPPED)
                .texture("particle", texture).texture("edge", texture).ao(false)
                .element().from(7.0F, 0.001F, 7.0F).to(9.0F, 0.001F, 9.0F)
                .face(Direction.DOWN).uvs(7.0F, 7.0F, 9.0F, 9.0F).texture("#edge").end()
                .face(Direction.UP).uvs(7.0F, 7.0F, 9.0F, 9.0F).texture("#edge").end().end()
                .element().from(7.0F, 15.999F, 7.0F).to(9.0F, 15.999F, 9.0F)
                .face(Direction.DOWN).uvs(7.0F, 7.0F, 9.0F, 9.0F).texture("#edge").end()
                .face(Direction.UP).uvs(7.0F, 7.0F, 9.0F, 9.0F).texture("#edge").end().end();
        ModelFile cap = this.models().getBuilder(name + "_cap")
                .renderType(CUTOUT_MIPPED).texture("particle", texture)
                .texture("edge", texture).texture("bars", texture).ao(false)
                .element().from(8.0F, 0.0F, 8.0F).to(8.0F, 16.0F, 9.0F)
                .face(Direction.WEST).uvs(8.0F, 0.0F, 7.0F, 16.0F).texture("#bars").end()
                .face(Direction.EAST).uvs(7.0F, 0.0F, 8.0F, 16.0F).texture("#bars").end().end()
                .element().from(7.0F, 0.0F, 9.0F).to(9.0F, 16.0F, 9.0F)
                .face(Direction.NORTH).uvs(9.0F, 0.0F, 7.0F, 16.0F).texture("#bars").end()
                .face(Direction.SOUTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#bars").end().end();
        ModelFile capAlt = this.models().getBuilder(name + "_cap_alt")
                .renderType(CUTOUT_MIPPED).texture("particle", texture)
                .texture("edge", texture).texture("bars", texture).ao(false)
                .element().from(8.0F, 0.0F, 7.0F).to(8.0F, 16.0F, 7.0F)
                .face(Direction.WEST).uvs(8.0F, 0.0F, 9.0F, 16.0F).texture("#bars").end()
                .face(Direction.EAST).uvs(9.0F, 0.0F, 8.0F, 16.0F).texture("#bars").end().end()
                .element().from(7.0F, 0.0F, 7.0F).to(9.0F, 16.0F, 7.0F)
                .face(Direction.NORTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#bars").end()
                .face(Direction.SOUTH).uvs(9.0F, 0.0F, 7.0F, 16.0F).texture("#bars").end().end();
        ModelFile side = this.models().getBuilder(name + "_side").renderType(CUTOUT_MIPPED)
                .texture("particle", texture).texture("edge", texture).ao(false)
                .element().from(8.0F, 0.0F, 0.0F).to(8.0F, 16.0F, 8.0F)
                .face(Direction.WEST).uvs(16.0F, 0.0F,  8.0F, 16.0F).texture("#edge").end()
                .face(Direction.EAST).uvs(8.0F, 0.0F, 16.0F, 16.0F).texture("#edge").end().end()
                .element().from(7.0F, 0.0F, 0.0F).to(9.0F, 16.0F, 7.0F)
                .face(Direction.NORTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#edge").cullface(Direction.NORTH).end().end()
                .element().from(7.0F, 0.001F, 0.0F).to(9.0F, 0.001F, 7.0F)
                .face(Direction.DOWN).uvs(9.0F, 0.0F, 7.0F, 7.0F).texture("#edge").end()
                .face(Direction.UP).uvs(7.0F, 0.0F, 9.0F, 7.0F).texture("#edge").end().end()
                .element().from(7.0F, 15.999F, 0.0F).to(9.0F, 15.999F, 7.0F)
                .face(Direction.DOWN).uvs(9.0F, 0.0F, 7.0F, 7.0F).texture("#edge").end()
                .face(Direction.UP).uvs(7.0F, 0.0F, 9.0F, 7.0F).texture("#edge").end().end();
        ModelFile sideAlt = this.models().getBuilder(name + "_side_alt").renderType(CUTOUT_MIPPED)
                .texture("particle", texture).texture("edge", texture).ao(false)
                .element().from(8.0F, 0.0F, 8.0F).to(8.0F, 16.0F, 16.0F)
                .face(Direction.WEST).uvs(8.0F, 0.0F,  0.0F, 16.0F).texture("#edge").end()
                .face(Direction.EAST).uvs(0.0F, 0.0F, 8.0F, 16.0F).texture("#edge").end().end()
                .element().from(7.0F, 0.0F, 9.0F).to(9.0F, 16.0F, 16.0F)
                .face(Direction.SOUTH).uvs(7.0F, 0.0F, 9.0F, 16.0F).texture("#edge").cullface(Direction.SOUTH).end()
                .face(Direction.DOWN).uvs(9.0F, 9.0F, 7.0F, 16.0F).texture("#edge").end()
                .face(Direction.UP).uvs(7.0F, 9.0F, 9.0F, 16.0F).texture("#edge").end().end()
                .element().from(7.0F, 0.001F, 9.0F).to(9.0F, 0.001F, 16.0F)
                .face(Direction.DOWN).uvs(9.0F, 9.0F, 7.0F, 16.0F).texture("#edge").end()
                .face(Direction.UP).uvs(7.0F, 9.0F, 9.0F, 16.0F).texture("#edge").end().end()
                .element().from(7.0F, 15.999F, 9.0F).to(9.0F, 15.999F, 16.0F)
                .face(Direction.DOWN).uvs(9.0F, 9.0F, 7.0F, 16.0F).texture("#edge").end()
                .face(Direction.UP).uvs(7.0F, 9.0F, 9.0F, 16.0F).texture("#edge").end().end();
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block).part().modelFile(postEnds).addModel().end();
        MultiPartBlockStateBuilder.PartBuilder partBuilder = builder.part().modelFile(post).addModel();
        Map<Direction, BooleanProperty> fourWayProperty = new HashMap<>(Map.copyOf(PipeBlock.PROPERTY_BY_DIRECTION));
        fourWayProperty.entrySet().removeIf(direction -> direction.getKey().getAxis().isVertical());
        fourWayProperty.forEach((key, value) -> partBuilder.condition(value, false));
        builder.part().modelFile(cap).rotationY(90).addModel().condition(PipeBlock.EAST, true).condition(PipeBlock.NORTH, false)
                .condition(PipeBlock.SOUTH, false).condition(PipeBlock.WEST, false).end();
        builder.part().modelFile(cap).addModel().condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, true)
                .condition(PipeBlock.SOUTH, false).condition(PipeBlock.WEST, false).end();
        builder.part().modelFile(capAlt).rotationY(90).addModel().condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false)
                .condition(PipeBlock.SOUTH, true).condition(PipeBlock.WEST, false).end();
        builder.part().modelFile(capAlt).addModel().condition(PipeBlock.EAST, false).condition(PipeBlock.NORTH, false)
                .condition(PipeBlock.SOUTH, false).condition(PipeBlock.WEST, true).end();
        builder.part().modelFile(side).addModel().condition(PipeBlock.NORTH, true).end();
        builder.part().modelFile(side).rotationY(90).addModel().condition(PipeBlock.EAST, true).end();
        builder.part().modelFile(sideAlt).addModel().condition(PipeBlock.SOUTH, true).end();
        builder.part().modelFile(sideAlt).rotationY(90).addModel().condition(PipeBlock.WEST, true).end();
    }

    private void registerGlassPaneStates(Block block) {
        String name = this.name(block);
        String side = name + "_side", sideAlt = name + "_side_alt";
        String noSide = name + "_noside", noSideAlt = name + "_noside_alt";
        ResourceLocation edge = this.modLoc("block/" + name);
        ResourceLocation pane =  this.modLoc("block/" + name.replaceAll("_pane", ""));
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block).part().modelFile(
                this.models().panePost(name + "_post", pane, edge).renderType(TRANSLUCENT)).addModel().end();
        builder.part().modelFile(this.models().paneSide(side, pane, edge).renderType(TRANSLUCENT))
                .addModel().condition(IronBarsBlock.NORTH, true).end();
        builder.part().modelFile(this.models().paneSide(side, pane, edge).renderType(TRANSLUCENT))
                .rotationY(90).addModel().condition(IronBarsBlock.WEST, true).end();
        builder.part().modelFile(this.models().paneSideAlt(sideAlt, pane, edge).renderType(TRANSLUCENT))
                .addModel().condition(IronBarsBlock.SOUTH, true).end();
        builder.part().modelFile(this.models().paneSideAlt(sideAlt, pane, edge).renderType(TRANSLUCENT))
                .rotationY(90).addModel().condition(IronBarsBlock.WEST, true).end();
        builder.part().modelFile(this.models().paneNoSide(noSide, pane).renderType(TRANSLUCENT))
                .addModel().condition(IronBarsBlock.NORTH, false).end();
        builder.part().modelFile(this.models().paneNoSide(noSide, pane).renderType(TRANSLUCENT))
                .rotationY(270).addModel().condition(IronBarsBlock.WEST, false).end();
        builder.part().modelFile(this.models().paneNoSideAlt(noSideAlt, pane).renderType(TRANSLUCENT))
                .addModel().condition(IronBarsBlock.EAST, false).end();
        builder.part().modelFile(this.models().paneNoSideAlt(noSideAlt, pane).renderType(TRANSLUCENT))
                .rotationY(270).addModel().condition(IronBarsBlock.WEST, false).end();
    }

    private void registerWallTorchStates(Block block) {
        Map<Direction, Integer> map = Map.of(Direction.NORTH, 270, Direction.EAST, 0,
                Direction.SOUTH, 90, Direction.WEST, 180);
        VariantBlockStateBuilder builder = this.getVariantBuilder(block);
        for (Direction direction : WallTorchBlock.FACING.getPossibleValues()) {
            builder.partialState().with(WallTorchBlock.FACING, direction).modelForState()
                    .modelFile(this.models().torchWall(this.name(block),
                            this.blockTexture(TABlocks.SILENT_WOOD_TORCH.get())))
                    .rotationY(map.get(direction)).addModel();
        }
    }

    private void registerCropStates(Block block) {
        VariantBlockStateBuilder builder = this.getVariantBuilder(block);
        for (int stage : TACropBlock.AGE.getPossibleValues()) {
            String name = this.name(block) + "_stage" + stage;
            ResourceLocation texture = this.modLoc("block/" + name);
            ModelFile modelFile = this.models().crop(name, texture);
            builder.partialState().with(TACropBlock.AGE, stage)
                    .modelForState().modelFile(modelFile).addModel();
        }
    }

    private void pottedPlants(Block block, Block content) {
        this.simpleBlock(block, this.models().withExistingParent(this.name(block), "block/flower_pot_cross")
                .renderType(CUTOUT).texture("plant", this.blockTexture(content)));
    }

    private void registerPlantStates(Block block) {
        this.simpleBlock(block, this.models().cross(this.name(block), this.blockTexture(block)).renderType(CUTOUT));
    }

    private void registerMushroomStates(Block block) {
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block);
        ResourceLocation parent = this.mcLoc("block/template_single_face");
        ResourceLocation outside = this.modLoc("block/" + this.name(block) + "_side");
        ResourceLocation inside = this.modLoc("block/" + this.name(block) + "_inside");
        ModelFile outsideModel = this.models().singleTexture(this.name(block), parent, outside).renderType(TRANSLUCENT);
        ModelFile insideModel = this.models().singleTexture(this.name(block), parent, inside).renderType(TRANSLUCENT);
        Map<Integer, Integer> map = Map.of((0), (90), (1), (270), (2), (0), (3), (180), (4), (270), (5), (90));
        Map<Direction, BooleanProperty> properties = PipeBlock.PROPERTY_BY_DIRECTION;
        for (Direction direction : Direction.values()) {
            boolean flag = direction == Direction.NORTH;
            int yRot = map.get(direction.get3DDataValue());
            BooleanProperty property = properties.get(direction);
            builder.part().modelFile(outsideModel).uvLock(!flag).rotationY(yRot)
                    .addModel().condition(property, Boolean.TRUE).end();
            builder.part().modelFile(insideModel).uvLock(Boolean.FALSE).rotationY(yRot)
                    .addModel().condition(property, Boolean.FALSE).end();
        }
    }

    private void registerLiquidStates() {
        this.simpleBlock(TABlocks.MOLTEN_AURORIAN_STEEL.get(), this.models()
                .getBuilder(TABlocks.MOLTEN_AURORIAN_STEEL.getId().getPath())
                .texture("particle", this.modLoc("block/molten_aurorian_steel")));
        this.simpleBlock(TABlocks.MOLTEN_CERULEAN.get(), this.models()
                .getBuilder(TABlocks.MOLTEN_CERULEAN.getId().getPath())
                .texture("particle", this.modLoc("block/molten_cerulean")));
        this.simpleBlock(TABlocks.MOLTEN_MOONSTONE.get(), this.models()
                .getBuilder(TABlocks.MOLTEN_MOONSTONE.getId().getPath())
                .texture("particle", this.modLoc("block/molten_moonstone")));
    }

    private void registerScrapperState() {
        Block block = TABlocks.SCRAPPER.get();
        VariantBlockStateBuilder builder = this.getVariantBuilder(block);
        ModelFile modelFile = this.models().withExistingParent(this.name(block), this.mcLoc("block/cube"))
                .texture("particle", this.modLoc("block/scrapper_front"))
                .texture("down", this.modLoc("block/aurorian_furnace_on"))
                .texture("up", this.modLoc("block/scrapper_top"))
                .texture("north", this.modLoc("block/scrapper_front"))
                .texture("east", this.modLoc("block/scrapper_side"))
                .texture("south", this.modLoc("block/scrapper_side"))
                .texture("west", this.modLoc("block/scrapper_side"));
        for (Direction direction : DIRECTION_WITH_ROTATION.keySet()) {
            int y = DIRECTION_WITH_ROTATION.get(direction);
            builder.partialState().with(Scrapper.FACING, direction).modelForState()
                    .modelFile(modelFile).rotationY(y).addModel();
        }
    }

    private void registerCraftingTableState() {
        String name = this.name(TABlocks.SILENT_WOOD_CRAFTING_TABLE.get());
        ResourceLocation down = this.modLoc("block/" +
                this.name(TABlocks.SILENT_TREE_PLANKS.get()));
        ResourceLocation front = this.modLoc("block/" + name + "_front");
        ResourceLocation side = this.modLoc("block/" + name + "_side");
        ResourceLocation top = this.modLoc("block/" + name + "_top");
        ModelFile modelFile = this.models().cube(name, down, top, front, side, side, front);
        this.simpleBlock(TABlocks.SILENT_WOOD_CRAFTING_TABLE.get(), modelFile);
    }

    private void registerAurorianPortalState() {
        Block block = TABlocks.AURORIAN_PORTAL.get();
        VariantBlockStateBuilder builder = this.getVariantBuilder(block);
        for (Direction.Axis axis : AurorianPortal.AXIS.getPossibleValues()) {
            boolean flag = axis == Direction.Axis.X;
            float x = flag ? 0.0F : 6.0F, z = flag ? 6.0F : 0.0F;
            String name = this.name(block) + (flag ? "_ns" : "_ew");
            ConfiguredModel.Builder<VariantBlockStateBuilder> builder1 = builder.partialState().with(AurorianPortal.AXIS, axis).modelForState();
            ModelBuilder<BlockModelBuilder>.ElementBuilder elementBuilder = this.models().getBuilder(name)
                    .texture("particle", this.blockTexture(block)).texture("portal", this.blockTexture(block))
                    .element().from(x, 0.0F, z).to(10.0F + z, 16.0F, 10.0F + x);
            if (axis == Direction.Axis.X) {
                builder1.modelFile(elementBuilder.face(Direction.NORTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#portal").end()
                        .face(Direction.SOUTH).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#portal").end().end()).addModel();
            } else if (axis == Direction.Axis.Z) {
                builder1.modelFile(elementBuilder.face(Direction.EAST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#portal").end()
                        .face(Direction.WEST).uvs(0.0F, 0.0F, 16.0F, 16.0F).texture("#portal").end().end()).addModel();
            }
        }
    }

    private void registerAurorianFurnaceState() {
        String name = this.name(TABlocks.AURORIAN_FURNACE.get());
        VariantBlockStateBuilder builder = this.getVariantBuilder(TABlocks.AURORIAN_FURNACE.get());
        for (Direction direction : AurorianFurnace.FACING.getPossibleValues()) {
            for (Boolean lit : AurorianFurnace.LIT.getPossibleValues()) {
                String front = name + (lit ? "_on" : "");
                ModelFile modelFile = new ConfiguredModel(this.models()
                        .orientable(front, this.modLoc("block/" + name + "_side"),
                                this.modLoc("block/" + front),
                                this.modLoc("block/" + name + "_top"))).model;
                builder.partialState().with(AurorianFurnace.FACING, direction)
                        .with(AurorianFurnace.LIT, lit).modelForState().modelFile(modelFile)
                        .rotationY(DIRECTION_WITH_ROTATION.get(direction)).addModel();
            }
        }
    }

    private void registerAurorianFarmlandState() {
        VariantBlockStateBuilder builder = this.getVariantBuilder(TABlocks.AURORIAN_FARM_TILE.get());
        for (int i = 0; i <= AurorianFarmTile.MAX_MOISTURE; i++) {
            String name = "aurorian_farm_tile" + (i == AurorianFarmTile.MAX_MOISTURE ? "_moist" : "");
            ConfiguredModel configuredModel = new ConfiguredModel(this.models()
                    .withExistingParent(name, this.mcLoc("block/template_farmland"))
                    .texture("dirt", this.modLoc("block/aurorian_dirt"))
                    .texture("top", this.modLoc("block/" + name)));
            builder.partialState().with(AurorianFarmTile.MOISTURE, i).addModels(configuredModel);
        }
    }

    private void registerSilentWoodLadderState() {
        String name = this.name(TABlocks.SILENT_WOOD_LADDER.get());
        VariantBlockStateBuilder builder = this.getVariantBuilder(TABlocks.SILENT_WOOD_LADDER.get());
        ConfiguredModel configuredModel = new ConfiguredModel(this.models()
                .withExistingParent(name, this.modLoc("block/" + name))
                .texture("particle", this.modLoc("block/" + name))
                .texture("texture", this.modLoc("block/" + name)));
        for (Direction direction : LadderBlock.FACING.getPossibleValues()) {
            builder.partialState().with(LadderBlock.FACING, direction).modelForState()
                    .modelFile(configuredModel.model).rotationY(DIRECTION_WITH_ROTATION.get(direction)).addModel();
        }
    }

    private String name(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }

    private void simpleBlockWithRenderType(Block block, ResourceLocation type) {
        simpleBlock(block, models().cubeAll(this.name(block), this.blockTexture(block)).renderType(type));
    }

}