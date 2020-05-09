package tech.mycps.sces.domain;

/**
 * @Author: LiuYaoWen
 * @Date: 2020/4/12 下午3:42
 */
public class Score {

    private String studentId;
    private int itemId;
    private int score;
    private int begin;

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "studentId='" + studentId + '\'' +
                ", itemId=" + itemId +
                ", score=" + score +
                ", begin=" + begin +
                '}';
    }
}
