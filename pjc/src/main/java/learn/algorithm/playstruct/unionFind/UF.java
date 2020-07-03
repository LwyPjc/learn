package learn.algorithm.playstruct.unionFind;

/**
 *
 */
public interface UF {

    int getSize();

    /**
     * 是否相连，是否属于同一个集合
     *
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 连接集合
     *
     * @param p
     * @param q
     */
    void unionElements(int p, int q);
}
