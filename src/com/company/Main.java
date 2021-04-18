package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Random rnd = new Random();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<10;i++){
            list.add(rnd.nextInt(1000-100)+100); //int result = r.nextInt(high-low) + low;
        }

        System.out.println("Unsorted list");
            for(Object o:list){
                System.out.print(o+" ");
            }

        System.out.println("\n\nSorted list with Collections.sort(list); ");
        Collections.sort(list);
            for(Object o:list){
                System.out.print(o+" ");
            }

        System.out.println("\n\nSorted list with predefined Comparator logic; ");
        Comparator<Integer> comparator = new ComparatorImplementation();
        Collections.sort(list,comparator);
        //Sort by the last digit
            for(Object o:list){
                System.out.print(o+" ");
            }

        System.out.println("\n\nSorted list with predefined Comparator logic using anonyomousclass");
            Comparator<Integer> comparatorAnonymous = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1%100>o2%100)
                        return 1;
                    return -1;
                }
            };
            //Sort by last 2 digits
            Collections.sort(list,comparatorAnonymous);
                for(Object o:list){
                    System.out.print(o+" ");
                }

        System.out.println("\n\n Sorted list using lambda expression");
           Comparator<Integer> comparatorLambda = (o1, o2) -> {
//               if(o1%1000>o2%1000)
//                   return 1;
//               return -1;
//               ---------->Ternaly operator<-------------
               return o1%1000>o2%1000?1:-1;
           };
           //Sort by first digit
            Collections.sort(list,comparatorLambda);
            for(Object o:list){
                System.out.print(o+" ");
            }

    }
}

class ComparatorImplementation implements Comparator<Integer>{

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     * <p>
     * The implementor must ensure that {@code sgn(compare(x, y)) ==
     * -sgn(compare(y, x))} for all {@code x} and {@code y}.  (This
     * implies that {@code compare(x, y)} must throw an exception if and only
     * if {@code compare(y, x)} throws an exception.)<p>
     * <p>
     * The implementor must also ensure that the relation is transitive:
     * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
     * {@code compare(x, z)>0}.<p>
     * <p>
     * Finally, the implementor must ensure that {@code compare(x, y)==0}
     * implies that {@code sgn(compare(x, z))==sgn(compare(y, z))} for all
     * {@code z}.<p>
     * <p>
     * It is generally the case, but <i>not</i> strictly required that
     * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
     * any comparator that violates this condition should clearly indicate
     * this fact.  The recommended language is "Note: this comparator
     * imposes orderings that are inconsistent with equals."<p>
     * <p>
     * In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     */
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1%10>o2%10)
            return 1;
        return -1;
    }
}
