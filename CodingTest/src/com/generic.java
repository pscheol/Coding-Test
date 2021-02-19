package com;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.ArrayList;
import java.util.List;

public class generic {
    public static void main(String[] args) {

        ChildProduct<String, String, String> smProduct = new ChildProduct<>();
        smProduct.setKind("TV");
        smProduct.setCompany("삼성전자");
        smProduct.setModel("OLED1234");
        ChildProduct<String, String, String> lgProduct = new ChildProduct<>();
        lgProduct.setKind("TV");
        lgProduct.setCompany("LG전자");
        lgProduct.setModel("OLED5678");
        System.out.println("Product[Company=" + smProduct.getCompany() + ", kind=" + smProduct.getKind() + ", Model=" + smProduct.getModel() + "]");
        System.out.println("Product[Company=" + lgProduct.getCompany() + ", kind=" + lgProduct.getKind() + ", Model=" + lgProduct.getModel() + "]");


        Course<Person> personCourse = new Course<>("일반인 과정");
        personCourse.add(new Person("일반인"));
        personCourse.add(new Worker("직장인"));
        personCourse.add(new Student("학생"));
        personCourse.add(new HighStudent("고등학생"));

        Course<Worker> workerCourse = new Course<>("직장인 과정");
        workerCourse.add(new Worker("직장인"));
        Course<Student> studentCourse = new Course<>("학생 과정");
        studentCourse.add(new Student("학생"));
        studentCourse.add(new HighStudent("고등학"));

        Course<HighStudent> highStudentCourse = new Course<>("고등학생과정");
        highStudentCourse.add(new HighStudent("고등학생"));

        //모든과정
        registerCourse(personCourse);
        registerCourse(workerCourse);
        registerCourse(studentCourse);
        registerCourse(highStudentCourse);

        //학생
//        registerCourseStudent(personCourse); //학생만가능
//        registerCourseStudent(workerCourse); //학생만가능
        registerCourseStudent(studentCourse);
        registerCourseStudent(highStudentCourse);
        //직장인
        registerCourseWorker(personCourse);
        registerCourseWorker(workerCourse);
//        registerCourseWorker(studentCourse); //직장인 일반인만가능
//        registerCourseWorker(highStudentCourse); //직장인 일반인만가능
    }
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.set(t);
        return box;
    }
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        boolean isPairKey = p1.getKey().equals(p2.getKey());
        boolean isPairValue = p1.getValue().equals(p2.getValue());
        return isPairKey && isPairValue;
    }
    public static <T extends Number> int compare(T t1, T t2) {
        long v1 = t1.longValue();
        long v2 = t2.longValue();

        return Long.compare(v1, v2);
    }

    public static void registerCourse(Course<?> course) {
        System.out.println(course.getName() + " 수강생 : " + course.getStudents());
    }

    public static void registerCourseStudent(Course<? extends Student> course) {
        System.out.println(course.getName() + " 학생 수강생 : " + course.getStudents());
    }
    public static void registerCourseWorker(Course<? super Worker> course) {
        System.out.println(course.getName() + " 직장인 수강생 : " + course.getStudents());
    }

}

class Person {
    private String course;

    public Person(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return course;
    }
}
class Worker extends  Person {

    public Worker(String course) {
        super(course);
    }
}

class Student extends Person {
    public Student(String course) {
        super(course);
    }
}
class HighStudent extends Student {
    public HighStudent(String course) {
        super(course);
    }
}

class Course<T> {
    private String name;
    private List<T> students;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getStudents() {
        return students;
    }

    public void add(T t) {
        students.add(t);
    }
}
class Pair<K,V> {
    private K key;
    private V value;

    public Pair() {
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public void add(K key, V value) {
        this.setKey(key);
        this.setValue(value);
    }
}

class Box<T> {
    private T t;
    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return this.t;
    }
}

class Product<K, M> {
    private K kind;
    private M model;

    public Product() {
    }

    public Product(K kind, M model) {
        this.kind = kind;
        this.model = model;
    }

    public K getKind() {
        return kind;
    }

    public void setKind(K kind) {
        this.kind = kind;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }
}

class ChildProduct<K, M, C> extends Product<K, M> {
    private C company;

    public ChildProduct() {
    }

    public ChildProduct(C company) {
        this.company = company;
    }

    public C getCompany() {
        return company;
    }

    public void setCompany(C company) {
        this.company = company;
    }
}