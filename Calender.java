import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * 
 */

/**
 * @author narayan
 *
 */
/**
 * @author narayan
 *
 */
public class Calender {

	/**
	 * @param args
	 */
	private long month;
	private long year;
	private static long yearDays[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	private String weekDays[]= {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
	/**
	 * @param month
	 * @param year
	 */
	public Calender(long month, long year) {
		this.month = month;
		this.year = year;
	}
	
	public long totalDays(){
		long totalDays=0;
		for(int i=1753;i<year;i++){
			if(year>=1753){
				if(i%4==0)
				{
					if(i%400==0)
						yearDays[1]=29;
					else if(i%100==0)
						yearDays[1]=28;
					else
						yearDays[1]=29;
					for(long j:yearDays){
						totalDays=totalDays+j;
					}
				}
				else{
					yearDays[1]=28;
					for(long j:yearDays){
						totalDays=totalDays+j;
					}
				}
			}
		}
		if(year<1752){
			System.out.println("Calender date cannot be found before 1753");
			System.exit(1);
		}
		if(year>=1752){
			if(year%4==0){
				if(year%400==0)
					yearDays[1]=29;
				else if(year%100==0)
					yearDays[1]=28;
				else
					yearDays[1]=29;
			}
			else{
				yearDays[1]=28;
			}
		}
		for(int k=0;k<(int)month-1;k++)
			totalDays= totalDays+yearDays[k];
		return totalDays+1;
	}
	
	public long getMonth() {
		return month;
	}
	public void setMonth(long month) {
		this.month = month;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	
	public Boolean validateDate(){
        if(month<1 || month>12){
        System.out.println("invalid month");
        return false;
        }
        else if(year<1){
        System.out.println("invalid year");
        return false;
        }
        else
        return true;
        }
	
	void printFunction(long days){
        for(int i=0;i<days;i++){
        System.out.print("     ");
        }
	}
    
	
	void displayMonth(){
		 int dayNum[] = {0,1,2,3,4,5,6};
		 String monthName[] = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		 long days;
		 String empty = "     ";
		 String spac = "    ";
		 String spac1="   ";
		 int i=0,temp;
		 long tot=totalDays();
		 days=tot%7;
		 System.out.println();
		 if(validateDate()){
			 System.out.println("       "+monthName[((int) month) - 1]+"    "+year);
			 for(String s:weekDays){
				 System.out.print(s.substring(0,3)+"  ");
			 }
				 System.out.println();
				 if(year>=1753){
					 printFunction(dayNum[(int) days]);
				 }
				 else if(year<1752){
					 System.out.println("Calender date cannot be found before 1753");
					 System.exit(1);
					
				 }
				 
					 //mysteryMonth();
				 if(year>= 1753)
					 for(i=1;i<=7-dayNum[(int) days];i++){
						 System.out.print(i+spac);
					 }
				 temp=i;
				 System.out.println();
				 for(;i<(temp+7);i++){
					 if(i<10)
						 System.out.print(i+spac);
					 else
						 System.out.print(i+spac1);
				 }
				 temp=i;
				 System.out.println();
				 for(;i<(temp+7);i++){
					 if(i<10)
						 System.out.print(i+spac);
					 else
						 System.out.print(i+spac1);
				 }
				 temp=i;
				 System.out.println();
				 for(;i<(temp+7);i++){
					 if(i<10)
						 System.out.print(i+spac);
					 else
						 System.out.print(i+spac1);
				 }
				 temp=i;
				 System.out.println();
				 for(;i<(temp+7);i++){
					 if(i<=yearDays[(int) (month-1)]){
						 if(i<10)
							 System.out.print(i+spac);
						 else
							 System.out.print(i+spac1);
					 }
				 }
				 temp=i;
				 System.out.println();
				 for(;i<(temp+7);i++){
					 if(i<=yearDays[(int) (month-1)]){
						 if(i<10)
							 System.out.print(i+spac);
						 else
							 System.out.print(i+spac1);
					 }
				 }
			
					 
		 	}
	 }


	
	 public static void main(String[] args){
		// TODO Auto-generated method stub
		long month,year;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
			int choice=0;
			System.out.println("     CALENDER     ");
			System.out.println("     ========     ");
			System.out.println("   1. MONTHLY CALENDER ");
			System.out.println("   2. YEARLY CALENDAR  ");
			System.out.println();
			System.out.print("   ENTER YOUR CHOICE :");
			choice=Integer.parseInt(br.readLine());
			switch(choice){
			case 1:{
				System.out.print("   ENTER MONTH :");
				month =Integer.parseInt(br.readLine());
				//System.out.println();
				System.out.print("   ENTER YEAR :");
				year =Integer.parseInt(br.readLine());
				System.out.println();
				Calender cal = new Calender(month,year);
				cal.displayMonth();
				break;
			}
			case 2:{
				System.out.print("   ENTER YEAR:");
				year =Integer.parseInt(br.readLine());
				System.out.println();
				for(int j=1;j<13;j++){
					Calender cal = new Calender(j,year);
					cal.displayMonth(); 
				}
				break;
			}
			default:
				System.out.println("   ENTER CORRECT OPTIONS  ");
			}
		}
		catch (NumberFormatException ne){
			System.out.println("   WRONG INPUTS");
		}
		catch(IOException ie){
			System.out.println("   BAD ARGUMENTS");
		}
	} 

}
