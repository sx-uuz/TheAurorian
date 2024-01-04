package cn.teampancake.theaurorian.common.data.datagen.provider.lang;

import cn.teampancake.theaurorian.AurorianMod;
import cn.teampancake.theaurorian.common.registry.*;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public class TALanguageProviderZHCN extends LanguageProvider {

    public TALanguageProviderZHCN(PackOutput output) {
        super(output, AurorianMod.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup." + AurorianMod.MOD_ID, "极光幽境");
        this.add("theaurorian.container.scrapper", "粉碎器");
        this.add("theaurorian.container.moonlight_forge", "月光融锻台");

        //MOD BLOCK
        this.add(TABlocks.AURORIAN_DIRT.get(), "极光泥土");
        this.add(TABlocks.AURORIAN_STONE.get(), "极光石");
        this.add(TABlocks.AURORIAN_STONE_BRICKS.get(), "极光石砖");
        this.add(TABlocks.AURORIAN_COBBLESTONE.get(), "极光圆石");
        this.add(TABlocks.AURORIAN_COAL_ORE.get(), "极光煤矿石");
        this.add(TABlocks.AURORIAN_GRASS_BLOCK.get(), "极光草方块");
        this.add(TABlocks.LIGHT_AURORIAN_GRASS_BLOCK.get(), "发光极光草方块");
        this.add(TABlocks.RED_AURORIAN_GRASS_BLOCK.get(), "红色极光草方块");
        this.add(TABlocks.AURORIAN_FARM_TILE.get(), "极光农砖");
        this.add(TABlocks.MOON_GLASS.get(), "皎月玻璃");
        this.add(TABlocks.AURORIAN_GLASS.get(), "极光玻璃");
        this.add(TABlocks.DARK_STONE_GLASS.get(), "暗石玻璃");
        this.add(TABlocks.MOON_GLASS_PANE.get(), "皎月玻璃板");
        this.add(TABlocks.AURORIAN_GLASS_PANE.get(), "极光玻璃板");
        this.add(TABlocks.DARK_STONE_GLASS_PANE.get(), "暗石玻璃板");
        this.add(TABlocks.AURORIAN_GRASS.get(), "极光草");
        this.add(TABlocks.AURORIAN_GRASS_LIGHT.get(), "发光极光草");
        this.add(TABlocks.AURORIAN_WATER_GRASS.get(), "极光水草");
        this.add(TABlocks.AURORIAN_LILY_PAD.get(), "极光睡莲");
        this.add(TABlocks.AURORIAN_WATER_MUSHROOM.get(), "极光水菇");
        this.add(TABlocks.AURORIAN_FURNACE.get(), "极光熔炉");
        this.add(TABlocks.AURORIAN_FURNACE_CHIMNEY.get(), "极光熔炉孔道");
        this.add(TABlocks.AURORIAN_PORTAL.get(), "极光传送门");
        this.add(TABlocks.AURORIAN_PORTAL_FRAME_BRICKS.get(), "极光传送门框架");
        this.add(TABlocks.URN.get(), "瓮");
        this.add(TABlocks.AURORIAN_FLOWER_1.get(), "极光花");
        this.add(TABlocks.AURORIAN_FLOWER_2.get(), "极光花");
        this.add(TABlocks.AURORIAN_FLOWER_3.get(), "极光花");
        this.add(TABlocks.EQUINOX_FLOWER.get(), "彼岸花");
        this.add(TABlocks.LAVENDER_PLANT.get(), "薰衣草");
        this.add(TABlocks.PETUNIA_PLANT.get(), "牵牛花");
        this.add(TABlocks.TALL_AURORIAN_GRASS.get(), "高薰衣草");
        this.add(TABlocks.TALL_LAVENDER_PLANT.get(), "高极光草");
        this.add(TABlocks.TALL_AURORIAN_WATER_GRASS.get(), "高极光水草");
        this.add(TABlocks.AURORIAN_PERIDOTITE.get(), "极光橄榄岩");
        this.add(TABlocks.SMOOTH_AURORIAN_PERIDOTITE.get(), "平滑极光橄榄岩");
        this.add(TABlocks.MOONSTONE_ORE.get(), "皎月石矿石");
        this.add(TABlocks.CERULEAN_ORE.get(), "晶蓝矿石");
        this.add(TABlocks.GEODE_ORE.get(), "晶簇矿石");
        this.add(TABlocks.RUNE_STONE.get(), "符石");
        this.add(TABlocks.SMOOTH_RUNE_STONE.get(), "平滑符石");
        this.add(TABlocks.CHISELED_RUNE_STONE.get(), "雕纹符石");
        this.add(TABlocks.AURORIAN_CASTLE_RUNE_STONE.get(), "极光符文符石");
        this.add(TABlocks.AURORIAN_STEEL_CASTLE_RUNE_STONE.get(), "极光钢符文符石");
        this.add(TABlocks.CERULEAN_CASTLE_RUNE_STONE.get(), "晶蓝符文符石");
        this.add(TABlocks.CRYSTALLINE_CASTLE_RUNE_STONE.get(), "月凝晶符文符石");
        this.add(TABlocks.MOON_CASTLE_RUNE_STONE.get(), "皎月符文符石");
        this.add(TABlocks.TRANSPARENT_RUNE_STONE.get(), "透明符石");
        this.add(TABlocks.UMBRA_CASTLE_RUNE_STONE.get(), "本影符文符石");
        this.add(TABlocks.LUMINOUS_AURORIAN_CASTLE_RUNE_STONE.get(), "发光极光符文符石");
        this.add(TABlocks.LUMINOUS_AURORIAN_STEEL_CASTLE_RUNE_STONE.get(), "发光极光钢符文符石");
        this.add(TABlocks.LUMINOUS_CERULEAN_CASTLE_RUNE_STONE.get(), "发光晶蓝符文符石");
        this.add(TABlocks.LUMINOUS_CRYSTALLINE_CASTLE_RUNE_STONE.get(), "发光月凝晶符文符石");
        this.add(TABlocks.LUMINOUS_MOON_CASTLE_RUNE_STONE.get(), "发光皎月符文符石");
        this.add(TABlocks.RUNE_STONE_PILLAR.get(), "符石柱");
        this.add(TABlocks.DARK_STONE_PILLAR.get(), "暗石柱");
        this.add(TABlocks.MOON_TEMPLE_PILLAR.get(), "月宫柱");
        this.add(TABlocks.MOON_TEMPLE_BRICKS.get(), "月宫砖块");
        this.add(TABlocks.DARK_STONE_BRICKS.get(), "暗石砖块");
        this.add(TABlocks.DARK_STONE_FANCY.get(), "装饰性暗石");
        this.add(TABlocks.DARK_STONE_LAYERS.get(), "暗石地层");
        this.add(TABlocks.SMOOTH_DARK_STONE_BRICKS.get(), "平滑暗石");
        this.add(TABlocks.CHISELED_DARK_STONE_BRICKS.get(), "雕纹暗石");
        this.add(TABlocks.SMOOTH_MOON_TEMPLE_BRICKS.get(), "平滑月宫砖块");
        this.add(TABlocks.CHISELED_MOON_TEMPLE_BRICKS.get(), "雕纹月宫砖块");
        this.add(TABlocks.RUNE_STONE_LAMP.get(), "符石灯");
        this.add(TABlocks.DARK_STONE_LAMP.get(), "暗石灯");
        this.add(TABlocks.MOON_TEMPLE_LAMP.get(), "月宫灯");
        this.add(TABlocks.VOID_STONE.get(), "虚空石");
        this.add(TABlocks.RUNE_CRYSTAL.get(), "符石水晶");
        this.add(TABlocks.CERULEAN_BLOCK.get(), "晶蓝块");
        this.add(TABlocks.MOONSTONE_BLOCK.get(), "皎月石块");
        this.add(TABlocks.AURORIAN_COAL_BLOCK.get(), "极光煤块");
        this.add(TABlocks.AURORIAN_STEEL_BLOCK.get(), "极光钢块");
        this.add(TABlocks.CERULEAN_CLUSTER.get(), "晶蓝簇");
        this.add(TABlocks.LARGE_CERULEAN_BUD.get(), "大型晶蓝芽");
        this.add(TABlocks.MEDIUM_CERULEAN_BUD.get(), "中型晶蓝芽");
        this.add(TABlocks.SMALL_CERULEAN_BUD.get(), "小型晶蓝芽");
        this.add(TABlocks.MOONSTONE_CLUSTER.get(), "皎月石簇");
        this.add(TABlocks.LARGE_MOONSTONE_BUD.get(), "大型皎月石芽");
        this.add(TABlocks.MEDIUM_MOONSTONE_BUD.get(), "中型皎月石芽");
        this.add(TABlocks.SMALL_MOONSTONE_BUD.get(), "小型皎月石芽");
        this.add(TABlocks.MYSTICAL_BARRIER.get(), "神秘屏障");
        this.add(TABlocks.RUNE_STONE_BARS.get(), "符石栏杆");
        this.add(TABlocks.DARK_STOME_BARS.get(), "暗石栏杆");
        this.add(TABlocks.MOON_TEMPLE_BARS.get(), "月宫栏杆");
        this.add(TABlocks.RUNE_STONE_GATE.get(), "符石门");
        this.add(TABlocks.DARK_STONE_GATE.get(), "暗石门");
        this.add(TABlocks.MOON_TEMPLE_GATE.get(), "月宫门");
        this.add(TABlocks.RUNE_STONE_LOOT_GATE.get(), "符石宝藏室门");
        this.add(TABlocks.MOON_TEMPLE_CELL_GATE.get(), "月宫内室门");
        this.add(TABlocks.RUNE_STONE_GATE_KEYHOLE.get(), "符石门锁孔");
        this.add(TABlocks.DARK_STONE_GATE_KEYHOLE.get(), "暗石门锁孔");
        this.add(TABlocks.MOON_TEMPLE_GATE_KEYHOLE.get(), "月宫门锁孔");
        this.add(TABlocks.RUNE_STONE_LOOT_GATE_KEYHOLE.get(), "符石宝藏室门锁孔");
        this.add(TABlocks.MOON_TEMPLE_CELL_GATE_KEYHOLE.get(), "月宫内室门锁孔");
        this.add(TABlocks.INDIGO_MUSHROOM.get(), "深蓝蘑菇");
        this.add(TABlocks.INDIGO_MUSHROOM_BLOCK.get(), "深蓝蘑菇块");
        this.add(TABlocks.INDIGO_MUSHROOM_STEM.get(), "深蓝蘑菇茎");
        this.add(TABlocks.INDIGO_MUSHROOM_CRYSTAL.get(), "深蓝蘑菇水晶");
        this.add(TABlocks.MOONLIGHT_FORGE.get(), "月光融锻台");
        this.add(TABlocks.MOON_GEM.get(), "皎月宝石");
        this.add(TABlocks.MOON_SAND.get(), "皎月沙");
        this.add(TABlocks.MOON_SAND_RIVER.get(), "皎月河沙");
        this.add(TABlocks.MOON_SAND_STONE_1.get(), "皎月砂岩");
        this.add(TABlocks.MOON_SAND_STONE_2.get(), "皎月砂岩");
        this.add(TABlocks.MOON_SAND_STONE_3.get(), "皎月砂岩");
        this.add(TABlocks.BRIGHT_MOON_SAND.get(), "皓月沙");
        this.add(TABlocks.BRIGHT_MOON_SANDSTONE.get(), "皓月沙岩");
        this.add(TABlocks.MOON_TORCH.get(), "皎月火把");
        this.add(TABlocks.SCRAPPER.get(), "粉碎器");
        this.add(TABlocks.UMBRA_STONE.get(), "本影石");
        this.add(TABlocks.UMBRA_STONE_CRACKED.get(), "裂纹本影石");
        this.add(TABlocks.UMBRA_STONE_ROOF_TILES.get(), "本影石瓦");
        this.add(TABlocks.SILENT_BUSH_LEAVES.get(), "静谧灌木树叶");
        this.add(TABlocks.SILENT_TREE_LEAVES.get(), "谧树树叶");
        this.add(TABlocks.SILENT_TREE_LOG.get(), "谧树原木");
        this.add(TABlocks.SILENT_TREE_PLANKS.get(), "谧树木板");
        this.add(TABlocks.SILENT_TREE_WOOD.get(), "谧树木头");
        this.add(TABlocks.SILENT_TREE_SAPLING.get(), "谧树树苗");
        this.add(TABlocks.SILENT_WOOD_TORCH.get(), "谧木火把");
        this.add(TABlocks.SILENT_WOOD_LADDER.get(), "谧木梯子");
        this.add(TABlocks.SILENT_WOOD_CRAFTING_TABLE.get(), "谧木工作台");
        this.add(TABlocks.WEEPING_WILLOW_LEAVES.get(), "垂柳树叶");
        this.add(TABlocks.WEEPING_WILLOW_LOG.get(), "垂柳原木");
        this.add(TABlocks.WEEPING_WILLOW_PLANKS.get(), "垂柳木板");
        this.add(TABlocks.WEEPING_WILLOW_WOOD.get(), "垂柳木头");
        this.add(TABlocks.SILENT_WOOD_PRESSURE_PLATE.get(), "谧木压力板");
        this.add(TABlocks.WEEPING_WILLOW_PRESSURE_PLATE.get(), "垂柳木压力板");
        this.add(TABlocks.SILENT_WOOD_FENCE_GATE.get(), "谧木栅栏门");
        this.add(TABlocks.WEEPING_WILLOW_FENCE_GATE.get(), "垂柳木栅栏门");
        this.add(TABlocks.SILENT_WOOD_TRAPDOOR.get(), "谧木活板门");
        this.add(TABlocks.WEEPING_WILLOW_TRAPDOOR.get(), "垂柳木活板门");
        this.add(TABlocks.SILENT_WOOD_BUTTON.get(), "谧木按钮");
        this.add(TABlocks.WEEPING_WILLOW_BUTTON.get(), "垂柳木按钮");
        this.add(TABlocks.AURORIAN_STONE_STAIRS.get(), "极光石楼梯");
        this.add(TABlocks.AURORIAN_STONE_BRICK_STAIRS.get(), "极光石砖楼梯");
        this.add(TABlocks.AURORIAN_COBBLESTONE_STAIRS.get(), "极光圆石楼梯");
        this.add(TABlocks.SILENT_WOOD_STAIRS.get(), "谧木楼梯");
        this.add(TABlocks.RUNE_STONE_STAIRS.get(), "符石楼梯");
        this.add(TABlocks.SMOOTH_RUNE_STONE_STAIRS.get(), "平滑符石楼梯");
        this.add(TABlocks.CHISELED_RUNE_STONE_STAIRS.get(), "雕纹符石楼梯");
        this.add(TABlocks.AURORIAN_CASTLE_RUNE_STONE_STAIRS.get(), "极光符文符石楼梯");
        this.add(TABlocks.AURORIAN_STEEL_CASTLE_RUNE_STONE_STAIRS.get(), "极光钢符文符石楼梯");
        this.add(TABlocks.CERULEAN_CASTLE_RUNE_STONE_STAIRS.get(), "晶蓝符文符石楼梯");
        this.add(TABlocks.CRYSTALLINE_CASTLE_RUNE_STONE_STAIRS.get(), "月凝晶符文符石楼梯");
        this.add(TABlocks.MOON_CASTLE_RUNE_STONE_STAIRS.get(), "皎月符文符石楼梯");
        this.add(TABlocks.TRANSPARENT_RUNE_STONE_STAIRS.get(), "透明符石楼梯");
        this.add(TABlocks.UMBRA_CASTLE_RUNE_STONE_STAIRS.get(), "本影符文符石楼梯");
        this.add(TABlocks.DARK_STONE_BRICK_STAIRS.get(), "暗石楼梯");
        this.add(TABlocks.SMOOTH_DARK_STONE_BRICK_STAIRS.get(), "平滑暗石砖块楼梯");
        this.add(TABlocks.CHISELED_DARK_STONE_BRICK_STAIRS.get(), "雕纹暗石砖块楼梯");
        this.add(TABlocks.MOON_TEMPLE_BRICK_STAIRS.get(), "月宫楼梯");
        this.add(TABlocks.SMOOTH_MOON_TEMPLE_BRICK_STAIRS.get(), "平滑月宫楼梯");
        this.add(TABlocks.CHISELED_MOON_TEMPLE_BRICK_STAIRS.get(), "雕纹月宫楼梯");
        this.add(TABlocks.UMBRA_STONE_STAIRS.get(), "本影石楼梯");
        this.add(TABlocks.UMBRA_STONE_CRACKED_STAIRS.get(), "裂纹本影石楼梯");
        this.add(TABlocks.UMBRA_STONE_ROOF_STAIRS.get(), "本影石瓦楼梯");
        this.add(TABlocks.WEEPING_WILLOW_STAIRS.get(), "垂柳木楼梯");
        this.add(TABlocks.AURORIAN_PERIDOTITE_STAIRS.get(), "橄榄岩楼梯");
        this.add(TABlocks.SMOOTH_AURORIAN_PERIDOTITE_STAIRS.get(), "平滑橄榄岩楼梯");
        this.add(TABlocks.SILENT_WOOD_FENCE.get(), "谧木栅栏");
        this.add(TABlocks.WEEPING_WILLOW_FENCE.get(), "垂柳木栅栏");
        this.add(TABlocks.SILENT_WOOD_DOOR.get(), "谧木门");
        this.add(TABlocks.WEEPING_WILLOW_DOOR.get(), "垂柳木门");
        this.add(TABlocks.AURORIAN_STONE_SLAB.get(), "极光石台阶");
        this.add(TABlocks.AURORIAN_STONE_BRICK_SLAB.get(), "极光石砖台阶");
        this.add(TABlocks.AURORIAN_COBBLESTONE_SLAB.get(), "极光圆石台阶");
        this.add(TABlocks.SILENT_WOOD_SLAB.get(), "谧木台阶");
        this.add(TABlocks.RUNE_STONE_SLAB.get(), "符石台阶");
        this.add(TABlocks.SMOOTH_RUNE_STONE_SLAB.get(), "平滑符石台阶");
        this.add(TABlocks.CHISELED_RUNE_STONE_SLAB.get(), "雕纹符石台阶");
        this.add(TABlocks.AURORIAN_CASTLE_RUNE_STONE_SLAB.get(), "极光符文符石台阶");
        this.add(TABlocks.AURORIAN_STEEL_CASTLE_RUNE_STONE_SLAB.get(), "极光钢符文符石台阶");
        this.add(TABlocks.CERULEAN_CASTLE_RUNE_STONE_SLAB.get(), "晶蓝符文符石台阶");
        this.add(TABlocks.CRYSTALLINE_CASTLE_RUNE_STONE_SLAB.get(), "月凝晶符文符石台阶");
        this.add(TABlocks.MOON_CASTLE_RUNE_STONE_SLAB.get(), "皎月符文符石台阶");
        this.add(TABlocks.TRANSPARENT_RUNE_STONE_SLAB.get(), "透明符石台阶");
        this.add(TABlocks.UMBRA_CASTLE_RUNE_STONE_SLAB.get(), "本影符文符石台阶");
        this.add(TABlocks.DARK_STONE_BRICK_SLAB.get(), "暗石砖块台阶");
        this.add(TABlocks.SMOOTH_DARK_STONE_BRICK_SLAB.get(), "平滑暗石砖块台阶");
        this.add(TABlocks.CHISELED_DARK_STONE_BRICK_SLAB.get(), "雕纹暗石砖块台阶");
        this.add(TABlocks.MOON_TEMPLE_BRICK_SLAB.get(), "月宫砖块台阶");
        this.add(TABlocks.SMOOTH_MOON_TEMPLE_BRICK_SLAB.get(), "平滑月宫砖块台阶");
        this.add(TABlocks.CHISELED_MOON_TEMPLE_BRICK_SLAB.get(), "雕纹月宫砖块台阶");
        this.add(TABlocks.UMBRA_STONE_SLAB.get(), "本影石台阶");
        this.add(TABlocks.UMBRA_STONE_CRACKED_SLAB.get(), "裂纹本影石台阶");
        this.add(TABlocks.UMBRA_STONE_ROOF_SLAB.get(), "本影石瓦台阶");
        this.add(TABlocks.WEEPING_WILLOW_SLAB.get(), "垂柳木台阶");
        this.add(TABlocks.AURORIAN_PERIDOTITE_SLAB.get(), "橄榄岩台阶");
        this.add(TABlocks.SMOOTH_AURORIAN_PERIDOTITE_SLAB.get(), "平滑橄榄岩台阶");
        this.add(TABlocks.AURORIAN_STONE_WALL.get(), "极光石墙");
        this.add(TABlocks.AURORIAN_STONE_BRICK_WALL.get(), "极光石砖墙");
        this.add(TABlocks.AURORIAN_COBBLESTONE_WALL.get(), "极光圆石墙");
        this.add(TABlocks.RUNE_STONE_WALL.get(), "符石墙");
        this.add(TABlocks.SMOOTH_RUNE_STONE_WALL.get(), "平滑符石墙");
        this.add(TABlocks.CHISELED_RUNE_STONE_WALL.get(), "雕纹符石墙");
        this.add(TABlocks.AURORIAN_CASTLE_RUNE_STONE_WALL.get(), "极光符文符石墙");
        this.add(TABlocks.AURORIAN_STEEL_CASTLE_RUNE_STONE_WALL.get(), "极光钢符文符石墙");
        this.add(TABlocks.CERULEAN_CASTLE_RUNE_STONE_WALL.get(), "晶蓝符文符石墙");
        this.add(TABlocks.CRYSTALLINE_CASTLE_RUNE_STONE_WALL.get(), "月凝晶符文符石墙");
        this.add(TABlocks.MOON_CASTLE_RUNE_STONE_WALL.get(), "皎月符文符石墙");
        this.add(TABlocks.TRANSPARENT_RUNE_STONE_WALL.get(), "透明符石墙");
        this.add(TABlocks.UMBRA_CASTLE_RUNE_STONE_WALL.get(), "本影符文符石墙");
        this.add(TABlocks.DARK_STONE_BRICK_WALL.get(), "暗石砖块墙");
        this.add(TABlocks.SMOOTH_DARK_STONE_BRICK_WALL.get(), "平滑暗石砖块墙");
        this.add(TABlocks.CHISELED_DARK_STONE_BRICK_WALL.get(), "雕纹暗石砖块墙");
        this.add(TABlocks.MOON_TEMPLE_BRICK_WALL.get(), "月宫砖块墙");
        this.add(TABlocks.SMOOTH_MOON_TEMPLE_BRICK_WALL.get(), "平滑月宫砖块墙");
        this.add(TABlocks.CHISELED_MOON_TEMPLE_BRICK_WALL.get(), "雕纹月宫砖块墙");
        this.add(TABlocks.UMBRA_STONE_WALL.get(), "本影石墙");
        this.add(TABlocks.UMBRA_STONE_CRACKED_WALL.get(), "裂纹本影石墙");
        this.add(TABlocks.UMBRA_STONE_ROOF_WALL.get(), "本影石瓦墙");
        this.add(TABlocks.AURORIAN_PERIDOTITE_WALL.get(), "橄榄岩墙");
        this.add(TABlocks.SMOOTH_AURORIAN_PERIDOTITE_WALL.get(), "平滑橄榄岩墙");

        //MOD ITEM
        this.add(TAItems.DARK_STONE_KEY.get(), "暗石钥匙");
        this.add(TAItems.MOON_TEMPLE_KEY.get(), "月宫钥匙");
        this.add(TAItems.RUNE_STONE_KEY.get(), "符石钥匙");
        this.add(TAItems.RUNE_STONE_LOOT_KEY.get(), "符石宝藏钥匙");
        this.add(TAItems.MOON_TEMPLE_CELL_KEY.get(), "月宫内室钥匙");
        this.add(TAItems.MOON_TEMPLE_CELL_KEY_FRAGMENT.get(), "月宫内室钥匙碎片");
        this.add(TAItems.ABSORPTION_ORB.get(), "修复宝珠");
        this.add(TAItems.AURORIAN_BACON.get(), "极光培根");
        this.add(TAItems.AURORIAN_COAL.get(), "极光煤炭");
        this.add(TAItems.AURORIAN_COAL_NUGGET.get(), "极光煤块");
        this.add(TAItems.AURORIAN_PORK.get(), "生极光猪排");
        this.add(TAItems.MOON_FISH_SPAWN_EGG.get(), "皎月鱼刷怪蛋");
        this.add(TAItems.AURORIAN_PIG_SPAWN_EGG.get(), "极光猪刷怪蛋");
        this.add(TAItems.AURORIAN_RABBIT_SPAWN_EGG.get(), "极光兔刷怪蛋");
        this.add(TAItems.AURORIAN_SHEEP_SPAWN_EGG.get(), "极光羊刷怪蛋");
        this.add(TAItems.AURORIAN_PIXIE_SPAWN_EGG.get(), "极光精灵刷怪蛋");
        this.add(TAItems.AURORIAN_SLIME_SPAWN_EGG.get(), "极光史莱姆刷怪蛋");
        this.add(TAItems.AURORIAN_SLIME_BOOTS.get(), "极光粘液靴子");
        this.add(TAItems.AURORIAN_SLIMEBALL.get(), "极光粘液球");
        this.add(TAItems.AURORIAN_STEEL.get(), "极光钢锭");
        this.add(TAItems.AURORIAN_STEEL_NUGGET.get(), "极光钢块");
        this.add(TAItems.AURORIAN_STEEL_AXE.get(), "极光钢斧");
        this.add(TAItems.AURORIAN_STEEL_HOE.get(), "极光钢锄");
        this.add(TAItems.AURORIAN_STEEL_PICKAXE.get(), "极光钢镐");
        this.add(TAItems.AURORIAN_STEEL_SHOVEL.get(), "极光钢铲");
        this.add(TAItems.AURORIAN_STEEL_SWORD.get(), "极光钢剑");
        this.add(TAItems.AURORIAN_STEEL_HELMET.get(), "极光钢头盔");
        this.add(TAItems.AURORIAN_STEEL_CHESTPLATE.get(), "极光钢胸甲");
        this.add(TAItems.AURORIAN_STEEL_LEGGINGS.get(), "极光钢护腿");
        this.add(TAItems.AURORIAN_STEEL_BOOTS.get(), "极光钢靴子");
        this.add(TAItems.AURORIAN_STONE_SICKLE.get(), "极光石镰");
        this.add(TAItems.AURORIAN_STONE_AXE.get(), "极光石斧");
        this.add(TAItems.AURORIAN_STONE_HOE.get(), "极光石锄");
        this.add(TAItems.AURORIAN_STONE_PICKAXE.get(), "极光石镐");
        this.add(TAItems.AURORIAN_STONE_SHOVEL.get(), "极光石铲");
        this.add(TAItems.AURORIAN_STONE_SWORD.get(), "极光石剑");
        this.add(TAItems.AURORIANITE_INGOT.get(), "极光锭");
        this.add(TAItems.AURORIANITE_SCRAP.get(), "极光碎片");
        this.add(TAItems.AURORIANITE_SWORD.get(), "极光剑");
        this.add(TAItems.AURORIANITE_AXE.get(), "极光斧");
        this.add(TAItems.AURORIANITE_PICKAXE.get(), "极光镐");
        this.add(TAItems.BEPSI.get(), "旦事可乐");
        this.add(TAItems.CERULEAN_ARROW.get(), "晶蓝箭");
        this.add(TAItems.CERULEAN_INGOT.get(), "晶蓝锭");
        this.add(TAItems.CERULEAN_NUGGET.get(), "晶蓝块");
        this.add(TAItems.CERULEAN_HELMET.get(), "晶蓝头盔");
        this.add(TAItems.CERULEAN_CHESTPLATE.get(), "晶蓝胸甲");
        this.add(TAItems.CERULEAN_LEGGINGS.get(), "晶蓝护腿");
        this.add(TAItems.CERULEAN_BOOTS.get(), "晶蓝靴子");
        this.add(TAItems.CERULEAN_SHIELD.get(), "晶蓝盾牌");
        this.add(TAItems.COOKED_AURORIAN_PORK.get(), "熟极光猪排");
        this.add(TAItems.CRYSTAL.get(), "水晶");
        this.add(TAItems.CRYSTAL_ARROW.get(), "水晶箭");
        this.add(TAItems.CRYSTALLINE_INGOT.get(), "月凝晶锭");
        this.add(TAItems.CRYSTALLINE_SCRAP.get(), "月凝晶碎片");
        this.add(TAItems.CRYSTALLINE_PICKAXE.get(), "月凝晶镐");
        this.add(TAItems.CRYSTALLINE_SHIELD.get(), "月凝晶盾牌");
        this.add(TAItems.CRYSTALLINE_SWORD.get(), "月凝晶剑");
        this.add(TAItems.CRYSTALLINE_SPRITE.get(), "月凝晶魂");
        this.add(TAItems.CRYSTALLINE_SPRITE_SPAWN_EGG.get(), "月凝晶魂刷怪蛋");
        this.add(TAItems.DARK_AMULET.get(), "暗黑护符");
        this.add(TAItems.DUNGEON_KEEPER_AMULET.get(), "地牢守卫护身符");
        this.add(TAItems.TROPHY_KEEPER.get(), "符石地牢守卫奖励");
        this.add(TAItems.DISTURBED_HOLLOW_SPAWN_EGG.get(), "空谷之扰刷怪蛋");
        this.add(TAItems.DUNGEON_LOCATOR.get(), "地牢定位器");
        this.add(TAItems.KEEPERS_BOW.get(), "守卫之弓");
        this.add(TAItems.KNIGHT_HELMET.get(), "骑士头盔");
        this.add(TAItems.KNIGHT_CHESTPLATE.get(), "骑士胸甲");
        this.add(TAItems.KNIGHT_LEGGINGS.get(), "骑士护腿");
        this.add(TAItems.KNIGHT_BOOTS.get(), "骑士靴子");
        this.add(TAItems.LAVENDER.get(), "薰衣草");
        this.add(TAItems.LAVENDER_BREAD.get(), "薰衣草面包");
        this.add(TAItems.LAVENDER_TEA.get(), "薰衣草茶");
        this.add(TAItems.LIVING_DIVINING_ROD.get(), "生命卜窥权杖");
        this.add(TAItems.MOON_WATER_BUCKET.get(), "皎月水桶");
        this.add(TAItems.MOON_FISH_BUCKET.get(), "皎月鱼桶");
        this.add(TAItems.LOCK_PICKS.get(), "开锁器");
        this.add(TAItems.DEVELOPER_GIFT.get(), "开发者礼物");
        this.add(TAItems.MOON_ACOLYTE_SPAWN_EGG.get(), "皎月侍从刷怪蛋");
        this.add(TAItems.MOON_QUEEN_SPAWN_EGG.get(), "皎月女王刷怪蛋");
        this.add(TAItems.MOONSTONE_INGOT.get(), "皎月石锭");
        this.add(TAItems.MOONSTONE_NUGGET.get(), "皎月石块");
        this.add(TAItems.MOON_SHIELD.get(), "皎月之盾");
        this.add(TAItems.MOONSTONE_SHIELD.get(), "皎月石盾");
        this.add(TAItems.MOONSTONE_AXE.get(), "皎月石斧");
        this.add(TAItems.MOONSTONE_HOE.get(), "皎月石锄");
        this.add(TAItems.MOONSTONE_PICKAXE.get(), "皎月石镐");
        this.add(TAItems.MOONSTONE_SHOVEL.get(), "皎月石铲");
        this.add(TAItems.MOONSTONE_SWORD.get(), "皎月石剑");
        this.add(TAItems.MOONSTONE_SICKLE.get(), "皎月石镰");
        this.add(TAItems.PETUNIA_TEA.get(), "牵牛花茶");
        this.add(TAItems.PLANT_FIBER.get(), "植物纤维");
        this.add(TAItems.QUEENS_CHIPPER.get(), "女王镐");
        this.add(TAItems.RUNESTONE_KEEPER_SPAWN_EGG.get(), "符石守卫刷怪蛋");
        this.add(TAItems.LAVENDER_SEEDY_TEA.get(), "薰衣草籽茶");
        this.add(TAItems.SILENT_WOOD_SICKLE.get(),"谧木镰");
        this.add(TAItems.SILENT_WOOD_AXE.get(), "谧木斧");
        this.add(TAItems.SILENT_WOOD_HOE.get(), "谧木锄");
        this.add(TAItems.SILENT_WOOD_PICKAXE.get(), "谧木镐");
        this.add(TAItems.SILENT_WOOD_SHOVEL.get(), "谧木铲");
        this.add(TAItems.SILENT_WOOD_SWORD.get(), "谧木剑");
        this.add(TAItems.SILENT_WOOD_BOW.get(), "谧木弓");
        this.add(TAItems.SILENT_WOOD_STICK.get(), "谧木棍");
        this.add(TAItems.WICK_GRASS.get(), "灯芯草");
        this.add(TAItems.BLUEBERRY.get(),"蓝莓");
        this.add(TAItems.SILK_BERRY.get(), "桑葚");
        this.add(TAItems.SILK_BERRY_JAM.get(), "桑葚酱");
        this.add(TAItems.SILK_BERRY_JAM_SANDWICH.get(), "桑葚酱三明治");
        this.add(TAItems.SILK_BERRY_TEA.get(), "桑葚茶");
        this.add(TAItems.SILK_SHROOM_STEW.get(), "桑葚煲");
        this.add(TAItems.SLEEPING_BLACK_TEA.get(), "昏睡红茶");
        this.add(TAItems.SOULLESS_FLESH.get(), "魂灭之肉");
        this.add(TAItems.MOON_FISH.get(), "生皎月鱼");
        this.add(TAItems.WHITE_CHOCOLATE.get(), "白巧克力");
        this.add(TAItems.CANDY.get(), "糖果");
        this.add(TAItems.CANDY_CANE.get(), "拐杖糖");
        this.add(TAItems.GINGERBREAD_MAN.get(), "姜饼人");
        this.add(TAItems.AURORIAN_SPECIALTY_DRINK.get(), "极光特饮");
        this.add(TAItems.MOONLIT_BLUEBERRY_SPECIALTY_DRINK.get(), "皎月蓝莓特饮");
        this.add(TAItems.SPECTRAL_SILK.get(), "幽冥丝绸");
        this.add(TAItems.SPECTRAL_HELMET.get(), "幽冥头盔");
        this.add(TAItems.SPECTRAL_CHESTPLATE.get(), "幽冥胸甲");
        this.add(TAItems.SPECTRAL_LEGGINGS.get(), "幽冥护腿");
        this.add(TAItems.SPECTRAL_BOOTS.get(), "幽冥靴子");
        this.add(TAItems.SPIDER_MOTHER_SPAWN_EGG.get(), "蛛母刷怪蛋");
        this.add(TAItems.SPIDERLING_SPAWN_EGG.get(), "幼蛛刷怪蛋");
        this.add(TAItems.SPIRIT_SPAWN_EGG.get(), "魂灵刷怪蛋");
        this.add(TAItems.SPIKED_CHESTPLATE.get(), "尖钉胸甲");
        this.add(TAItems.STICKY_SPIKER.get(), "粘性尖钉");
        this.add(TAItems.TEA_CUP.get(), "茶杯");
        this.add(TAItems.TROPHY_MOON_QUEEN.get(), "皎月女王奖励");
        this.add(TAItems.TROPHY_SPIDER_MOTHER.get(), "蛛母奖励");
        this.add(TAItems.UMBRA_INGOT.get(), "本影锭");
        this.add(TAItems.UMBRA_SCRAP.get(), "本影碎片");
        this.add(TAItems.UMBRA_SHIELD.get(), "本影盾牌");
        this.add(TAItems.UMBRA_SWORD.get(), "本影剑");
        this.add(TAItems.UMBRA_PICKAXE.get(), "本影镐");
        this.add(TAItems.UNDEAD_KNIGHT_SPAWN_EGG.get(), "不死骑士刷怪蛋");
        this.add(TAItems.AURORIAN_CHAIN.get(),"极光锁链");
        this.add(TAItems.AURORIAN_BERRY.get(),"极光浆果");
        this.add(TAItems.AURORIAN_CRYSTAL.get(),"极光水晶");
        this.add(TAItems.DREAM_DYEING_CRYSTAL_FRAGMENT.get(),"融梦水晶碎片");
        this.add(TAItems.EQUINOX_MUSHROOM.get(),"彼岸蘑菇");
        this.add(TAItems.RED_BOOK.get(), "红皮书");
        this.add(TAItems.RED_BOOK_RING.get(), "红皮书戒指");
        this.add(TAItems.STAR_OCEAN_CROSSBOW.get(), "星弩");
        this.add(TAItems.CAT_BELL.get(), "猫猫的铃铛");
        this.add(TAItems.TSLAT_SWORD.get(), "Tslat的剑");
        this.add(TAItems.WORLD_SCROLL_FRAGMENT.get(),"世界残卷");
        this.add(TAItems.WORLD_SCROLL.get(),"世界卷轴");
        this.add(TAItems.WEEPING_WILLOW_SAP.get(), "垂柳树汁");
        this.add(TAItems.WEBBING.get(), "蛛网");

        //MOD ENTITY
        this.add(TAEntityTypes.CRYSTALLINE_BEAM.get(), "月凝晶射线");
        this.add(TAEntityTypes.CERULEAN_ARROW.get(), "晶蓝箭");
        this.add(TAEntityTypes.CRYSTAL_ARROW.get(), "水晶箭");
        this.add(TAEntityTypes.STICKY_SPIKER.get(), "粘性尖刺");
        this.add(TAEntityTypes.WEBBING.get(), "蛛母之网");
        this.add(TAEntityTypes.EYE_OF_DISTURBED.get(), "空谷之眼");
        this.add(TAEntityTypes.MOON_FISH.get(), "皎月鱼");
        this.add(TAEntityTypes.AURORIAN_RABBIT.get(), "极光兔");
        this.add(TAEntityTypes.AURORIAN_SHEEP.get(), "极光羊");
        this.add(TAEntityTypes.AURORIAN_PIG.get(), "极光猪");
        this.add(TAEntityTypes.AURORIAN_PIXIE.get(), "极光精灵");
        this.add(TAEntityTypes.AURORIAN_SLIME.get(), "极光史莱姆");
        this.add(TAEntityTypes.DISTURBED_HOLLOW.get(), "空谷之扰");
        this.add(TAEntityTypes.UNDEAD_KNIGHT.get(), "不死骑士");
        this.add(TAEntityTypes.SPIRIT.get(), "魂灵");
        this.add(TAEntityTypes.MOON_ACOLYTE.get(), "皎月侍从");
        this.add(TAEntityTypes.SPIDERLING.get(), "幼蛛");
        this.add(TAEntityTypes.CRYSTALLINE_SPRITE.get(), "月凝晶魂");
        this.add(TAEntityTypes.RUNESTONE_KEEPER.get(), "符石守卫");
        this.add(TAEntityTypes.SPIDER_MOTHER.get(), "蛛母");
        this.add(TAEntityTypes.MOON_QUEEN.get(), "皎月女王");

        //MOB EFFECT
        this.add(TAMobEffects.STUN.get(), "眩晕");
        this.add(TAMobEffects.MOON_CURSE.get(), "皎月之咒");

        //MOD ENCHANTMENT
        this.add(TAEnchantments.LIGHTNING_RESISTANCE.get(), "雷电抵御");
        this.add(TAEnchantments.LIGHTNING_DAMAGE.get(), "雷电");
        this.add(TAEnchantments.LIGHTNING_RESISTANCE.get().getDescriptionId() + ".desc", "降低“雷电”魔咒造成的额外伤害，同时完全抵消被雷击中的伤害");
        this.add(TAEnchantments.LIGHTNING_DAMAGE.get().getDescriptionId() + ".desc", "根据对方穿戴的护甲数量造成额外伤害");

        //MOD PAINTING
        this.add(TAPaintingVariants.createDescriptionId(TAPaintingVariants.AURORIAN_STEEL.get()), "极光钢");
        this.add(TAPaintingVariants.createDescriptionId(TAPaintingVariants.PROGRESSION.get()), "前进");
        this.add(TAPaintingVariants.createDescriptionId(TAPaintingVariants.DUNGEON.get()), "地牢");
        this.add(TAPaintingVariants.createDescriptionId(TAPaintingVariants.KEEPER.get()), "守卫");
        this.add(TAPaintingVariants.createDescriptionId(TAPaintingVariants.KNIGHT.get()), "骑士");
        this.add(TAPaintingVariants.createDescriptionId(TAPaintingVariants.MOON.get()), "皎月");
        this.add(TAPaintingVariants.createDescriptionId(TAPaintingVariants.PORTAL.get()), "传送门");
        this.add(TAPaintingVariants.createDescriptionId(TAPaintingVariants.SLIME.get()), "史莱姆");

        //MOD TOOLTIPS
        this.addTooltips(TAItems.AURORIAN_STEEL_HELMET, "真正的极光赐福！盔甲上的附魔会随时间推移而缓慢升级，直到达到对应附魔的等级上限！");
        this.addTooltips(TAItems.AURORIAN_STEEL_CHESTPLATE, "真正的极光赐福！盔甲上的附魔会随时间推移而缓慢升级，直到达到对应附魔的等级上限！");
        this.addTooltips(TAItems.AURORIAN_STEEL_LEGGINGS, "真正的极光赐福！盔甲上的附魔会随时间推移而缓慢升级，直到达到对应附魔的等级上限！");
        this.addTooltips(TAItems.AURORIAN_STEEL_BOOTS, "真正的极光赐福！盔甲上的附魔会随时间推移而缓慢升级，直到达到对应附魔的等级上限！");
        this.addTooltips(TAItems.CERULEAN_HELMET, "强度不错的蓝色盔甲，能暂时保护你探索这个世界.");
        this.addTooltips(TAItems.CERULEAN_CHESTPLATE, "强度不错的蓝色盔甲，能暂时保护你探索这个世界.");
        this.addTooltips(TAItems.CERULEAN_LEGGINGS, "强度不错的蓝色盔甲，能暂时保护你探索这个世界.");
        this.addTooltips(TAItems.CERULEAN_BOOTS, "强度不错的蓝色套盔甲，能暂时保护你探索这个世界.");
        this.addTooltips(TAItems.KNIGHT_HELMET, "被诅咒的骑士之物.穿上整套将附有力量I增幅！");
        this.addTooltips(TAItems.KNIGHT_CHESTPLATE, "被诅咒的骑士之物.穿上整套将附有力量I增幅！");
        this.addTooltips(TAItems.KNIGHT_LEGGINGS, "被诅咒的骑士之物.穿上整套将附有力量I增幅！");
        this.addTooltips(TAItems.KNIGHT_BOOTS, "被诅咒的骑士之物.穿上整套将附有力量I增幅!");
        this.addTooltips(TAItems.SPECTRAL_HELMET, "附着魂灵的残念.每件盔甲都有 6% 的几率在攻击时净化身上的负面效果！");
        this.addTooltips(TAItems.SPECTRAL_CHESTPLATE, "附着魂灵的残念.每件盔甲都有 6% 的几率在攻击时净化身上的负面效果！");
        this.addTooltips(TAItems.SPECTRAL_LEGGINGS, "附着魂灵的残念.每件盔甲都有 6% 的几率在攻击时净化身上的负面效果！");
        this.addTooltips(TAItems.SPECTRAL_BOOTS, "附着魂灵的残念.每件盔甲都有 6% 的几率在攻击时净化身上的负面效果！");
        this.addTooltips(TAItems.SPIKED_CHESTPLATE, "反击那些攻击你的敌人.潜行时将会获得荆棘III附魔与缓慢I效果！");
        this.addTooltips(TAItems.AURORIAN_SLIME_BOOTS, "用处不错，但黏糊糊的感觉并不好.潜行时起跳会跳得更高，并且还能消除摔落伤害！");
        this.addTooltips(TAItems.AURORIAN_STEEL_SWORD, "真正的极光赐福！剑上的附魔会随时间推移而缓慢升级，直到达到对应附魔的等级上限！");
        this.addTooltips(TAItems.AURORIAN_STONE_SWORD, "仅仅只比木剑强力一点点.");
        this.addTooltips(TAItems.SILENT_WOOD_SWORD, "即使是防身也并不推荐.");
        this.addTooltips(TAItems.UMBRA_SWORD, "诅咒之剑！右击消耗 20 点耐久度，立即获得伤害吸收、虚弱、缓慢 II、抗性提升 III 各 6 秒，冷却时间 45 秒.");
        this.addTooltips(TAItems.AURORIANITE_SWORD, "极光让周围的人与我一同失重！右键时消耗五点耐久，让自己与周围的所有生物获得持续三秒的飘浮效果，冷却时间为三十秒.");
        this.addTooltips(TAItems.CRYSTALLINE_SWORD, "充能！发射水晶光束！长按右键蓄力，消耗一点耐久，蓄力满后松开右键发射出一道不受重力影响，速度略逊于弓箭的光柱.");
        this.addTooltips(TAItems.MOONSTONE_SWORD, "女王的蔑视！在皎月夜晚有几率不会消耗耐久，但在极光夜有几率消耗 2 点耐久.");
        this.addTooltips(TAItems.AURORIAN_STEEL_SHOVEL, "真正的极光赐福！铲上的附魔会随时间推移而缓慢升级，直到达到对应附魔的等级上限！");
        this.addTooltips(TAItems.AURORIAN_STONE_SHOVEL, "仅仅只比木铲强力一点点.");
        this.addTooltips(TAItems.SILENT_WOOD_SHOVEL, "即使是挖掘也并不推荐.");
        this.addTooltips(TAItems.MOONSTONE_SHOVEL, "女王的蔑视！在皎月夜晚有几率不会消耗耐久，但在极光夜有几率消耗 2 点耐久.");
        this.addTooltips(TAItems.AURORIAN_STEEL_AXE, "真正的极光赐福！斧上的附魔会随时间推移而缓慢升级，直到达到对应附魔的等级上限！");
        this.addTooltips(TAItems.AURORIANITE_AXE, "极光让我力大无穷！以消耗额外的耐久为代价，砍倒整棵谧木树！！");
        this.addTooltips(TAItems.AURORIAN_STONE_AXE, "仅仅只比木斧强力一点点.");
        this.addTooltips(TAItems.SILENT_WOOD_AXE, "神奇的谧木工具在砍伐谧木时，有机会恢复自己的耐久！");
        this.addTooltips(TAItems.MOONSTONE_AXE, "女王的蔑视！在皎月夜晚有几率不会消耗耐久，但在极光夜有几率消耗 2 点耐久.");
        this.addTooltips(TAItems.AURORIAN_STEEL_PICKAXE, "真正的极光赐福！镐上的附魔会随时间推移而缓慢升级，直到达到对应附魔的等级上限！");
        this.addTooltips(TAItems.AURORIANITE_PICKAXE, "极光让我拥有无穷精力！持续的挖掘会缓慢提高挖掘速度！");
        this.addTooltips(TAItems.UMBRA_PICKAXE, "诅咒之镐！选择一种方块，对它进行挖掘的速度会有所提高，但是选择这一过程会减少大量耐久度！");
        this.addTooltips(TAItems.CRYSTALLINE_PICKAXE, "赞美月光！挖掘矿石会有额外掉落！");
        this.addTooltips(TAItems.AURORIAN_STONE_PICKAXE, "开采极光石时，有机会恢复自身耐久.");
        this.addTooltips(TAItems.SILENT_WOOD_PICKAXE, "神奇的谧木工具在耐久度低时会提高挖掘等级！");
        this.addTooltips(TAItems.MOONSTONE_PICKAXE, "女王的蔑视！在皎月夜晚有几率不会消耗耐久，但在极光夜有几率消耗 2 点耐久.");
        this.addTooltips(TAItems.QUEENS_CHIPPER, "可怜的女王，灵魂被封印在这把镐子里，让其拥有极强的破坏力.右击可以破坏原本无法破坏的地牢组成方块!");
        this.addTooltips(TAItems.AURORIAN_STEEL_HOE, "真正的极光赐福！锄上的附魔会随时间推移而缓慢升级，直到达到对应附魔的等级上限！");
        this.addTooltips(TAItems.AURORIAN_STONE_HOE, "仅仅只比木锄强力一点点.");
        this.addTooltips(TAItems.SILENT_WOOD_HOE, "即使是锄地也并不推荐.");
        this.addTooltips(TAItems.MOONSTONE_HOE, "女王的蔑视！在皎月夜晚有几率不会消耗耐久，但在极光夜有几率消耗 2 点耐久.");
        this.addTooltips(TAItems.SILENT_WOOD_SICKLE, "可以像剪刀一样采集树叶、草、蜘蛛网等物品，同样也可以被用于获取植物纤维，破坏极光高草丛和发光极光高草丛即可.");
        this.addTooltips(TAItems.AURORIAN_STONE_SICKLE, "比木镰更加耐用.");
        this.addTooltips(TAItems.MOONSTONE_SICKLE, "女王的蔑视！在皎月夜晚有几率不会消耗耐久，但在极光夜有几率消耗 2 点耐久.");
        this.addTooltips(TAItems.UMBRA_SHIELD, "诅咒之盾！在抵挡攻击状态下时会点燃正前方的实体。抵挡时间过长会过载！.");
        this.addTooltips(TAItems.CERULEAN_SHIELD, "强度不错的蓝色盾牌，能暂时保护你探索这个世界..");
        this.addTooltips(TAItems.CRYSTALLINE_SHIELD, "赞美月光！完成抵挡后，修复你的主手物品！");
        this.addTooltips(TAItems.MOONSTONE_SHIELD, "女王的蔑视！在皎月夜晚有几率不会消耗耐久，但在极光夜有几率消耗 2 点耐久.");
        this.addTooltips(TAItems.MOON_SHIELD, "赞颂女王！右击蓄能，然后将敌人狠狠地击飞到空中！");
        this.addTooltips(TAItems.SILENT_WOOD_BOW, "普通的远程武器.");
        this.addTooltips(TAItems.KEEPERS_BOW, "完全充能后自动一次性射出三支箭矢！");
        this.addTooltips(TAItems.LAVENDER_TEA, "悠闲时光.饮用后获得持续15秒的抗性提升I效果.");
        this.addTooltips(TAItems.SILK_BERRY_TEA, "悠闲时光.饮用后获得持续5秒的生命恢复I效果.");
        this.addTooltips(TAItems.LAVENDER_SEEDY_TEA, "悠闲时光.饮用后获得持续10秒的速度I效果.");
        this.addTooltips(TAItems.PETUNIA_TEA, "悠闲时光.饮用后获得持续15秒的力量I效果.");
        this.addTooltips(TAItems.BEPSI, "哪来的山寨货？？");
        this.addTooltips(TAItems.WEEPING_WILLOW_SAP, "不错的解毒剂.去除你的中毒效果，但却会使你获得缓慢效果，持续时间取决于中毒效果被移除之前的剩余持续时间.");
        this.addTooltips(TAItems.SILK_BERRY_JAM, "不错！要是来点搭配就好！");
        this.addTooltips(TAItems.SILK_BERRY_JAM_SANDWICH, "美味！味道好极了！");
        this.addTooltips(TAItems.AURORIAN_PORK, "丰富的蛋白质！建议烤熟再吃！");
        this.addTooltips(TAItems.COOKED_AURORIAN_PORK, "美味！很好的饱腹食物！");
        this.addTooltips(TAItems.AURORIAN_BACON, "不错！虽泛紫意，但鲜嫩多汁！");
        this.addTooltips(TAItems.AURORIAN_SLIMEBALL, "黏糊糊的！感觉不是很好.");
        this.addTooltips(TAItems.SILK_SHROOM_STEW, "美味！如果再来一碗也不错.");
        this.addTooltips(TAItems.LAVENDER_BREAD, "不错！为什么不试试搭配果酱呢？");
        this.addTooltips(TAItems.SOULLESS_FLESH, "恶心！如果实在没有办法我一定不会去吃！");
        this.addTooltips(TAItems.MOON_FISH, "好重的鱼腥味！不如试着烤熟再吃！");
        this.addTooltips(TAItems.SILK_BERRY, "可以做成果酱，应该更加可口！");
        this.addTooltips(TAItems.BLUEBERRY, "鲜嫩的水果也会心情愉悦呢！");
        this.addTooltips(TAItems.AURORIAN_COAL, "比普通煤炭更持久一点.");
        this.addTooltips(TAItems.AURORIANITE_INGOT, "极光加护！");
        this.addTooltips(TAItems.AURORIAN_STEEL, "真正的极光赐福！随着时间的推移，此物品上的附魔会升级！");
        this.addTooltips(TAItems.CERULEAN_INGOT, "不错的装备材料.");
        this.addTooltips(TAItems.CRYSTALLINE_INGOT, "皎月的精华！赞美女王！");
        this.addTooltips(TAItems.MOONSTONE_INGOT, "女王的蔑视！极光女王？放逐！");
        this.addTooltips(TAItems.UMBRA_INGOT, "有一种不详的气息...");
        this.addTooltips(TAItems.AURORIANITE_SCRAP, "通过探索符石地牢，烧制或者粉碎极光工具获取.");
        this.addTooltips(TAItems.CRYSTALLINE_SCRAP, "通过探索月宫，烧制或者粉碎月凝晶工具获取.");
        this.addTooltips(TAItems.UMBRA_SCRAP, "通过探索暗石地牢，烧制或者粉碎本影工具获取.");
        this.addTooltips(TAItems.SPECTRAL_SILK, "魂灵掉落物，似乎能合成不错的套装.");
        this.addTooltips(TAItems.DARK_AMULET, "恐惧之息细微弥漫，用于制作月宫钥匙.");
        this.addTooltips(TAItems.DUNGEON_KEEPER_AMULET, "腐败之力在蠢蠢欲动，用于制作暗石钥匙.");
        this.addTooltips(TAItems.MOON_TEMPLE_CELL_KEY_FRAGMENT, "用于合成进入月宫内室的月宫内室钥匙.");
        this.addTooltips(TAItems.RUNE_STONE_KEY, "用于开启符石地牢.");
        this.addTooltips(TAItems.DARK_STONE_KEY, "用于开启暗石地牢入口大门.");
        this.addTooltips(TAItems.RUNE_STONE_LOOT_KEY, "用于开启符文地牢宝藏室.");
        this.addTooltips(TAItems.MOON_TEMPLE_KEY, "用于开启月宫入口大门.");
        this.addTooltips(TAItems.MOON_TEMPLE_CELL_KEY, "用于开启暗石地牢入口大门.");
        this.addTooltips(TAItems.ABSORPTION_ORB, "在副手时会修复你主手持握的物品！");
        this.addTooltips(TAItems.SILENT_WOOD_STICK, "随处可见的普通材料.");
        this.addTooltips(TAItems.STICKY_SPIKER, "使命中的实体中毒.");
        this.addTooltips(TAItems.LAVENDER, "芳香的植物，制作食物一定美味！可通过镰刀收割获得.");
        this.addTooltips(TAItems.PLANT_FIBER, "似乎有丝线般的强度，用镰破坏极光高草丛获得.");
        this.addTooltips(TAItems.TROPHY_KEEPER, "被放逐500年的亡灵终于得到安息.");
        this.addTooltips(TAItems.TROPHY_SPIDER_MOTHER, "被诅咒的邪祟引来了它的解脱.");
        this.addTooltips(TAItems.TROPHY_MOON_QUEEN, "极光世界终于迎来了它的自由，但似乎只是另一个噩梦的开始.");
        this.addTooltips(TAItems.CRYSTAL, "挖掘晶簇矿石获得，用于合成和粉碎器耗材.");
        this.addTooltips(TAItems.SLEEPING_BLACK_TEA, "嘿，幼幼紫，你动不动就变男娘的日子结束了。把昏睡红茶给我！");
        this.addTooltips(TAItems.WHITE_CHOCOLATE, "摩多罗的遗物（不是）开发者物品，她在椅子上死掉了所以这个巧克力长腿跑了。现在它是你的巧克力了，真巧。因为常年被摩多罗视作珍宝，所以这块巧克力上有摩多罗的魔力。妄然吃掉的话可能会发生不得了的事情……！");
        this.addTooltips(TAItems.DREAM_DYEING_CRYSTAL_FRAGMENT, "青春猪头尘不会梦到幼幼紫学姐.");
        this.addTooltips(TAItems.RED_BOOK, "写满世间各种死因的书，却是个徒有其表的通讯装置？！");
        this.addTooltips(TAItems.RED_BOOK_RING, "没想到那个人会制作一个徒有其表的东西啊！");
        this.addTooltips(TAItems.STAR_OCEAN_CROSSBOW, "我去，你怎么知道弩是我爹——StarOcean1266.");
        this.addTooltips(TAItems.CAT_BELL, "虽然不会把你变猫娘，但是可以让你像猫一样快！");
        this.addTooltips(TAItems.TSLAT_SWORD, "没有人比tslat更懂该怎么做muti-dims mod XD");
    }

    private void addTooltips(Supplier<Item> key, String name) {
        this.add("tooltips." + key.get().getDescriptionId(), name);
    }

}