package com.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SchoolManegement 
{
	static Connection scon=null;
	static ResultSet rs=null;
	static Statement st=null;
	static Scanner sc=new Scanner(System.in);
	static int lid;
	static String lusername;
	static int lpassword;
	static int sturollno;
	static String stuname;
	static int stuclass;
	static String stufathername;
	static String stumothername;
	static String stumedium;
	static int stufees;
	static String stufeespaidornot;
	static int tid;
	static String tname;
	static String tqualification;
	static String tsubjecttaken;
	static String tsalary;
	static int fid;
	static String fname;
	static String fplace;
	static int fprice;
	public static void Login() 
	{
		try 
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("My connection"+scon);			
			String log="select * from login where lid="+lid;
			rs=st.executeQuery(log);
			System.out.println("Enter Id");
			lid=sc.nextInt();
			if(!rs.next()) 
			{
				System.out.println("Enter UserName");
				lusername=sc.next();
				System.out.println("Enter Password");
				lpassword=sc.nextInt();
				String log1="insert into login values("+lid+",'"+lusername+"',"+lpassword+")";
				int  i1 =st.executeUpdate(log1);
				if(i1>0) 
				{
					System.out.println("Login Information Is right!!!!");
				}
			}
			else 
			{
				System.out.println("Login Information Is Wrong");
			}
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}  	
	}
	public static void StudentRecord() 
	{
		try 
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("My connection"+scon);			
			String sql="select * from student where sturollno="+sturollno;
			rs=st.executeQuery(sql);
			System.out.println("Enter Id");
			sturollno=sc.nextInt();
			if(!rs.next()) 
			{
				System.out.println("Enter Name");
				stuname=sc.next();
				System.out.println("Enter Class");
				stuclass=sc.nextInt();
				System.out.println("Enter Father Name");
				stufathername=sc.next();
				System.out.println("Enter Mother Name");
				stumothername=sc.next();
				System.out.println("Enter Medium");
				stumedium=sc.next();
				System.out.println("Enter Fees");
				stufees=sc.nextInt();
				System.out.println("Enter Fees Paid or Not");
				stufeespaidornot=sc.next();
				String student="insert into student values("+sturollno+",'"+stuname+"',"+stuclass+",'"+stufathername+"','"+stumothername+"','"+stumedium+"',"+stufees+",'"+stufeespaidornot+"')";
				int  i =st.executeUpdate(student);
				if(i>0) 
				{
					System.out.println("Student information is registered");
				}
			}
			else 
			{
				System.out.println("Id already exists");
			}
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}  	
	}
	public static void TeacherRecord() 
	{
		try 
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("My connection"+scon);			
			String sql="select * from teacher where tid="+tid;
			rs=st.executeQuery(sql);
			System.out.println("Enter Id");
			tid=sc.nextInt();
			if(!rs.next()) 
			{
				System.out.println("Enter Name");
				tname=sc.next();
				System.out.println("Enter Qualification");
				tqualification=sc.next();
				System.out.println("Enter SubjectTaken");
				tsubjecttaken=sc.next();
				System.out.println("Enter Salary");
				tsalary=sc.next();
				String teacher="insert into teacher values("+tid+",'"+tname+"','"+tqualification+"','"+tsubjecttaken+"','"+tsalary+"')";
				int  i =st.executeUpdate(teacher);
				if(i>0) 
				{
					System.out.println("Teacher information is registered");
				}
			}
			else 
			{
				System.out.println("Id already exists");
			}
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}  	
	}
	public static void StudentRecordUpdate() 
	{
		System.out.println("Enter student rollno to update record");
		int sturollno=sc.nextInt();
		scon=DbConnect.getConnection();
		try 
		{
			st=scon.createStatement();
			String sql="select * from student where sturollno="+sturollno;
			rs=st.executeQuery(sql);
			if(rs.next()) 
			{				
				System.out.println("Which field you want to update");
				System.out.println("1.To Update Name");
				System.out.println("2.To Update Class");
				System.out.println("3.To Update FatherName");
				System.out.println("4.To Update MotherName");
				System.out.println("5.To Update Medium");
				System.out.println("6.To Update Fees");
				System.out.println("7.To Update Fees Paid Or Not");
				System.out.println("8.To Update Name And Class");
				System.out.println("9.To Update FatherName and MotherName");
				System.out.println("10.To Update Fees and FeesPaidOrNot");
				int choice=sc.nextInt();
				switch(choice) 
				{
				case 1:System.out.println("Enter Name to change");
				String n=sc.next();
				String up="update student set stuname='"+n+"' where sturollno="+sturollno;
				int i=st.executeUpdate(up);
				if(i>0) 
				{
					System.out.println("Name is changed");
				}
				break;
				case 2:System.out.println("Enter Class to change");
				String c=sc.next();
				String up1="update student set stuclass='"+c+"' where sturollno="+sturollno;
				int i1=st.executeUpdate(up1);
				if(i1>0) 
				{
					System.out.println("Class is changed");
				}
				break;
				case 3:System.out.println("Enter FatherName to change");
				String f=sc.next();
				String up2="update student set stufathername='"+f+"' where sturollno="+sturollno;
				int i2=st.executeUpdate(up2);
				if(i2>0) 
				{
					System.out.println("FatherName is changed");
				}
				break;
				case 4:System.out.println("Enter MotherName to change");
				String m=sc.next();
				String up3="update student set stumothername='"+m+"' where sturollno="+sturollno;
				int i3=st.executeUpdate(up3);
				if(i3>0) 
				{
					System.out.println("MotherName is changed");
				}
				break;
				case 5:System.out.println("Enter Medium to change");
				String m1=sc.next();
				String up4="update student set stumedium='"+m1+"' where sturollno="+sturollno;
				int i4=st.executeUpdate(up4);
				if(i4>0) 
				{
					System.out.println("Medium is changed");
				}
				break;
				case 6:System.out.println("Enter Fees to change");
				String f1=sc.next();
				String up5="update student set stufees='"+f1+"' where sturollno="+sturollno;
				int i5=st.executeUpdate(up5);
				if(i5>0) 
				{
					System.out.println("course is changed");
				}
				break;
				case 7:System.out.println("Enter FeesPaidOrNot to change");
				String f2=sc.next();
				String up6="update student set sfeespaidornot='"+f2+"' where sturollno="+sturollno;
				int i6=st.executeUpdate(up6);
				if(i6>0) 
				{
					System.out.println("FeesPaidOrNot is changed");
				}
				break;
				case 8: System.out.println("Enter Name to change");
				String n1=sc.next();
				System.out.println("Enter Class to change");
				String c1=sc.next();
				String upnamecourse="update student set stuname='"+n1+"' , sclass='"+c1+"' where sturollno="+sturollno;
				int ncchange=st.executeUpdate(upnamecourse);
				if(ncchange>0)
				{
					System.out.println("Name and Class changed successfully");
				}
				case 9: System.out.println("Enter FatherName to change");
				String ff=sc.next();
				System.out.println("Enter MotherName to change");
				String mm=sc.next();
				String upfnamemname="update student set stumothername='"+ff+"' , stufathername='"+mm+"' where sturollno="+sturollno;
				int nc1change=st.executeUpdate(upfnamemname);
				if(nc1change>0)
				{
					System.out.println("FatherName and MotherName changed successfully");
				}
				case 10: System.out.println("Enter Fees to change");
				String fe=sc.next();
				System.out.println("Enter FeesPaidOrNot to change");
				String fe1=sc.next();
				String upfeesfeesnp="update student set stufees='"+fe+"' , stufeespaidornot='"+fe1+"' where sturollno="+sturollno;
				int nc2change=st.executeUpdate(upfeesfeesnp);
				if(nc2change>0)
				{
					System.out.println("Fees and FeesPaidOrNot changed successfully");
				}
				}
			}
			else 
			{
				System.out.println(sturollno+" not exists");
			}
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
	}
	public static void StudentRecordDelete() 
	{
		System.out.println("Enter student rollno to delete record");
		int sturollno=sc.nextInt();		
		scon=DbConnect.getConnection();
		try 
		{
			st=scon.createStatement();			
			String sql = "select * from student where sturollno="+sturollno;
			rs=st.executeQuery(sql);			
			if(rs.next()) 
			{
				String del = "delete from student where sturollno="+sturollno;
				int i=st.executeUpdate(del);
				if(i>0) 
				{
					System.out.println("The student with id "+sturollno+" is deleted");
				}
			}
			else 
			{
				System.out.println(sturollno+ " not exists in database");
			}						
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
	}
	public static void TeacherRecordUpdate() 
	{
		System.out.println("Enter teacher id to update record");
		int tid=sc.nextInt();
		scon=DbConnect.getConnection();
		try 
		{
			st=scon.createStatement();
			String sql="select * from teacher where tid="+tid;
			rs=st.executeQuery(sql);
			if(rs.next()) 
			{				
				System.out.println("Which field you want to update");
				System.out.println("1.To Update Name");
				System.out.println("2.To Update Qualification");
				System.out.println("3.To Update SubjectTaken");
				System.out.println("4.To Update Salary");
				System.out.println("5.To Update Name and Qualification");
				System.out.println("6.To Update SubjectTaken and Salary");
				int choice=sc.nextInt();
				switch(choice) 
				{
				case 1:System.out.println("Enter Name to change");
				String n=sc.next();
				String up="update teacher set tname='"+n+"' where tid="+tid;
				int i=st.executeUpdate(up);
				if(i>0) 
				{
					System.out.println("Name is changed");
				}
				break;
				case 2:System.out.println("Enter Qualification to change");
				String c=sc.next();
				String up1="update teacher set tqualification='"+c+"' where tid="+tid;
				int i1=st.executeUpdate(up1);
				if(i1>0) 
				{
					System.out.println("Qualification is changed");
				}
				break;
				case 3:System.out.println("Enter SubjectTaken to change");
				String f=sc.next();
				String up2="update teacher set tsubjecttaken='"+f+"' where tid="+tid;
				int i2=st.executeUpdate(up2);
				if(i2>0) 
				{
					System.out.println("SubjectTaken is changed");
				}
				break;
				case 4:System.out.println("Enter Salary to change");
				String m=sc.next();
				String up3="update teacher set tsalary='"+m+"' where tid="+tid;
				int i3=st.executeUpdate(up3);
				if(i3>0) 
				{
					System.out.println("Salary is changed");
				}
				break;
				case 5: System.out.println("Enter Name to change");
				String n1=sc.next();
				System.out.println("Enter Qualification to change");
				String c1=sc.next();
				String upnamequalification="update teacher set tname='"+n1+"' , tqualification='"+c1+"' where tid="+tid;
				int ncchange=st.executeUpdate(upnamequalification);
				if(ncchange>0)
				{
					System.out.println("Name and Qualification changed successfully");
				}
				case 6: System.out.println("Enter SubjectTaken to change");
				String ff=sc.next();
				System.out.println("Enter Salary to change");
				String mm=sc.next();
				String upsubjectsal="update teacher set tsubjecttaken='"+ff+"' , tsalary='"+mm+"' where tid="+tid;
				int nc1change=st.executeUpdate(upsubjectsal);
				if(nc1change>0)
				{
					System.out.println("SubjectTaken and Salary changed successfully");
				}
				}
			}
			else 
			{
				System.out.println(tid+" not exists");
			}
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
	}
	public static void TeacherRecordDelete() 
	{
		System.out.println("Enter teacher id to delete record");
		int tid=sc.nextInt();		
		scon=DbConnect.getConnection();
		try 
		{
			st=scon.createStatement();			
			String sql1 = "select * from teacher where tid="+tid;
			rs=st.executeQuery(sql1);			
			if(rs.next()) 
			{
				String del = "delete from teacher where tid="+tid;
				int i1=st.executeUpdate(del);
				if(i1>0) 
				{
					System.out.println("The teacher with id "+tid+" is deleted");
				}
			}
			else 
			{
				System.out.println(tid+ " not exists in database");
			}						
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	public static void FundRecord() 
	{
		try 
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("My connection"+scon);			
			String sql1="select * from fund where fid="+fid;
			rs=st.executeQuery(sql1);
			System.out.println("Enter Id");
			fid=sc.nextInt();
			if(!rs.next()) 
			{
				System.out.println("Enter Name");
				fname=sc.next();
				System.out.println("Enter Place");
				fplace=sc.next();
				System.out.println("Enter Price");
				fprice=sc.nextInt();
				String fun="insert into fund values("+fid+",'"+fname+"','"+fplace+"',"+fprice+")";
				int i1 =st.executeUpdate(fun);
				if(i1>0) 
				{
					System.out.println("Fun information is registered");
				}
			}
			else 
			{
				System.out.println("Already exists");
			}
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}  	
	}
	public static void FundRecordUpdate() 
	{
		System.out.println("Enter fund id to update record");
		int fid=sc.nextInt();
		scon=DbConnect.getConnection();
		try 
		{
			st=scon.createStatement();
			String sql="select * from fund where fid="+fid;
			rs=st.executeQuery(sql);
			if(rs.next()) 
			{				
				System.out.println("Which field you want to update");
				System.out.println("1.To Update Name");
				System.out.println("2.To Update Place");
				System.out.println("3.To Update Price");
				System.out.println("4.To Update Place and Price");
				int choice=sc.nextInt();
				switch(choice) 
				{
				case 1:System.out.println("Enter Name to change");
				String n=sc.next();
				String up="update fund set fname='"+n+"' where fid="+fid;
				int i=st.executeUpdate(up);
				if(i>0) 
				{
					System.out.println("Name is changed");
				}
				break;
				case 2:System.out.println("Enter place to change");
				String p=sc.next();
				String up1="update fund set fplace='"+p+"' where fid="+fid;
				int i1=st.executeUpdate(up1);
				if(i1>0) 
				{
					System.out.println("Place is changed");
				}
				break;
				case 3:System.out.println("Enter Price to change");
				String f=sc.next();
				String up2="update fund set fprice='"+f+"' where fid="+fid;
				int i2=st.executeUpdate(up2);
				if(i2>0) 
				{
					System.out.println("Price is changed");
				}
				break;
				case 4: System.out.println("Enter Place to change");
				String p1=sc.next();
				System.out.println("Enter Price to change");
				String p2=sc.next();
				String upplaceprice="update fund set fplace='"+p1+"' , fprice='"+p2+"' where fid="+fid;
				int ncchange=st.executeUpdate(upplaceprice);
				if(ncchange>0)
				{
					System.out.println("Place and Price changed successfully");
				}
				}
			}
			else 
			{
				System.out.println(fid+" not exists");
			}
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
	}
	public static void FundRecordDelete() 
	{
		System.out.println("Enter Fund id to delete record");
		int fid=sc.nextInt();		
		scon=DbConnect.getConnection();
		try 
		{
			st=scon.createStatement();			
			String sql1 = "select * from fund where fid="+fid;
			rs=st.executeQuery(sql1);			
			if(rs.next()) 
			{
				String del = "delete from fund where fid="+fid;
				int i1=st.executeUpdate(del);
				if(i1>0) 
				{
					System.out.println("The teacherfund with id "+fid+" is deleted");
				}
			}
			else 
			{
				System.out.println(fid+ " not exists in database");
			}						
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public static void ViewRecords() 
	{	
		System.out.println("Which field you want to select");
		System.out.println("1.Show Student Records");
		System.out.println("2.Show Teacher Records");
		System.out.println("3.Show Fund Records");	
		scon=DbConnect.getConnection();
		int choice=sc.nextInt();
		switch(choice) 
		{
		case 1:System.out.println("STUDENT RECORD");
		try
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();			
			String sql="select * from student";
			rs=st.executeQuery(sql);	
			System.out.println("Rollno\tName\tClass\tFathername\tMothername\tMedium\tFees\tFeespaidornot");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(7)+"\t"+rs.getString(8));
			}			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		break;
		case 2:System.out.println("TEACHER RECORD");
		try
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();			
			String sql1="select * from teacher";
			rs=st.executeQuery(sql1);	
			System.out.println("Id\tName\tQualification\tSubjecttaken\tSalary");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));
			}			
		}
		catch(Exception e1) 
		{
			e1.printStackTrace();
		}
		break;
		case 3:System.out.println("Fund RECORD");
		try
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();			
			String sql2="select * from fund";
			rs=st.executeQuery(sql2);	
			System.out.println("Id\tName\tPlace\tPrice");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}			
		}

		catch(Exception e) 
		{
			e.printStackTrace();
		}

		break;
		default:System.out.println("INVALID CHOICE");
		}
	}
}




