### 计算学生成绩

##### 1、创建三个表：

​	yigu_student (student_id, student_name, student_class)、 

​	yigu_class (class_id, class_name, redit )、

​	yigu_score (score_id, student_id, class_id, score  )



##### 2、编写类向表 yigu_score 随机插入数据

```java
import java.util.Random;

/** 
	定义方法向 yigu_score 批量插入数据
	score_id = NULL ,
	student_id in (1,12)
	class_id in (1,6)
	score in (40,100)
*/
public class InsertScore{
	public static void main(String[] args)throws Exception{
		
		Random random = new Random();
			
		int stu ;
		int cla ;
		String sql = "";
		double score = 0;
		// 1、拼接sql语句
		sql = "insert into yigu_score values (null,1,3,67)";
		for(stu = 1; stu < 13; stu ++){
			
			for(cla = 1; cla < 7; cla ++){
				// 随机生成学生成绩 (40，100)
				score = random.nextInt(60) + 40; 
				if(score%3 == 1){
					score += 0.5;
				}
				sql = sql + ",(null," + stu + "," + cla +"," + score +")";
			}
		}
		// 查看sql语句
		 System.out.println(sql);
		// 2、执行sql
		DBUtil dbUtil = new DBUtil();
		dbUtil.update(sql);
	}		
}
```

##### 3、删除学生id 和课程id 重复的数据

```mysql
-- 去重sql语句 
DELETE FROM yigu_score
WHERE (student_id, class_id)
IN (
    SELECT * FROM (
        SELECT ys.`student_id`, ys.`class_id`
        FROM yigu_score ys
        GROUP BY ys.`student_id`, ys.`class_id`
        HAVING COUNT(*) > 1 
    ) tab1
)
AND score_id NOT IN(
    SELECT * FROM (
        SELECT MIN(ys2.`score_id`) AS id
        FROM yigu_score ys2
        GROUP BY ys2.`student_id`, ys2.`class_id`
        HAVING COUNT(*) > 1
    ) tab2
);
```





