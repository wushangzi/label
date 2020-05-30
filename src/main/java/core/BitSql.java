package core;

/**
 * @author chengyongjun
 * @date 5/29/20 9:56 AM
 */
public interface BitSql<T> extends BitFactory {

    T getAllExistFromId(int[] id, String name);

    T getAllExistFromBits(int[] id);
}
