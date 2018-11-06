package collectioncomparison;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MyCollections {


        void getProcessed(List<Integer> myList1){
            Random r = new Random();
            int counter=0;
            long createStart=System.currentTimeMillis();
            System.out.println("Time stamp " +createStart);
            long interception=createStart+1;


            while(System.currentTimeMillis()<interception){
                myList1.add(counter,r.nextInt(100));
                System.out.println("Time "+System.currentTimeMillis()+ " " +counter+ " element  " + myList1.get(counter));
                counter++;
            }

            System.out.println("End Time " +System.currentTimeMillis());



            for (int i = counter; i <1_000_000; i++) {

                Integer value = r.nextInt(100);
                myList1.add(i,value);


            }

            long createEnd=System.currentTimeMillis();
            System.out.println("Created "+counter+ " elements for 1 ms");
            System.out.println("Created entire array: "+(createEnd-createStart)+ " ms");




            long removeStart=System.currentTimeMillis();

            myList1.remove(myList1.size() - 1);
            myList1.remove(0);
            myList1.remove(789654);
            myList1.remove(555555);
            myList1.remove(101888);
            myList1.remove(91000);


            long removeEnd=System.currentTimeMillis();
            System.out.println("Removed 6 elements for: "+(removeEnd-removeStart)+ " ms");

            long addStart=System.currentTimeMillis();
            for (int i = 0; i <6 ; i++) {
                r = new Random();
                int index=r.nextInt(900000+i);

                myList1.add(index,i);
            }
            long addEnd=System.currentTimeMillis();
            System.out.println("Inserted 6 random elements for: "+(addEnd-addStart)+ " ms");



        }

        public static void main(String[] args) {

            List<Integer> myList=new ArrayList<Integer>();
            List<Integer> myList1=new LinkedList<Integer>();

            MyCollections myA=new MyCollections();
            MyCollections myB=new MyCollections();

            System.out.println("Measuring ArrayList");
            System.out.println();

            try {
                myA.getProcessed(myList);


                System.out.println();


                System.out.println("Measuring LinkedList");
                System.out.println();

                myB.getProcessed(myList1);
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("IndexOutOfBoundsException has been cought");
                System.out.println(e.getMessage());
            }

        }


    }



