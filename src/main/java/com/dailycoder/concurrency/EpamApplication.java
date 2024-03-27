package com.dailycoder.concurrency;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
        int id;
        String name;
        int age;
        String gender;
        String department;
        int yearOfJoining;
        double salary;


public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';
    }
}


class Queue{

    int val;
    int size;
    int[] arr;

    int lastIndex = 0;

    public Queue(int size){
        this.size = size;
        arr = new int[size];
    }


    public void push(int x){
        //check if array is full to avoid ArrayIndex out of Bound exception
        if(this.lastIndex<size){
            arr[lastIndex] = x;
            lastIndex++;
        }
    }


    public int remove(){

        if(this.lastIndex==0){
            throw new UnsupportedOperationException("Queue is already empty");
        }
        int valueRemved = arr[0];
        //re assign the reference
        //[ 1 2 3] => [2  3 null]
        for(int i=1;i<size-1;++i){
            arr[i-1] = arr[i];

        }
        this.lastIndex--;
        return valueRemved;

    }

    public void print(){
       for (int i=0;i<size;++i){
           System.out.print(this.arr[i]+" ");
       }
       System.out.println();
    }
}

@SpringBootApplication
public class EpamApplication {

    public static List<Employee> employeesHavingMoreThanAverageSalary(List<Employee> employees){

        Map<Object,Double> employeeAverage   =  employees.stream().collect(Collectors.groupingBy(x->x.department,Collectors.averagingDouble(x->x.salary)));
        employees.stream().filter(x->x.salary>employeeAverage.get(x.department)).forEach(System.out::println);


       return new ArrayList<>();

    }

//    public void commonAmongAllArrays(int[] arr)

//    public void compare(int[] arr,int)


    public static void main(String[] args) {


//        List<Employee> employeeList = new ArrayList<Employee>();
//
//        employeeList.add(new Employee(111, "A", 32, "Female", "HR", 2011, 25000.0));
//
//        employeeList.add(new Employee(122, "B", 25, "Male", "Sales And Marketing", 2015, 13500.0));
//
//        employeeList.add(new Employee(133, "C", 29, "Male", "Infrastructure", 2012, 18000.0));
//
//        employeeList.add(new Employee(144, "D", 28, "Male", "Product Development", 2014, 32500.0));
//
//        employeeList.add(new Employee(155, "E", 27, "Female", "HR", 2013, 22700.0));
//
//        employeeList.add(new Employee(166, "F", 43, "Male", "Security And Transport", 2016, 10500.0));
//
//        employeeList.add(new Employee(177, "G", 35, "Male", "Account And Finance", 2010, 27000.0));
//
//        employeeList.add(new Employee(188, "H", 31, "Male", "Product Development", 2015, 34500.0));
//
//        employeeList.add(new Employee(199, "I", 24, "Female", "Sales And Marketing", 2016, 11500.0));
//
//        employeeList.add(new Employee(200, "J", 38, "Male", "Security And Transport", 2015, 11000.5));
//
//        employeeList.add(new Employee(211, "K", 27, "Female", "Infrastructure", 2014, 15700.0));
//
//        employeeList.add(new Employee(222, "L", 25, "Male", "Product Development", 2016, 28200.0));
//
//        employeeList.add(new Employee(233, "M", 27, "Female", "Account And Finance", 2013, 21300.0));
//
//        employeeList.add(new Employee(244, "N", 24, "Male", "Sales And Marketing", 2017, 10700.5));
//
//        employeeList.add(new Employee(255, "O", 23, "Male", "Infrastructure", 2018, 12700.0));
//
//        employeeList.add(new Employee(266, "P", 26, "Female", "Product Development", 2015, 28900.0));
//
//        employeeList.add(new Employee(277, "Q", 31, "Male", "Product Development", 2012, 35700.0));
//
//        employeesHavingMoreThanAverageSalary(employeeList);
//
        int ar1[] = { 1, 5, 10, 20, 40, 80 };


        int ar2[] = { 5, 6, 7, 20, 30, 40, 50, 80 };

        int ar3[] = { 3, 4, 15, 20, 30, 40, 50, 60, 77, 80 };

        int ar4[] = { 3, 4, 15, 20, 30, 40, 50, 60, 77,78,79, 80 };

        int ar5[] = { 3, 4, 15, 20, 30, 40, 50, 60,64,65,69, 77,78,79, 80 };

        //check Max size
        int maxSize = Integer.MIN_VALUE;

        for(int i=0;i< ar1.length;++i){
            maxSize = Math.max(ar1[i],maxSize);
        }

//        System.out.println(maxSize);

        int[] tempArr = new int[maxSize+1]; // calculate the arr

        for (int i=0;i<ar1.length;++i){
            tempArr[ar1[i]]++;
        }

       for (int i=0;i<ar2.length;++i){
           if(ar2[i]>maxSize)
               continue;

           tempArr[ar2[i]]++;
       }

       System.out.println(Arrays.toString(tempArr));

       for(int i=0;i<tempArr.length;++i){

           if(tempArr[i]==2){
               System.out.println(i);
           }
       }


//        for (int i=0;i<ar3.length;++i){
//            if(ar3[i]>maxSize)
//                continue;
//
//            tempArr[ar3[i]]++;
//        }
//
//        for (int i=0;i<ar4.length;++i){
//            if(ar4[i]>maxSize)
//                continue;
//
//            tempArr[ar4[i]]++;
//        }
//
//        for (int i=0;i<ar5.length;++i){
//            if(ar5[i]>maxSize)
//                continue;
//
//            tempArr[ar5[i]]++;
//        }



    }

}
