
package core.blocks;

public class MinecraftBlock {

    private final int x;
    private final int y;
    private final int z;
    private final String blockId;

    public MinecraftBlock(
            int x,
            int y,
            int z,
            String blockId
    ) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.blockId = blockId;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String getBlockId() {
        return blockId;
    }

    @Override
    public String toString() {
        return "MinecraftBlock{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", blockId='" + blockId + '\'' +
                '}';
    }
}