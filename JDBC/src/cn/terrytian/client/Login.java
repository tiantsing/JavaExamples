package cn.terrytian.client;

import java.util.Scanner;

import cn.terrytian.entity.Users;
import cn.terrytian.service.DoLogin;

public class Login {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�������û�����");
		String name = input.nextLine();
		System.out.println("���������룺");
		String pwd = input.nextLine();
		
		DoLogin dl = new DoLogin();
		Users user = dl.findUser(name, pwd);//���ò�ѯ�û��ķ���
		if(user!=null){
			System.out.println("��ӭ�㣺"+user.getName());
		}else{
			System.out.println("�û������������");
		}

	}

}
