#### 学生成绩查询升级：

所有集合遍历使用Stream操作

所有循环，使用forEach()操作



##### 1、StudentDaoImpl

```java
1、List<Student> findAll()
    // forEach 遍历List
    students.forEach((Student student) -> System.out.println(student));

2、List<Student> findByClassName(String className)
    students.forEach( (Student student) -> System.out.println(student));

2、List<Student> findByStudentName(String className)
    students.forEach( (Student student) -> System.out.println(student));
```



##### 2、StudentServiceImpl

```java
1、Map<String, Double> allScore()  // 第一个方法
    // Stream 流遍历List
    students.stream().forEach( streamStudent -> scores.put(streamStudent.getStudent_name() + "," + streamStudent.getClass_name(),streamStudent.getScore()));

2、String maxTotalScore() // 第三个方法
    // Stream流获取总分最高分的值
    Double max = totalScores.values().stream()
		.max(Comparator.naturalOrder()).get();
		
	// 使用stream流获取最高成绩学生 的信息
	List<String> names = totalScores.entrySet().stream()
		.filter(entry -> entry.getValue() == max)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList()) ;
    
3、averageTotalScoreWithEnds(boolean bool) // 第四个方法
    // Stream流获取总分的数组
	Double[] scores = totalScores.values().stream().toArray(Double[]::new);

4、maxClassTotalScore() //第六个方法
    // Stream流，查询总分最大值
	Double maxScore = classTotalScores.values().stream()
		.max(Comparator.naturalOrder()).get();
		
	// Stream流，获取总分最高学科名的集合
	List<String> names = classTotalScores.entrySet().stream()
		.filter(entry -> entry.getValue() == maxScore)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());

5、averageClassTotalScoreWithEnds(boolean bool) // 第七个方法
    // Strem流，获取map集合value值对应的数组
    Double[] scoresArray = classTotalScores.values().stream().toArray(Double[]::new);

6、classScore(String className) // 第八个方法
    Map<String, Double> scores = new LinkedHashMap<String, Double>();
	// Stream流，取student的信息存放的Map中
	students.stream().forEach( student -> {
			
	        String nameAndClass = student.getStudent_name() + "," + student.getClass_name();
			scores.put(nameAndClass,student.getScore());
		});

7、 maxClassScore(String className) // 第九个方法
    // Stream 取student 对象，分数的最大值
	Double maxScore = students.stream().map(student -> student.getScore()).max(Comparator.naturalOrder()).get();
	// Stream流，取最大分数对应的student 的集合
	List<Student> maxStudent = students.stream().filter(student -> student.getScore() == maxScore).collect(Collectors.toList());

8、Double averageClassScoreWithEnds(String className, boolean bool) // 第十个方法
    // Stream流取 某个属性的数组
	Double[] scores = students.stream().map(student -> student.getScore()).toArray(Double[]::new);

9、Map<String, Double> studentScore(String studentName) // 第十一个方法
    // Stream流，取学生信息，存放到map中
	Map<String, Double> scores = new LinkedHashMap<String, Double>();
	students.stream().forEach(student -> {
		scores.put(student.getStudent_name() + "," + student.getClass_name(), student.getScore()); 
		});

10、 String maxStudentScore(String studentName)  // 第十二个方法
    // Stream流获取学生的最高分
	Double maxScore = students.stream().map(student -> student.getScore()).max(Comparator.naturalOrder()).get();
	List<Student> maxStudent = students.stream().filter(student -> student.getScore() == maxScore).collect(Collectors.toList());
    
11、Double averageStudentScoreWithEnds(String studentName, boolean bool)   // 第十三个方法
   // Stream流获取某个属性的数组 
   Double[] scores = students.stream().map(student -> student.getScore()).toArray(Double[]::new);


```

