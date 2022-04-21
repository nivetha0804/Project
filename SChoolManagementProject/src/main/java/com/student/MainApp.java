package com.student;

import java.util.Scanner;

public class MainApp 
{
	public static void main(String[] args)
	{
		//Menu from user
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("*****SCHOOL MANAGEMENT SYSTEM*****");
			System.out.println("Enter Your Record Choice");
			System.out.println("1.Login");
			System.out.println("2.Student Record");
			System.out.println("3.Teacher Record");
			System.out.println("4.Student Record Update");
			System.out.println("5.Student Record Delete");
			System.out.println("6.Teacher Record Update");
			System.out.println("7.Teacher Record Delete");
			System.out.println("8.Fund Record");
			System.out.println("9.Fund Record Update");
			System.out.println("10.Fund Record Delete");
			System.out.println("11.View Records");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:SchoolManegement.Login();
			break;
			case 2:SchoolManegement.StudentRecord();
			break;
			case 3:SchoolManegement.TeacherRecord();
			break;
			case 4:SchoolManegement.StudentRecordUpdate();
			break;
			case 5:SchoolManegement.StudentRecordDelete();
			break;
			case 6:SchoolManegement.TeacherRecordUpdate();
			break;
			case 7:SchoolManegement.TeacherRecordDelete();
			break;
			case 8:SchoolManegement.FundRecord();
			break;
			case 9:SchoolManegement.FundRecordUpdate();
			break;
			case 10:SchoolManegement.FundRecordDelete();
			break;
			case 11:SchoolManegement.ViewRecords();
			break;
			default:System.out.println("INVALID CHOICE");
			}//switch
			System.out.println("DO YOU WANT TO CONTINUE y/n");
			String choice=sc.next();
			if(choice.equalsIgnoreCase("n"))
			{
				break;
			}//if
		}//while loop
		System.out.println("Program terminated");
		sc.close();
	}//main
}//mainapp

