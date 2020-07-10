import java.util.Scanner;

public class Start{
	
	private static Scanner scanner = new Scanner(System.in);
	private static StudentController studentController = new StudentController();
	
	public static void main(String[] args)throws Exception{
		
		boolean run = true;
		int choice ;
		while(run){
			// 1、选择操作	
			System.out.println("|--------学生信息查询--------|");
			System.out.println("|----请选择你想要的操作：    |");
			System.out.println("|----查询所有学生：1         |");
			System.out.println("|----根据课程查询：2         |");
			System.out.println("|----根据学生查询：3         |");
			System.out.println("|----退出：9                 |");
			System.out.println("|----------------------------|");
				
			choice = scanner.nextInt();
			
			if(choice == 1)
				queryAll();
			else if (choice == 2)
				queryByClass();
			else if(choice == 3)
				queryByStudent();
			else if(choice == 9)
				run = ! run;
			else{
				System.out.println("您的输入有误请重新输入");
			}
		}
		System.out.println("告辞！");
	}
	
	// 查询所有学生
	public static void queryAll()throws Exception{
		boolean run = true;
		int choice ;
		while(run){
		System.out.println("|-----1、查询所有学生--------|");
		System.out.println("|                            |");
		System.out.println("|----请选择你想要的操作：    |");
		System.out.println("|----查询详细列表：    1     |");
		System.out.println("|----查询总成绩：      2     |");
		System.out.println("|----查询总成绩最高分：3     |");
		System.out.println("|----查询总成绩平均分：4     |");
		System.out.println("|----返回：            9     |");
		System.out.println("|----------------------------|");
		
		choice = scanner.nextInt();
		
		if(choice == 1)
			studentController.findAll();
		else if(choice == 2)
			studentController.totalScore();
		else if(choice == 3)
			studentController.maxScores();
		else if(choice == 4){
			System.out.println("请选择是否丢弃最值：(true/false)");
			boolean bool = scanner.nextBoolean();
			studentController.averageScore(bool);
		}
		else if(choice == 9)
			run = !run ;
		else
			System.out.println("您的输入有误请重新输入");
		}
	}
	
	// 按照课程查询
	public static void queryByClass()throws Exception{
		boolean run = true;
		int choice ;
		String className = "";
		while(run){
		System.out.println("|-----1、查询所有学生--------|");
		System.out.println("|                            |");
		System.out.println("|----请选择你想要的操作：    |");
		System.out.println("|----查询学科成绩列表：1     |");
		System.out.println("|----查询学科的总成绩：2     |");
		System.out.println("|----总分最高的学科：  3     |");
		System.out.println("|----学科总分的平均分：4     |");
		System.out.println("|----本学科成绩最高：  5     |");
		System.out.println("|----学科总分的平均分：6     |");
		System.out.println("|----返回：            9     |");
		System.out.println("|----------------------------|");
		
		choice = scanner.nextInt();
		
		if(choice == 1){
			System.out.println("请输入想要查询的学科：(chinese、math、english、physics、chemistry、biology)");
			scanner.nextLine(); // 丢弃换行符
			className = scanner.nextLine();
			
			studentController.classScore(className);
		}
		else if(choice == 2) 
			studentController.classTotalScores();
		else if(choice == 3)
			studentController.maxClassTotalScore();
		else if(choice == 4)
		{
			System.out.println("请选择是否丢弃最值：(true/false)");
			boolean bool = scanner.nextBoolean();
			
			studentController.averageClassTotalScore(bool);
		}
		else if(choice == 5)
		{
			System.out.println("请输入想要查询的学科：(chinese、math、english、physics、chemistry、biology)");
			scanner.nextLine(); // 丢弃换行符
			className = scanner.nextLine();
			
			studentController.maxClassScore(className);
		}
		else if(choice == 6)
		{
			System.out.println("请输入想要查询的学科：(chinese、math、english、physics、chemistry、biology)");
			scanner.nextLine(); // 丢弃换行符
			className = scanner.nextLine();
			System.out.println("请选择是否丢弃最值：(true/false)");
			boolean bool = scanner.nextBoolean();
			
			studentController.averageClassScoreWithEnds(className, bool);		
		}
		else if(choice == 9)
			run = !run ;
		else
			System.out.println("您的输入有误请重新输入");
		}
	}
	
	// 按照学生查询
	public static void queryByStudent()throws Exception{
		boolean run = true;
		int choice ;
		String studentName = "";
		while(run){
		System.out.println("|-----1、查询所有学生--------|");
		System.out.println("|                            |");
		System.out.println("|----请选择你想要的操作：    |");
		System.out.println("|----查询学生的成绩：  1     |");
		System.out.println("|----查询学生最高成绩：2     |");
		System.out.println("|----查询学生平均成绩：3     |");
		System.out.println("|----返回：            9     |");
		System.out.println("|----------------------------|");
		
		choice = scanner.nextInt();
		
		if(choice == 1){
			System.out.println("请输入想要查询的学生：");
			scanner.nextLine(); // 丢弃换行符
			studentName = scanner.nextLine();
			
			studentController.studentScore(studentName);
		}
		else if(choice == 2)
		{
			System.out.println("请输入想要查询的学生：");
			scanner.nextLine(); // 丢弃换行符
			studentName = scanner.nextLine();
			
			studentController.maxStudentScore(studentName);
		}
		else if(choice == 3)
		{
			System.out.println("请输入想要查询的学生：");
			scanner.nextLine(); // 丢弃换行符
			studentName = scanner.nextLine();
			
			System.out.println("请选择是否丢弃最值：(true/false)");
			boolean bool = scanner.nextBoolean();
			
			studentController.averageStudentScoreWithEnds(studentName,bool);
		}
		else if(choice == 9)
			run = !run ;
		else
			System.out.println("您的输入有误请重新输入");
		}
	}
}