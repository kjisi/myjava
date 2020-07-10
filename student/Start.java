import java.util.Scanner;

public class Start{
	
	private static Scanner scanner = new Scanner(System.in);
	private static StudentController studentController = new StudentController();
	
	public static void main(String[] args)throws Exception{
		
		boolean run = true;
		int choice ;
		while(run){
			// 1��ѡ�����	
			System.out.println("|--------ѧ����Ϣ��ѯ--------|");
			System.out.println("|----��ѡ������Ҫ�Ĳ�����    |");
			System.out.println("|----��ѯ����ѧ����1         |");
			System.out.println("|----���ݿγ̲�ѯ��2         |");
			System.out.println("|----����ѧ����ѯ��3         |");
			System.out.println("|----�˳���9                 |");
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
				System.out.println("����������������������");
			}
		}
		System.out.println("��ǣ�");
	}
	
	// ��ѯ����ѧ��
	public static void queryAll()throws Exception{
		boolean run = true;
		int choice ;
		while(run){
		System.out.println("|-----1����ѯ����ѧ��--------|");
		System.out.println("|                            |");
		System.out.println("|----��ѡ������Ҫ�Ĳ�����    |");
		System.out.println("|----��ѯ��ϸ�б�    1     |");
		System.out.println("|----��ѯ�ܳɼ���      2     |");
		System.out.println("|----��ѯ�ܳɼ���߷֣�3     |");
		System.out.println("|----��ѯ�ܳɼ�ƽ���֣�4     |");
		System.out.println("|----���أ�            9     |");
		System.out.println("|----------------------------|");
		
		choice = scanner.nextInt();
		
		if(choice == 1)
			studentController.findAll();
		else if(choice == 2)
			studentController.totalScore();
		else if(choice == 3)
			studentController.maxScores();
		else if(choice == 4){
			System.out.println("��ѡ���Ƿ�����ֵ��(true/false)");
			boolean bool = scanner.nextBoolean();
			studentController.averageScore(bool);
		}
		else if(choice == 9)
			run = !run ;
		else
			System.out.println("����������������������");
		}
	}
	
	// ���տγ̲�ѯ
	public static void queryByClass()throws Exception{
		boolean run = true;
		int choice ;
		String className = "";
		while(run){
		System.out.println("|-----1����ѯ����ѧ��--------|");
		System.out.println("|                            |");
		System.out.println("|----��ѡ������Ҫ�Ĳ�����    |");
		System.out.println("|----��ѯѧ�Ƴɼ��б�1     |");
		System.out.println("|----��ѯѧ�Ƶ��ܳɼ���2     |");
		System.out.println("|----�ܷ���ߵ�ѧ�ƣ�  3     |");
		System.out.println("|----ѧ���ֵܷ�ƽ���֣�4     |");
		System.out.println("|----��ѧ�Ƴɼ���ߣ�  5     |");
		System.out.println("|----ѧ���ֵܷ�ƽ���֣�6     |");
		System.out.println("|----���أ�            9     |");
		System.out.println("|----------------------------|");
		
		choice = scanner.nextInt();
		
		if(choice == 1){
			System.out.println("��������Ҫ��ѯ��ѧ�ƣ�(chinese��math��english��physics��chemistry��biology)");
			scanner.nextLine(); // �������з�
			className = scanner.nextLine();
			
			studentController.classScore(className);
		}
		else if(choice == 2) 
			studentController.classTotalScores();
		else if(choice == 3)
			studentController.maxClassTotalScore();
		else if(choice == 4)
		{
			System.out.println("��ѡ���Ƿ�����ֵ��(true/false)");
			boolean bool = scanner.nextBoolean();
			
			studentController.averageClassTotalScore(bool);
		}
		else if(choice == 5)
		{
			System.out.println("��������Ҫ��ѯ��ѧ�ƣ�(chinese��math��english��physics��chemistry��biology)");
			scanner.nextLine(); // �������з�
			className = scanner.nextLine();
			
			studentController.maxClassScore(className);
		}
		else if(choice == 6)
		{
			System.out.println("��������Ҫ��ѯ��ѧ�ƣ�(chinese��math��english��physics��chemistry��biology)");
			scanner.nextLine(); // �������з�
			className = scanner.nextLine();
			System.out.println("��ѡ���Ƿ�����ֵ��(true/false)");
			boolean bool = scanner.nextBoolean();
			
			studentController.averageClassScoreWithEnds(className, bool);		
		}
		else if(choice == 9)
			run = !run ;
		else
			System.out.println("����������������������");
		}
	}
	
	// ����ѧ����ѯ
	public static void queryByStudent()throws Exception{
		boolean run = true;
		int choice ;
		String studentName = "";
		while(run){
		System.out.println("|-----1����ѯ����ѧ��--------|");
		System.out.println("|                            |");
		System.out.println("|----��ѡ������Ҫ�Ĳ�����    |");
		System.out.println("|----��ѯѧ���ĳɼ���  1     |");
		System.out.println("|----��ѯѧ����߳ɼ���2     |");
		System.out.println("|----��ѯѧ��ƽ���ɼ���3     |");
		System.out.println("|----���أ�            9     |");
		System.out.println("|----------------------------|");
		
		choice = scanner.nextInt();
		
		if(choice == 1){
			System.out.println("��������Ҫ��ѯ��ѧ����");
			scanner.nextLine(); // �������з�
			studentName = scanner.nextLine();
			
			studentController.studentScore(studentName);
		}
		else if(choice == 2)
		{
			System.out.println("��������Ҫ��ѯ��ѧ����");
			scanner.nextLine(); // �������з�
			studentName = scanner.nextLine();
			
			studentController.maxStudentScore(studentName);
		}
		else if(choice == 3)
		{
			System.out.println("��������Ҫ��ѯ��ѧ����");
			scanner.nextLine(); // �������з�
			studentName = scanner.nextLine();
			
			System.out.println("��ѡ���Ƿ�����ֵ��(true/false)");
			boolean bool = scanner.nextBoolean();
			
			studentController.averageStudentScoreWithEnds(studentName,bool);
		}
		else if(choice == 9)
			run = !run ;
		else
			System.out.println("����������������������");
		}
	}
}