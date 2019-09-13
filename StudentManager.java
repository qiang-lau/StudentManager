package StudentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
//创建集合对象用于存储
        ArrayList<Student> array = new ArrayList<Student>();

//主界面的编写
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            switch (line) {//line为字符串 JDK7后是可以的
                case "1":
                    //System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
                    //System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
                    upsateStudent(array);
                    //System.out.println("修改学生");
                    break;
                case "4":
                    //System.out.println("查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    //break;
                    System.exit(0);//JVM退出
            }
        }
    }

    public static boolean isused(ArrayList<Student> array, String sid) {
        boolean flag = false;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //添加学生方法
    public static void addStudent(ArrayList<Student> array) {
        //键盘录入学生对象
        Scanner sc = new Scanner(System.in);
        String sid;
        while(true) {
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();

            boolean flag = isused(array, sid);
            if (flag) {
                System.out.println("你输入的学号已经被使用，请重新输入！");
            }else{
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();

        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();

        System.out.println("请输入学生地址：");
        String address = sc.nextLine();

        //创建学生对象
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        array.add(s);

        System.out.println("添加学生成功");
    }

    //查看所有学生
    public static void findAllStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
            return;
        }
        System.out.println("学号\t姓名\t年龄\t居住地");///\t指Tab键的意思
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAddress());
        }
    }

    //删除指定学生
    public static void deleteStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入删除学生的学号：");
        String sid = sc.nextLine();

        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //if(s.getSid() == sid){}
            if (s.getSid().equals(sid)) {//字符串内容比较
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该信息不存在，请重新出入！");
        } else {
            array.remove(index);
            System.out.println("删除学生成功！");
        }
    }

    //修改学生信息
    public static void upsateStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要修改学生学号：");
        String sid = sc.nextLine();

        System.out.println("请输入学生新姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生新年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生新居住地：");
        String address = sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student ss = array.get(i);
            if (ss.getSid().equals(sid)) {
                array.set(i, s);
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该信息不存在，请重新出入！");
        } else {
            System.out.println("修改学生成功！");
        }
    }
}
