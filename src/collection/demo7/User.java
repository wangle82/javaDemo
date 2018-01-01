package collection.demo7;

/**
 * Created by wangle on 2017/12/24.
 */

public class User implements Comparable<User>{
    public User(int score,String name) {
        this.score = score;
        this.name = name;
    }

    int score;
    String name;

    /**
     * 优先级队列的权重
     * @param o
     * @return
     */
    @Override
    public int compareTo(User o) {
        return this.score - o.score ;
    }
}
