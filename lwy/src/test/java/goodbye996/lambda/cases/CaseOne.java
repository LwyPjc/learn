package goodbye996.lambda.cases;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaseOne {

    Map<String, List<ExamStudentScore>> studentMap =
            new HashMap<>();
    class ExamStudentScore {
        //姓名
        private String studentName;
        //分数
        private Integer scoreValue;
        //科目
        private String subject;

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public Integer getScoreValue() {
            return scoreValue;
        }

        public void setScoreValue(Integer scoreValue) {
            this.scoreValue = scoreValue;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public ExamStudentScore(String studentName, Integer scoreValue, String subject) {
            this.studentName = studentName;
            this.scoreValue = scoreValue;
            this.subject = subject;
        }
    }

    @Before
    public void init() {

        List<ExamStudentScore> zsScoreList = new ArrayList<>();
        zsScoreList.add(new ExamStudentScore("张三",30,"CHINESE"));
        zsScoreList.add(new ExamStudentScore("张三",40,"ENGLISH"));
        zsScoreList.add(new ExamStudentScore("张三",50,"MATHS"));
        studentMap.put("张三",zsScoreList);


        List<ExamStudentScore> lsScoreList = new ArrayList<>();
        lsScoreList.add(new ExamStudentScore("李四",80,"CHINESE"));
        lsScoreList.add(new ExamStudentScore("李四",null,"ENGLISH"));
        lsScoreList.add(new ExamStudentScore("李四",100,"MATHS"));
        studentMap.put("李四",lsScoreList);

        List<ExamStudentScore> wwScoreList = new ArrayList<>();
        wwScoreList.add(new ExamStudentScore("王五",null,"CHINESE"));
        wwScoreList.add(new ExamStudentScore("王五",null,"ENGLISH"));
        wwScoreList.add(new ExamStudentScore("王五",70,"MATHS"));
        studentMap.put("王五",wwScoreList);
    }

    //查找成绩为空的数据
    @Test
    public void selectNull(){

      studentMap.forEach((studentName,stuList)->{
          boolean bool = stuList.stream()
                  .anyMatch(stu->{
                    return stu.getScoreValue()==null;
                  });
          if (bool){
              System.out.println("学生"+studentName+"缺考");
          }
      });
//        System.out.println(JSON.toJSONString(studentMap,true));
    }

}
