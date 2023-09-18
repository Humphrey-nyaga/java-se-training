package com.systechafrica.part2.staticclasses;

public class MathUtils {
    public static class Geometry{
        public static  double area(double x, double y){
            return x * y;
        }
        public static  double perimeter(double x, double y){
            return (x + y) * 2;
        }
    }
    public static class Calculator{
        public static int sum(int a, int b){
            return a + b;
        }
        public static int sum(int a, int b, int c){
            return  a+ b+ c;
        }
        public static int sum(int a, int b, int...numbers){
            int sum = a +b;
            for(int num:numbers){
                sum += num;
            }
            return sum;
        }
        public static int modulus(int a, int b){
            return  a%b;
        }
    }
}
