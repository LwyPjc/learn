package learn.java8.streamLambdaDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import tools.PrintStreamUtil;

import java.util.*;

/**
 * 考试成绩模型
 */
@Data
@AllArgsConstructor
class ExamStudentScore {
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 成绩
     */
    private Integer scoreValue;
    /**
     * 科目
     */
    private String subject;
}

public class CaseFind {

    /**
     * 学生考试成绩
     */
    Map<String, List<ExamStudentScore>> studentMap;

    @Before
    public void init() {
        studentMap = new HashMap<>();

        List<ExamStudentScore> zsScoreList = new ArrayList<>();
        zsScoreList.add(
                new ExamStudentScore(
                        "张三",
                        30,
                        "CHINESE"));
        zsScoreList.add(
                new ExamStudentScore(
                        "张三",
                        40,
                        "ENGLISH"));
        zsScoreList.add(
                new ExamStudentScore(
                        "张三",
                        50,
                        "MATHS"));
        studentMap.put("张三", zsScoreList);

        List<ExamStudentScore> lsScoreList = new ArrayList<>();
        lsScoreList.add(
                new ExamStudentScore(
                        "李四",
                        80,
                        "CHINESE"));
        lsScoreList.add(
                new ExamStudentScore(
                        "李四",
                        null,
                        "ENGLISH"));
        lsScoreList.add(
                new ExamStudentScore(
                        "李四",
                        100,
                        "MATHS"));
        studentMap.put("李四", lsScoreList);

        List<ExamStudentScore> wwScoreList = new ArrayList<>();
        wwScoreList.add(
                new ExamStudentScore(
                        "王五",
                        null,
                        "CHINESE"));
        wwScoreList.add(
                new ExamStudentScore(
                        "王五",
                        null,
                        "ENGLISH"));
        wwScoreList.add(
                new ExamStudentScore(
                        "王五",
                        70,
                        "MATHS"));
        studentMap.put("王五", wwScoreList);
    }

    /**
     * 查找缺考考生姓名
     */
    @Test
    public void findNotTest() {
//        studentMap.entrySet().stream()
////                .filter((String x, List<ExamStudentScore> y) -> {
//////                    return y.stream().anyMatch(examStudentScore -> examStudentScore.getScoreValue() == null);
////
////                }).forEach(PrintStreamUtil::printObject);

//        studentMap.entrySet().stream.((x, y) -> {
//            y.stream().filter(examStudentScore -> examStudentScore.getScoreValue()==null)
//        });

        studentMap.entrySet().stream()
                .filter(entry -> {
                    return entry.getValue().stream().anyMatch(examStudentScore -> examStudentScore.getScoreValue() == null);
                })
//                .peek(PrintStreamUtil::printObject)
                .map(Map.Entry::getKey)
                .forEach(PrintStreamUtil::printObject);

    }


}
